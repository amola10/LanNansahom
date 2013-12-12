package eg.net.lanNansahom.server;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class ServiceLocator.
 */
public class ServiceLocator {

	/** The context. */
	private static ServiceLocator context = new ServiceLocator();

	/** The bean factory. */
	private static BeanFactory beanFactory;

	/**
	 * Instantiates a new service locator.
	 */
	private ServiceLocator() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });
		context.setValidating(false);
		beanFactory = context.getBeanFactory();

	}

	/**
	 * Gets the single instance of ServiceLocator.
	 * 
	 * @return single instance of ServiceLocator
	 */
	public static ServiceLocator getInstance() {
		return context;
	}

	/**
	 * Gets the service.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param serviceClass
	 *            the service class
	 * @return the service
	 */
	public <T> T getService(Class<T> serviceClass) {
		return beanFactory.getBean(serviceClass);
	}

}
