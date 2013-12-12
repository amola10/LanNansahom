package eg.net.lanNansahom.webservices.impl;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.ServiceProcessor;
import eg.net.lanNansahom.ApplicationContext;
import eg.net.lanNansahom.services.AddAnnouncementService;
import eg.net.lanNansahom.services.AddLookupService;
import eg.net.lanNansahom.services.MaterialsAdministrationService;
import eg.net.lanNansahom.services.RetrieveAnnouncementsService;
import eg.net.lanNansahom.services.SearchLookupsService;
import eg.net.lanNansahom.services.UpdateAnnouncementService;
import eg.net.lanNansahom.services.UpdateLookupService;
import eg.net.lanNansahom.services.requests.AddAnnouncementRequest;
import eg.net.lanNansahom.services.requests.AddLookupRequest;
import eg.net.lanNansahom.services.requests.RetrieveAnnouncementsRequest;
import eg.net.lanNansahom.services.requests.SearchLookupsRequest;
import eg.net.lanNansahom.services.requests.UpdateAnnouncementRequest;
import eg.net.lanNansahom.services.requests.UpdateLookupRequest;
import eg.net.lanNansahom.services.responses.AddAnnouncementResponse;
import eg.net.lanNansahom.services.responses.AddLookupResponse;
import eg.net.lanNansahom.services.responses.RetrieveAnnouncementsResponse;
import eg.net.lanNansahom.services.responses.SearchLookupsResponse;
import eg.net.lanNansahom.services.responses.UpdateAnnouncementResponse;
import eg.net.lanNansahom.services.responses.UpdateLookupResponse;
import eg.net.services.ServiceException;

public class MaterialsAdministrationServiceImpl implements MaterialsAdministrationService {

	private final ApplicationContext context;

	@Autowired
	public MaterialsAdministrationServiceImpl(ApplicationContext context) {
		this.context = context;
	}

	public AddAnnouncementResponse addAnnouncement(AddAnnouncementRequest request) throws ServiceException {
		ServiceProcessor processor = new ServiceProcessor();
		return (AddAnnouncementResponse) processor.handleService(context.getInstanceOf(AddAnnouncementService.class),
				request);

	}

	public RetrieveAnnouncementsResponse retrieveAnnouncements(RetrieveAnnouncementsRequest request)
			throws ServiceException {
		ServiceProcessor processor = new ServiceProcessor();
		return (RetrieveAnnouncementsResponse) processor.handleService(
				context.getInstanceOf(RetrieveAnnouncementsService.class), request);
	}

	public UpdateAnnouncementResponse updateAnnouncement(UpdateAnnouncementRequest request) throws ServiceException {
		ServiceProcessor processor = new ServiceProcessor();
		return (UpdateAnnouncementResponse) processor.handleService(
				context.getInstanceOf(UpdateAnnouncementService.class), request);
	}

	public AddLookupResponse addLookup(AddLookupRequest request) throws ServiceException {
		ServiceProcessor processor = new ServiceProcessor();
		return (AddLookupResponse) processor.handleService(context.getInstanceOf(AddLookupService.class), request);

	}

	public UpdateLookupResponse updateLookup(UpdateLookupRequest request) throws ServiceException {
		ServiceProcessor processor = new ServiceProcessor();
		return (UpdateLookupResponse) processor
				.handleService(context.getInstanceOf(UpdateLookupService.class), request);
	}

	public SearchLookupsResponse searchLookups(SearchLookupsRequest request) throws ServiceException {
		ServiceProcessor processor = new ServiceProcessor();
		return (SearchLookupsResponse) processor.handleService(context.getInstanceOf(SearchLookupsService.class),
				request);
	}

}
