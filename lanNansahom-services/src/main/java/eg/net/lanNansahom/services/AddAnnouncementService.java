package eg.net.lanNansahom.services;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.lanNansahom.ServicesErorrCodes;
import eg.net.lanNansahom.business.AnnouncementBusiness;
import eg.net.lanNansahom.services.requests.AddAnnouncementRequest;
import eg.net.lanNansahom.services.responses.AddAnnouncementResponse;
import eg.net.services.AbstractService;
import eg.net.services.ServiceException;
import eg.net.services.ServiceRequest;
import eg.net.services.ServiceResponse;
import eg.net.utilties.ValidationBean;

public class AddAnnouncementService extends AbstractService {

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
		AddAnnouncementRequest request = (AddAnnouncementRequest) serviceRequest;
		ValidationBean bean = new ValidationBean();
		bean.isEmpty("PartnerId", request.getPartnerId());
		bean.isEmpty("Announcement", request.getAnnouncement());
		if (request.getAnnouncement() != null) {
			bean.isAlphanumericAndNotEmpty("Announcement-Titel", request.getAnnouncement().getTitle());
			bean.isEmpty("Announcement-Text", request.getAnnouncement().getText());
			bean.isEmpty("Announcement-Date", request.getAnnouncement().getDate());
		}
		if (bean.isValid() == false) {
			throw new ServiceException(ServicesErorrCodes.REQUEST_VALIDATION_ERROR.toString(),
					bean.getValidationMessage());
		}
	}

	@Override
	public ServiceResponse execute(ServiceRequest serviceRequest) throws ServiceException {
		AddAnnouncementRequest request = (AddAnnouncementRequest) serviceRequest;
		business.addAnnouncement(request.getAnnouncement());
		return new AddAnnouncementResponse();
	}
}
