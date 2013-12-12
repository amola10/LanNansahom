package eg.net.lanNansahom.services;

import javax.jws.WebParam;

import eg.net.lanNansahom.services.requests.AddVictimRequest;
import eg.net.lanNansahom.services.requests.DeleteVictimsRequest;
import eg.net.lanNansahom.services.requests.SearchVictimsRequest;
import eg.net.lanNansahom.services.requests.UpdateVictimsRequest;
import eg.net.lanNansahom.services.responses.AddVictimResponse;
import eg.net.lanNansahom.services.responses.DeleteVictimsResponse;
import eg.net.lanNansahom.services.responses.SearchVictimsResponse;
import eg.net.lanNansahom.services.responses.UpdateVictimsResponse;
import eg.net.services.ServiceException;

public interface VictimsAdministrationService {

	public AddVictimResponse addVictim(@WebParam(name = "AddVictimRequest") AddVictimRequest request)
			throws ServiceException;

	public UpdateVictimsResponse updateVictim(@WebParam(name = "UpdateVictimsRequest") UpdateVictimsRequest request)
			throws ServiceException;

	public SearchVictimsResponse searchVictims(@WebParam(name = "SearchVictimsRequest") SearchVictimsRequest request)
			throws ServiceException;

	public DeleteVictimsResponse deleteVictim(@WebParam(name = "DeleteVictimsRequest") DeleteVictimsRequest request)
			throws ServiceException;

}
