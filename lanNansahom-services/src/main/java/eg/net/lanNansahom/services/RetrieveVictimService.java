package eg.net.lanNansahom.services;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.lanNansahom.ServicesErorrCodes;
import eg.net.lanNansahom.business.VictimBusiness;
import eg.net.lanNansahom.services.beans.Victim;
import eg.net.lanNansahom.services.requests.RetrieveVictimRequest;
import eg.net.lanNansahom.services.responses.RetrieveVictimResponse;
import eg.net.services.AbstractService;
import eg.net.services.ServiceException;
import eg.net.services.ServiceRequest;
import eg.net.services.ServiceResponse;
import eg.net.utilties.ValidationBean;

public class RetrieveVictimService extends AbstractService {

	@Autowired
	private VictimBusiness business;

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.services.AbstractService#validateRequest(eg.net.services.
	 * ServiceRequest)
	 */
	@Override
	public void validateRequest(ServiceRequest serviceRequest) throws ServiceException {
		RetrieveVictimRequest request = (RetrieveVictimRequest) serviceRequest;
		ValidationBean bean = new ValidationBean();
		bean.isEmpty("PartnerId", request.getPartnerId());
		bean.isEmpty("Id", request.getId());
		if (bean.isValid() == false) {
			throw new ServiceException(ServicesErorrCodes.REQUEST_VALIDATION_ERROR.toString(),
					bean.getValidationMessage());
		}
	}

	@Override
	public ServiceResponse execute(ServiceRequest serviceRequest) throws ServiceException {
		RetrieveVictimRequest request = (RetrieveVictimRequest) serviceRequest;
		Victim victim = business.getVictimById(request.getId());
		RetrieveVictimResponse response = new RetrieveVictimResponse();
		response.setVictim(victim);
		return response;
	}

}
