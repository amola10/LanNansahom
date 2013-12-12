package eg.net.lanNansahom.client.model;

import java.util.List;

import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.core.client.GWT;

import eg.net.gxt.client.BaseAsyncCallbackHandler;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.CustomGXTUtil;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.VictimsRemoteService;
import eg.net.lanNansahom.client.VictimsRemoteServiceAsync;
import eg.net.lanNansahom.shared.beans.SearchVictimsBean;
import eg.net.lanNansahom.shared.beans.VictimInfoBean;

public class SearchModel {
	/** The service. */
	private final VictimsRemoteServiceAsync service;

	/**
	 * Instantiates a new announcement model.
	 */
	public SearchModel() {
		service = GWT.create(VictimsRemoteService.class);
	}

	public void search(String pKeyword) {
		CustomGXTUtil.showLoading();
		service.searchVictims(pKeyword, new BaseAsyncCallbackHandler<List<VictimInfoBean>>() {
			public void onSuccess(List<VictimInfoBean> result) {
				CustomGXTUtil.hideLoading();
				Dispatcher.forwardEvent(AppEvents.SEARCH_RESULT_EVENT, result);
			}
		});

	}

	public void advancedSearch(SearchVictimsBean pSearchCriteria) {
		Messages messages = GWT.create(Messages.class);
		CustomGXTUtil.showLoading();
		service.searchVictims(pSearchCriteria, new BaseAsyncCallbackHandler<List<VictimInfoBean>>() {
			public void onSuccess(List<VictimInfoBean> result) {
				CustomGXTUtil.hideLoading();
				Dispatcher.forwardEvent(AppEvents.ADVANCED_SEARCH_RESULT_EVENT, result);
			}
		});

	}

}
