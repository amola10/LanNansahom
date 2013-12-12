package eg.net.lanNansahom.services;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.lanNansahom.ServicesErorrCodes;
import eg.net.lanNansahom.business.VictimBusiness;
import eg.net.lanNansahom.services.requests.AddVictimRequest;
import eg.net.lanNansahom.services.responses.AddVictimResponse;
import eg.net.services.AbstractService;
import eg.net.services.ServiceException;
import eg.net.services.ServiceRequest;
import eg.net.services.ServiceResponse;
import eg.net.utilties.ValidationBean;

public class AddVictimService extends AbstractService {

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
		AddVictimRequest request = (AddVictimRequest) serviceRequest;
		ValidationBean bean = new ValidationBean();
		bean.isEmpty("PartnerId", request.getPartnerId());
		bean.isEmpty("VictimDetails", request.getVictim());
		if (request.getVictim() != null) {
			bean.isAlphanumericAndNotEmpty("VictimDetails-Name", request.getVictim().getName());
			bean.isAlphanumeric("VictimDetails-Address", request.getVictim().getAddress());
			bean.isAlphanumeric("VictimDetails-Employer", request.getVictim().getEmployer());
			bean.isAlphanumeric("VictimDetails-NationalId", request.getVictim().getNationalId());

		}
		if (bean.isValid() == false) {
			throw new ServiceException(ServicesErorrCodes.REQUEST_VALIDATION_ERROR.toString(),
					bean.getValidationMessage());
		}
	}

	@Override
	public ServiceResponse execute(ServiceRequest serviceRequest) throws ServiceException {
		AddVictimRequest request = (AddVictimRequest) serviceRequest;
		business.addVictim(request.getVictim());
		return new AddVictimResponse();
	}
}
