package eg.net.lanNansahom.services;

import eg.net.lanNansahom.services.requests.RetrieveAllInjuriesRequest;
import eg.net.lanNansahom.services.requests.RetrieveAllMartyrsRequest;
import eg.net.lanNansahom.services.requests.RetrieveVictimRequest;
import eg.net.lanNansahom.services.requests.SearchPublishedVictimsRequest;
import eg.net.lanNansahom.services.responses.RetrieveAllInjuriesResponse;
import eg.net.lanNansahom.services.responses.RetrieveAllMartyrsRespone;
import eg.net.lanNansahom.services.responses.RetrieveVictimResponse;
import eg.net.lanNansahom.services.responses.SearchPublishedVictimsResponse;
import eg.net.services.ServiceException;

public interface VictimsService {

	RetrieveAllMartyrsRespone retrieveAllMartyrs(RetrieveAllMartyrsRequest pRequest) throws ServiceException;

	RetrieveAllInjuriesResponse retrieveAllInjuries(RetrieveAllInjuriesRequest pRequest) throws ServiceException;

	SearchPublishedVictimsResponse searchPublishedVictims(SearchPublishedVictimsRequest pRequest)
			throws ServiceException;

	RetrieveVictimResponse retrieveVictimById(RetrieveVictimRequest pRequest) throws ServiceException;

}
