package eg.net.services;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class BeansMapper {

	public static <S, T> T map(S source, T target, Class<? extends T> targetClass) {
		T result = target;
		if (source != null) {
			result = map(source, result, getIgnoredProperties(targetClass));
		}
		return result;
	}

	public static <S, T> T map(S source, Class<T> targetClass) {
		T result = null;
		if (source != null) {
			result = instantiate(targetClass);
			result = map(source, result, getIgnoredProperties(targetClass));
		}
		return result;
	}

	public static <S, T> List<T> map(List<S> sources, Class<T> targetClass) {
		List<T> result = new ArrayList<T>();
		if (sources != null) {
			for (S source : sources) {
				result.add(map(source, targetClass));
			}
		}
		return result;
	}

	private static <S, T> T map(S source, T target, String[] ignoredProperties) {
		T result = target;
		if (source != null && target != null) {
			try {
				BeanUtils.copyProperties(source, result, ignoredProperties);
				for (String ignoredProperty : ignoredProperties) {
					String propertyName = ignoredProperty.substring(0, 1).toUpperCase() + ignoredProperty.substring(1);
					Method getterMethod = BeanUtils.findMethodWithMinimalParameters(source.getClass(), "get"
							+ propertyName);
					Method setterMethod = BeanUtils.findMethodWithMinimalParameters(target.getClass(), "set"
							+ propertyName);
					if (setterMethod != null && getterMethod != null) {
						Object value = getterMethod != null ? getterMethod.invoke(source) : null;
						if (value != null) {
							setterMethod.invoke(result,
									map(getterMethod.invoke(source), setterMethod.getParameterTypes()[0]));
						}

					}

				}

			} catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		}
		return result;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T> T instantiate(Class<T> targetClass) {
		T result = null;
		if (!targetClass.isInterface()) {
			result = BeanUtils.instantiate(targetClass);
		} else if (targetClass.isAssignableFrom(List.class)) {
			result = (T) new ArrayList();
		}
		return result;
	}

	private static String[] getIgnoredProperties(Class clazz) {
		ArrayList<String> result = new ArrayList<String>();
		for (Method method : clazz.getMethods()) {
			if (method.getName().startsWith("get") && BeanUtils.isSimpleProperty(method.getReturnType()) == false) {
				String name = method.getName()
						.substring(method.getName().indexOf("get") + 3, method.getName().length());
				if (name.trim().length() > 0) {
					name = name.substring(0, 1).toLowerCase() + name.substring(1);
					result.add(name);
				}
			}
		}
		return result.toArray(new String[] {});
	}
}
