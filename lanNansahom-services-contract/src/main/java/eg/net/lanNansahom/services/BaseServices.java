package eg.net.lanNansahom.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import eg.net.lanNansahom.services.requests.RetrieveAllLookupRequest;
import eg.net.lanNansahom.services.responses.RetrieveAllLookupResponse;
import eg.net.services.ServiceException;

@Path("/base")
@WebService
public interface BaseServices {

	@GET
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/retrieveLookup/{partnerId}/")
	@WebMethod
	public RetrieveAllLookupResponse retrieveAllLookup(@PathParam("") RetrieveAllLookupRequest request)
			throws ServiceException;

}
