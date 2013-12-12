package eg.net.lanNansahom.services;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.lanNansahom.ServicesErorrCodes;
import eg.net.lanNansahom.business.VictimBusiness;
import eg.net.lanNansahom.datamodel.SearchVictimsCriteria;
import eg.net.lanNansahom.services.requests.SearchPublishedVictimsRequest;
import eg.net.lanNansahom.services.responses.SearchPublishedVictimsResponse;
import eg.net.services.AbstractService;
import eg.net.services.ServiceException;
import eg.net.services.ServiceRequest;
import eg.net.services.ServiceResponse;
import eg.net.utilties.ValidationBean;

public class SearchPublishedVictimsService extends AbstractService {

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
		SearchPublishedVictimsRequest request = (SearchPublishedVictimsRequest) serviceRequest;
		ValidationBean bean = new ValidationBean();
		bean.isEmpty("PartnerId", request.getPartnerId());
		if (bean.isValid() == false) {
			throw new ServiceException(ServicesErorrCodes.REQUEST_VALIDATION_ERROR.toString(),
					bean.getValidationMessage());
		}
	}

	@Override
	public ServiceResponse execute(ServiceRequest serviceRequest) throws ServiceException {
		SearchPublishedVictimsRequest request = (SearchPublishedVictimsRequest) serviceRequest;
		SearchVictimsCriteria criteria = new SearchVictimsCriteria();
		criteria.setPublished(true);
		criteria.setMartyr(true);
		criteria.setAge(request.getAge());
		criteria.setAreaId(request.getAreaId());
		criteria.setDate(request.getDate());
		criteria.setEducationId(request.getEducationId());
		criteria.setJobId(request.getJobId());
		criteria.setName(request.getName());
		SearchPublishedVictimsResponse response = new SearchPublishedVictimsResponse();
		response.setVictims(business.searchVictimInfo(criteria));
		return response;
	}

}
