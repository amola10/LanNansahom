package eg.net;

import org.apache.log4j.Logger;
import org.omg.CORBA.SystemException;

import eg.net.services.Service;
import eg.net.services.ServiceException;
import eg.net.services.ServiceFactory;
import eg.net.services.ServiceRequest;
import eg.net.services.ServiceResponse;

/**
 * This class is the abstract class of web services. and responsible for
 * managing life cycle steps of the service and constructing its response
 * 
 * @author Amal.Khalil
 * @version 1.0
 */
public class ServiceProcessor {

	/**
	 * Class Logger Used for logging.
	 */
	private static final Logger LOGGER = Logger.getLogger(ServiceProcessor.class);

	/**
	 * This method will implement the common life cycle of all services It will
	 * be responsible of 1 -Check the system authorization 2- Handling the
	 * service life cycled 3- Complete Response common data.
	 * 
	 * @param service
	 *            The called Service .
	 * @param request
	 *            The Service Request
	 * @return response Service Response
	 * @throws ServiceException
	 *             This will be just a propagated exception
	 */
	public final ServiceResponse handleService(final Class<? extends Service> clazz, final ServiceRequest request)
			throws ServiceException {
		final long receiveTime = System.currentTimeMillis();

		try {

			// Get Suitable Service Instance.
			Service service = ServiceFactory.getService(clazz);

			return handleService(service, request);

		} catch (final ServiceException exception) {
			LOGGER.error("exception raised during service proccessing", exception);
			throw exception;
		} catch (final Throwable throwable) {
			LOGGER.error("technical exception raised during service proccessing", throwable);
			throw new ServiceException(throwable);
		}
	}

	/**
	 * This method will implement the common life cycle of all services It will
	 * be responsible of 1 -Check the system authorization 2- Handling the
	 * service life cycled 3- Complete Response common data.
	 * 
	 * @param service
	 *            The called Service .
	 * @param request
	 *            The Service Request
	 * @return response Service Response
	 * @throws ServiceException
	 *             This will be just a propagated exception
	 */
	public final ServiceResponse handleService(Service service, final ServiceRequest request) throws ServiceException {
		final long receiveTime = System.currentTimeMillis();

		try {

			// Initialize Service .

			service.initialize(request);

			// Check that the Service Request is valid.

			service.validateRequest(request);

			// Check that partner is authorized .

			service.authrizePartner(request);

			// Execute Service Handler.

			ServiceResponse response = service.execute(request);

			// Release Service Handler.

			service.release();

			// Complete Service Response common data.

			response = autoCompleteResponse(request, response, receiveTime);

			// Set Service Response.

			return response;

		} catch (final ServiceException exception) {
			LOGGER.error("exception raised during service proccessing", exception);
			throw exception;
		} catch (final Throwable throwable) {
			LOGGER.error("technical exception raised during service proccessing", throwable);
			throw new ServiceException(throwable);
		}
	}

	/**
	 * This method will be responsible of copying the common data in the request
	 * to the response.
	 * 
	 * @param request
	 *            Service Request .
	 * @param response
	 *            Service Response
	 * @param time
	 *            Request Receiving Time.
	 * @return modified ServiceResponse
	 * @throws SystemException
	 *             if the request or the response are empty.
	 */
	private ServiceResponse autoCompleteResponse(final ServiceRequest request, final ServiceResponse response,
			final long time) throws ServiceException {

		response.setRequestRecievingTime(time);

		// Calculate Server Response Transmission Time

		response.setResponseSendingTime(System.currentTimeMillis());

		return response;
	}

}
