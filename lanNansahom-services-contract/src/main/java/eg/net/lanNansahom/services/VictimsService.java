package eg.net.lanNansahom.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import eg.net.lanNansahom.services.requests.RetrieveAllInjuriesRequest;
import eg.net.lanNansahom.services.requests.RetrieveAllMartyrsRequest;
import eg.net.lanNansahom.services.requests.RetrieveVictimRequest;
import eg.net.lanNansahom.services.requests.SearchPublishedVictimsRequest;
import eg.net.lanNansahom.services.responses.RetrieveAllInjuriesResponse;
import eg.net.lanNansahom.services.responses.RetrieveAllMartyrsRespone;
import eg.net.lanNansahom.services.responses.RetrieveVictimResponse;
import eg.net.lanNansahom.services.responses.SearchPublishedVictimsResponse;
import eg.net.services.ServiceException;

@Path("/victims")
@WebService
public interface VictimsService {

	@GET
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/retrieveAllMartyrs/{partnerId}/")
	@WebMethod
	RetrieveAllMartyrsRespone retrieveAllMartyrs(@PathParam("") RetrieveAllMartyrsRequest pRequest)
			throws ServiceException;

	@GET
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/retrieveAllInjuries/{partnerId}/")
	@WebMethod
	RetrieveAllInjuriesResponse retrieveAllInjuries(@PathParam("") RetrieveAllInjuriesRequest pRequest)
			throws ServiceException;

	@GET
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/searchPublishedVictims/")
	@WebMethod
	SearchPublishedVictimsResponse searchPublishedVictims(@QueryParam("request") SearchPublishedVictimsRequest pRequest)
			throws ServiceException;

	@GET
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/retrieveVictimById/{partnerId}/{id}")
	@WebMethod
	RetrieveVictimResponse retrieveVictimById(@PathParam("") RetrieveVictimRequest pRequest) throws ServiceException;

}
