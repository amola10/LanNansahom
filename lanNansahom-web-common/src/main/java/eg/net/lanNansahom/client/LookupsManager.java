package eg.net.lanNansahom.client;

import java.util.HashMap;
import java.util.List;

import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.core.client.GWT;

import eg.net.gxt.client.BaseAsyncCallbackHandler;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.LookupBean;

/**
 * The Class LookupsManager.
 */
public class LookupsManager {

	private static final HashMap<LookupType, List<LookupBean>> LOOKUPS_MAP = new HashMap<LookupType, List<LookupBean>>();
	private static boolean isInitialized = false;

	/**
	 * Instantiates a new lookups manager.
	 */
	private LookupsManager() {
		// empty constructor
	}

	/**
	 * Intialize lookups.
	 * 
	 * @param event
	 *            the event
	 */
	public static void intializeLookups(final EventType event) {
		if (!isInitialized)
			intializeLookups(event, null);
		else
			fireEvent(event, null);
	}

	public static void intializeLookups(final EventType event, final Object pData) {

		CoreServiceAsync service = GWT.create(CoreService.class);
		service.retrieveAllLookups(new BaseAsyncCallbackHandler<HashMap<LookupType, List<LookupBean>>>() {

			public void onSuccess(HashMap<LookupType, List<LookupBean>> result) {
				isInitialized = true;
				LOOKUPS_MAP.clear();
				LOOKUPS_MAP.putAll(result);
				fireEvent(event, pData);
			}

		});

	}

	protected static void fireEvent(EventType event, Object pData) {
		if (event != null) {
			if (pData != null) {
				Dispatcher.forwardEvent(event, pData);
			} else {
				Dispatcher.forwardEvent(event);
			}
		}
	}

	/**
	 * Gets the lookup.
	 * 
	 * @param type
	 *            the type
	 * @return the lookup
	 */
	public static List<LookupBean> getLookup(LookupType lookupType) {
		List<LookupBean> result = LOOKUPS_MAP.get(lookupType);
		return result;
	}

	/**
	 * Gets the lookup store.
	 * 
	 * @param type
	 *            the type
	 * @return the lookup store
	 */
	public static ListStore<LookupBean> getLookupStore(LookupType type) {
		ListStore<LookupBean> result = new ListStore<LookupBean>();
		if (type != null && getLookup(type) != null) {
			result.add(getLookup(type));
		}

		return result;
	}
}
