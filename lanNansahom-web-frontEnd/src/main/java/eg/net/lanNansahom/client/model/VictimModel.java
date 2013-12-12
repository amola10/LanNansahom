package eg.net.lanNansahom.client.model;

import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.core.client.GWT;

import eg.net.gxt.client.BaseAsyncCallbackHandler;
import eg.net.lanNansahom.client.CustomGXTUtil;
import eg.net.lanNansahom.client.VictimsRemoteService;
import eg.net.lanNansahom.client.VictimsRemoteServiceAsync;
import eg.net.lanNansahom.shared.beans.VictimBean;

public class VictimModel {
	/** The service. */
	private final VictimsRemoteServiceAsync service;

	/**
	 * Instantiates a new announcement model.
	 */
	public VictimModel() {
		service = GWT.create(VictimsRemoteService.class);
	}

	/**
	 * Gets the all announcement.
	 * 
	 * @return the all announcement
	 */
	public void getVictimById(final int pId, final EventType pEventType) {
		CustomGXTUtil.showLoading();
		service.getVictimById(pId, new BaseAsyncCallbackHandler<VictimBean>() {
			public void onSuccess(VictimBean result) {
				CustomGXTUtil.hideLoading();
				Dispatcher.forwardEvent(pEventType, result);
			}
		});
	}

}
