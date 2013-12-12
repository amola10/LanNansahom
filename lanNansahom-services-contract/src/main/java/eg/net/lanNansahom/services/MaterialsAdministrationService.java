package eg.net.lanNansahom.services;

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

public interface MaterialsAdministrationService {

	public AddLookupResponse addLookup(AddLookupRequest request) throws ServiceException;

	public UpdateLookupResponse updateLookup(UpdateLookupRequest request) throws ServiceException;

	public SearchLookupsResponse searchLookups(SearchLookupsRequest request) throws ServiceException;

	public AddAnnouncementResponse addAnnouncement(AddAnnouncementRequest request) throws ServiceException;

	public RetrieveAnnouncementsResponse retrieveAnnouncements(RetrieveAnnouncementsRequest request)
			throws ServiceException;

	public UpdateAnnouncementResponse updateAnnouncement(UpdateAnnouncementRequest request) throws ServiceException;
}
