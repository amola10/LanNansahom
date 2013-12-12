package eg.net.lanNansahom.services;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.lanNansahom.ServicesErorrCodes;
import eg.net.lanNansahom.business.LookupBusiness;
import eg.net.lanNansahom.services.responses.RetrieveAllLookupResponse;
import eg.net.services.AbstractService;
import eg.net.services.ServiceException;
import eg.net.services.ServiceRequest;
import eg.net.services.ServiceResponse;
import eg.net.utilties.ValidationBean;

/**
 * The Class RetrieveAllLookupService.
 */
public class RetrieveAllLookupService extends AbstractService {

	/** The lookup dao. */
	@Autowired
	private LookupBusiness business;

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.services.AbstractService#validateRequest(eg.net.services.
	 * ServiceRequest)
	 */
	@Override
	public void validateRequest(ServiceRequest serviceRequest) throws ServiceException {
		ValidationBean bean = new ValidationBean();
		bean.isEmpty("PartnerId", serviceRequest.getPartnerId());
		if (bean.isValid() == false) {
			throw new ServiceException(ServicesErorrCodes.REQUEST_VALIDATION_ERROR.toString(),
					bean.getValidationMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.services.AbstractService#execute(eg.net.services.ServiceRequest)
	 */
	@Override
	public ServiceResponse execute(ServiceRequest serviceRequest) throws ServiceException {
		RetrieveAllLookupResponse response = new RetrieveAllLookupResponse();
		response.setLookups(business.retrieveAllLookup());
		return response;

	}

}
