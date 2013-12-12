package eg.net.lanNansahom.client.model;

import java.util.List;

import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.core.client.GWT;

import eg.net.gxt.client.BaseAsyncCallbackHandler;
import eg.net.gxt.client.GXTUtil;
import eg.net.lanNansahom.client.AdministrationRemoteService;
import eg.net.lanNansahom.client.AdministrationRemoteServiceAsync;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.LookupsManager;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.LookupBean;

/**
 * The Class LookupModel.
 */
public class LookupModel {

	/** The service. */
	private final AdministrationRemoteServiceAsync service;

	/**
	 * Instantiates a new Lookup model.
	 */
	public LookupModel() {
		service = GWT.create(AdministrationRemoteService.class);
	}

	/**
	 * Adds the Lookup.
	 * 
	 * @param Lookup
	 *            the Lookup
	 */
	public void addLookup(final LookupBean lookupBean) {

		final LookupType lookupType = LookupType.valueOf(lookupBean.getType());
		service.addLookup(lookupType, lookupBean, new BaseAsyncCallbackHandler<Void>() {
			public void onSuccess(Void a) {
				Dispatcher.forwardEvent(AppEvents.GO_TO_LIST_LOOKUPS);
				Dispatcher.forwardEvent(AppEvents.LIST_LOOKUPS, lookupType);
				LookupsManager.intializeLookups(null);
			}
		});
	}

	/**
	 * Update Lookup.
	 * 
	 * @param Lookup
	 *            the Lookup
	 */
	public void updateLookup(final LookupBean lookupBean) {
		final LookupType lookupType = LookupType.valueOf(lookupBean.getType());
		service.updateLookup(lookupType, lookupBean, new BaseAsyncCallbackHandler<Void>() {
			public void onSuccess(Void a) {
				Dispatcher.forwardEvent(AppEvents.GO_TO_LIST_LOOKUPS);
				Dispatcher.forwardEvent(AppEvents.LIST_LOOKUPS, lookupType);
				LookupsManager.intializeLookups(null);
			}
		});
	}

	/**
	 * Gets the all Lookup.
	 * 
	 * @return the all Lookup
	 */
	public void getLookupByType(final LookupType type) {
		GXTUtil.showLoadingMessage();
		service.getLookupByType(type, new BaseAsyncCallbackHandler<List<LookupBean>>() {
			public void onSuccess(List<LookupBean> result) {
				GXTUtil.hideLoadingMessage();
				Dispatcher.forwardEvent(AppEvents.REFRESH_LOOKUPS, result);
			}
		});
	}

}
