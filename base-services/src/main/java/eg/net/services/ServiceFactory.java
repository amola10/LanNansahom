package eg.net.services;

import java.util.HashMap;

import org.omg.CORBA.SystemException;

/**
 * @author Amal.Khalil
 * @version 1.0 This class will be responsible of creating business modules
 *          instances. This class implements the singleton design patterns by
 *          caching the business modules instance into a Hash table
 */
public final class ServiceFactory {

	private static final HashMap<Class<? extends Service>, Service> SERVICES_MAP = new HashMap<Class<? extends Service>, Service>();

	/**
	 * protected Class Constructor.
	 */
	private ServiceFactory() {
		// empty constructor
	}

	/**
	 * This method will be responsible of Retrieving Service Handler instance.
	 * 
	 * @param servcieId
	 *            The Handler Service Id.
	 * @return PurchaseBillingServiceHandler handler.
	 * @throws SystemException
	 *             if the service has incorrect Configuration .
	 */

	public static Service getService(final Class<? extends Service> clazz) throws ServiceException {
		Service result = SERVICES_MAP.get(clazz);
		if (result == null) {
			try {
				result = clazz.newInstance();
				SERVICES_MAP.put(clazz, result);
			} catch (InstantiationException exception) {
				throw new ServiceException("Unable to create service of type " + clazz
						+ ". Please check that service hase a default constructor", exception);
			} catch (IllegalAccessException exception) {
				throw new ServiceException("Unable to create service of type " + clazz
						+ ". Please check security access", exception);

			}
		}
		return result;
	}
}
