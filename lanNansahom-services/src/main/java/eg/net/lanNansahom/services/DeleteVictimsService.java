package eg.net.lanNansahom.services;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.lanNansahom.ServicesErorrCodes;
import eg.net.lanNansahom.business.VictimBusiness;
import eg.net.lanNansahom.services.requests.DeleteVictimsRequest;
import eg.net.lanNansahom.services.responses.DeleteVictimsResponse;
import eg.net.services.AbstractService;
import eg.net.services.ServiceException;
import eg.net.services.ServiceRequest;
import eg.net.services.ServiceResponse;
import eg.net.utilties.ValidationBean;

public class DeleteVictimsService extends AbstractService {

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
		DeleteVictimsRequest request = (DeleteVictimsRequest) serviceRequest;
		ValidationBean bean = new ValidationBean();
		bean.isEmpty("PartnerId", request.getPartnerId());
		if (bean.isEmpty("VictimDetails", request.getVictim()) == false) {
			bean.isEmpty("VictimDetail-Id", request.getVictim().getId());
		}

		if (bean.isValid() == false) {
			throw new ServiceException(ServicesErorrCodes.REQUEST_VALIDATION_ERROR.toString(),
					bean.getValidationMessage());
		}
	}

	@Override
	public ServiceResponse execute(ServiceRequest serviceRequest) throws ServiceException {
		DeleteVictimsRequest request = (DeleteVictimsRequest) serviceRequest;
		business.deleteVictims(request.getVictim());
		return new DeleteVictimsResponse();
	}

}
