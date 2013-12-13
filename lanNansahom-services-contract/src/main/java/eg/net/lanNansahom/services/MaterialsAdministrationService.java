package eg.net.lanNansahom.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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

@WebService(targetNamespace = "http://lanNansahom.net.eg")
public interface MaterialsAdministrationService {

	@WebMethod
	public AddLookupResponse addLookup(@WebParam(name = "AddLookupRequest") AddLookupRequest request)
			throws ServiceException;

	@WebMethod
	public UpdateLookupResponse updateLookup(@WebParam(name = "UpdateLookupRequest") UpdateLookupRequest request)
			throws ServiceException;

	@WebMethod
	public SearchLookupsResponse searchLookups(@WebParam(name = "SearchLookupsRequest") SearchLookupsRequest request)
			throws ServiceException;

	@WebMethod
	public AddAnnouncementResponse addAnnouncement(
			@WebParam(name = "AddAnnouncementRequest") AddAnnouncementRequest request) throws ServiceException;

	@WebMethod
	public RetrieveAnnouncementsResponse retrieveAnnouncements(
			@WebParam(name = "RetrieveAnnouncementsRequest") RetrieveAnnouncementsRequest request)
			throws ServiceException;

	@WebMethod
	public UpdateAnnouncementResponse updateAnnouncement(
			@WebParam(name = "UpdateAnnouncementRequest") UpdateAnnouncementRequest request) throws ServiceException;
}
