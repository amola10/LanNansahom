package eg.net.services;

public interface Service {

	/**
	 * This method will be responsible of initializing any needed resources .
	 * 
	 * @param request
	 *            the ServiceRequest.
	 * @throws ServiceException
	 *             exception.
	 */
	void initialize(ServiceRequest request) throws ServiceException;

	/**
	 * This method will be responsible of the validation of the incoming
	 * request.
	 * 
	 * @param request
	 *            the ServiceRequest.
	 * @throws ServiceException
	 *             exception if request is invalid.
	 */
	void validateRequest(ServiceRequest request) throws ServiceException;

	/**
	 * This method will be responsible of authorize external partner
	 * 
	 * @param request
	 *            the ServiceRequest.
	 * @throws ServiceException
	 *             exception.
	 */
	void authrizePartner(ServiceRequest request) throws ServiceException;

	/**
	 * This method will be responsible of executing and handling the service.
	 * business rules
	 * 
	 * @param request
	 *            the ServiceRequest.
	 * @return ServiceResponse The Service Response.
	 * @throws ServiceException
	 *             exception.
	 */
	ServiceResponse execute(ServiceRequest request) throws ServiceException;

	/**
	 * This method will be responsible of releasing any resources was allocated.
	 * 
	 * @throws ServiceException
	 *             exception.
	 */
	void release() throws ServiceException;

}