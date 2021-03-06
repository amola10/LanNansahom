package eg.net.lanNansahom.services;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.lanNansahom.ServicesErorrCodes;
import eg.net.lanNansahom.business.LookupBusiness;
import eg.net.lanNansahom.services.requests.UpdateLookupRequest;
import eg.net.lanNansahom.services.responses.UpdateLookupResponse;
import eg.net.services.AbstractService;
import eg.net.services.ServiceException;
import eg.net.services.ServiceRequest;
import eg.net.services.ServiceResponse;
import eg.net.utilties.ValidationBean;

public class UpdateLookupService extends AbstractService {

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
		UpdateLookupRequest request = (UpdateLookupRequest) serviceRequest;
		ValidationBean bean = new ValidationBean();
		bean.isEmpty("PartnerId", request.getPartnerId());
		bean.isEmpty("lookup", request.getLookup());
		bean.isEmpty("lookupType", request.getLookupType());
		if (request.getLookup() != null) {
			bean.isEmpty("lookup-Id", request.getLookup().getId());
			bean.isAlphanumericAndNotEmpty("lookup-Name", request.getLookup().getName());
			bean.isAlphanumeric("lookup-Description", request.getLookup().getDescription());
		}
		if (bean.isValid() == false) {
			throw new ServiceException(ServicesErorrCodes.REQUEST_VALIDATION_ERROR.toString(),
					bean.getValidationMessage());
		}
	}

	@Override
	public ServiceResponse execute(ServiceRequest serviceRequest) throws ServiceException {
		UpdateLookupRequest request = (UpdateLookupRequest) serviceRequest;
		business.updateLookup(request.getLookupType(), request.getLookup());
		return new UpdateLookupResponse();
	}

}
