package eg.net.lanNansahom;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class ApplicationContext implements BeanFactoryAware {

	private BeanFactory beanFactory;

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;

	}

	/**
	 * @return the beanFactory
	 */
	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	/**
	 * @param <T>
	 *            class
	 * @return the instance of class
	 */
	public <T> T getInstanceOf(Class<T> clazz) {
		T result = beanFactory.getBean(clazz);
		if (result == null) {
			throw new RuntimeException("Class is not configured in Spring XML files");
		}
		return result;
	}

}
