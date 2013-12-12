package eg.net.lanNansahom.services;

import eg.net.lanNansahom.services.requests.RetrieveAllLookupRequest;
import eg.net.lanNansahom.services.responses.RetrieveAllLookupResponse;
import eg.net.services.ServiceException;

public interface BaseServices {

	public RetrieveAllLookupResponse retrieveAllLookup(RetrieveAllLookupRequest request) throws ServiceException;

}
