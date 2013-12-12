package eg.net.lanNansahom.client;

import java.util.HashMap;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.LookupBean;

public interface CoreServiceAsync {

	/**
	 * GWT-RPC service asynchronous (client-side) interface
	 * 
	 * @see eg.net.lanNansahom.client.CoreService
	 */
	void retrieveAllLookups(AsyncCallback<HashMap<LookupType, List<LookupBean>>> callback);

	/**
	 * Utility class to get the RPC Async interface from client-side code
	 */
	public static final class Util {
		private static CoreServiceAsync instance;

		public static final CoreServiceAsync getInstance() {
			if (instance == null) {
				instance = (CoreServiceAsync) GWT.create(CoreService.class);
				ServiceDefTarget target = (ServiceDefTarget) instance;
				target.setServiceEntryPoint(GWT.getModuleBaseURL() + "core");
			}
			return instance;
		}

		private Util() {
			// Utility class should not be instanciated
		}
	}
}
