package eg.net.lanNansahom.client.model;

import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.core.client.GWT;

import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.JSONDataReader;
import eg.net.lanNansahom.client.VictimsRemoteService;
import eg.net.lanNansahom.client.VictimsRemoteServiceAsync;

public class MartyrsModel {
	/** The service. */
	private final VictimsRemoteServiceAsync service;

	/**
	 * Instantiates a new announcement model.
	 */
	public MartyrsModel() {
		service = GWT.create(VictimsRemoteService.class);
	}

	/**
	 * Gets the all announcement.
	 * 
	 * @return the all announcement
	 */
	public void getAllMartyrs() {
		Dispatcher.forwardEvent(AppEvents.MARTYRS_HOMEPAGE_EVENT, JSONDataReader.loadMartyrs());
	}

}
