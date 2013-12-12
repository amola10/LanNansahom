package eg.net.lanNansahom.services;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.lanNansahom.ServicesErorrCodes;
import eg.net.lanNansahom.business.VictimBusiness;
import eg.net.lanNansahom.datamodel.SearchVictimsCriteria;
import eg.net.lanNansahom.services.requests.SearchVictimsRequest;
import eg.net.lanNansahom.services.responses.SearchVictimsResponse;
import eg.net.services.AbstractService;
import eg.net.services.ServiceException;
import eg.net.services.ServiceRequest;
import eg.net.services.ServiceResponse;
import eg.net.utilties.ValidationBean;

public class SearchVictimsService extends AbstractService {

	@Autowired
	private VictimBusiness business;

	@Override
	public void validateRequest(ServiceRequest serviceRequest) throws ServiceException {
		SearchVictimsRequest request = (SearchVictimsRequest) serviceRequest;
		ValidationBean bean = new ValidationBean();
		bean.isEmpty("PartnerId", request.getPartnerId());

		if (bean.isValid() == false) {
			throw new ServiceException(ServicesErorrCodes.REQUEST_VALIDATION_ERROR.toString(),
					bean.getValidationMessage());
		}
	}

	@Override
	public ServiceResponse execute(ServiceRequest serviceRequest) throws ServiceException {
		SearchVictimsRequest request = (SearchVictimsRequest) serviceRequest;
		SearchVictimsResponse response = new SearchVictimsResponse();
		SearchVictimsCriteria criteria = new SearchVictimsCriteria();
		criteria.setAge(request.getAge());
		criteria.setAreaId(request.getAreaId());
		criteria.setDate(request.getDate());
		criteria.setEducationId(request.getEducationId());
		criteria.setJobId(request.getJobId());
		criteria.setMartyr(request.isMartyr());
		criteria.setName(request.getName());
		criteria.setPublished(request.getIsPublished());
		criteria.setId(request.getId());
		criteria.setRecordStatusId(request.getRecordStatusId());
		response.setVictims(business.searchVictim(criteria));
		return response;
	}
}
