package eg.net.lanNansahom.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import eg.net.lanNansahom.services.requests.AddVictimRequest;
import eg.net.lanNansahom.services.requests.DeleteVictimsRequest;
import eg.net.lanNansahom.services.requests.SearchVictimsRequest;
import eg.net.lanNansahom.services.requests.UpdateVictimsRequest;
import eg.net.lanNansahom.services.responses.AddVictimResponse;
import eg.net.lanNansahom.services.responses.DeleteVictimsResponse;
import eg.net.lanNansahom.services.responses.SearchVictimsResponse;
import eg.net.lanNansahom.services.responses.UpdateVictimsResponse;
import eg.net.services.ServiceException;

@WebService(targetNamespace = "http://lanNansahom.net.eg")
public interface VictimsAdministrationService {

	@WebMethod
	public AddVictimResponse addVictim(@WebParam(name = "AddVictimRequest") AddVictimRequest request)
			throws ServiceException;

	@WebMethod
	public UpdateVictimsResponse updateVictim(@WebParam(name = "UpdateVictimsRequest") UpdateVictimsRequest request)
			throws ServiceException;

	@WebMethod
	public SearchVictimsResponse searchVictims(@WebParam(name = "SearchVictimsRequest") SearchVictimsRequest request)
			throws ServiceException;

	@WebMethod
	public DeleteVictimsResponse deleteVictim(@WebParam(name = "DeleteVictimsRequest") DeleteVictimsRequest request)
			throws ServiceException;

}
