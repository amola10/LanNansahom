package eg.net.lanNansahom.server;

import java.util.HashMap;
import java.util.List;

import eg.net.gxt.client.ClientException;
import eg.net.gxt.server.BaseRemoteServiceServlet;
import eg.net.lanNansahom.client.CoreService;
import eg.net.lanNansahom.services.BaseServices;
import eg.net.lanNansahom.services.requests.RetrieveAllLookupRequest;
import eg.net.lanNansahom.services.responses.RetrieveAllLookupResponse;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.LookupBean;
import eg.net.services.BeansMapper;
import eg.net.services.ServiceException;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class CoreServiceImpl extends BaseRemoteServiceServlet implements CoreService {

	public HashMap<LookupType, List<LookupBean>> retrieveAllLookups() throws ClientException {
		BaseServices services = ServiceLocator.getInstance().getService(BaseServices.class);
		RetrieveAllLookupRequest request = new RetrieveAllLookupRequest();
		request.setPartnerId(1);
		try {
			RetrieveAllLookupResponse response = services.retrieveAllLookup(request);
			HashMap<LookupType, List<LookupBean>> result = new HashMap<LookupType, List<LookupBean>>();
			for (LookupType lookupType : LookupType.values()) {
				if (response.getLookups().get(lookupType.name()) != null) {
					result.put(lookupType,
							BeansMapper.map(response.getLookups().get(lookupType.name()).getItems(), LookupBean.class));
				}
			}
			return result;
		} catch (ServiceException exception) {
			throw translatException(exception.getCode(), exception.getMessage(), exception);
		}
	}

}
