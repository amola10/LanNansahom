package eg.net.lanNansahom.services;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.lanNansahom.ServicesErorrCodes;
import eg.net.lanNansahom.business.AnnouncementBusiness;
import eg.net.lanNansahom.services.requests.RetrieveAnnouncementsRequest;
import eg.net.lanNansahom.services.responses.RetrieveAnnouncementsResponse;
import eg.net.services.AbstractService;
import eg.net.services.ServiceException;
import eg.net.services.ServiceRequest;
import eg.net.services.ServiceResponse;
import eg.net.utilties.ValidationBean;

public class RetrieveAnnouncementsService extends AbstractService {

	@Autowired
	private AnnouncementBusiness business;

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

	@Override
	public ServiceResponse execute(ServiceRequest serviceRequest) throws ServiceException {
		RetrieveAnnouncementsRequest request = (RetrieveAnnouncementsRequest) serviceRequest;
		RetrieveAnnouncementsResponse response = new RetrieveAnnouncementsResponse();
		if (request.isOnlyPublished()) {
			response.setAnnouncements(business.getPublishedAnnouncement());

		} else {
			response.setAnnouncements(business.getAllAnnouncement());
		}
		return response;

	}
}
