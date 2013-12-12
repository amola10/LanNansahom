package eg.net.lanNansahom.client;

import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import eg.net.gxt.client.ClientException;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.LookupBean;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("core")
public interface CoreService extends RemoteService {

	/**
	 * Retrieve all lookups.
	 * 
	 * @return the hash map
	 * @throws ClientException
	 *             the client exception
	 */
	HashMap<LookupType, List<LookupBean>> retrieveAllLookups() throws ClientException;
}