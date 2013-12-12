package eg.net.services;

/**
 * The Class AbstractService.
 * 
 * @author Amal.Khalil
 * @version 1.0
 */
public abstract class AbstractService implements Service {

	/**
	 * This method will be responsible of authorize external partner.
	 * 
	 * @param serviceRequest
	 *            the service request
	 * @throws ServiceException
	 *             exception.
	 */
	public void authrizePartner(ServiceRequest serviceRequest) throws ServiceException {

	}

	/**
	 * This method will be responsible of preparing any initialization any
	 * resources need by the service business.
	 * 
	 * @param serviceRequest
	 *            the service request
	 * @return ServiceResponse.
	 * @throws ServiceException
	 *             in case of business violated rules.
	 */

	public abstract ServiceResponse execute(ServiceRequest serviceRequest) throws ServiceException;

	/**
	 * This method will be responsible of the validation of the incoming
	 * request. This method will validate only common attributes.
	 * 
	 * @param serviceRequest
	 *            the service request
	 * @throws ServiceException
	 *             if the service request data is invalid.
	 */
	public void validateRequest(final ServiceRequest serviceRequest) throws ServiceException {

	}

	/**
	 * This method will be responsible of check that the Content Partner is
	 * Authenticated to use this service.
	 * 
	 * @param serviceRequest
	 *            the service request
	 * @throws ServiceException
	 *             if initialization failed.
	 */
	public void initialize(final ServiceRequest serviceRequest) throws ServiceException {

	}

	/**
	 * This method will be responsible of preparing any releasing any resources
	 * was allocated.
	 * 
	 * @throws ServiceException
	 *             if releasing failed.
	 */
	public void release() throws ServiceException {
	}

}
