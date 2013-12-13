package eg.net.lanNansahom.client.model;

import java.util.List;

import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

import eg.net.gxt.client.BaseAsyncCallbackHandler;
import eg.net.gxt.client.GXTUtil;
import eg.net.lanNansahom.client.AdministrationRemoteService;
import eg.net.lanNansahom.client.AdministrationRemoteServiceAsync;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.shared.beans.AnnouncementBean;

/**
 * The Class AnnouncementModel.
 */
public class AnnouncementModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6188390128202586400L;

	/** The service. */
	private final AdministrationRemoteServiceAsync service;

	/**
	 * Instantiates a new announcement model.
	 */
	public AnnouncementModel() {
		service = GWT.create(AdministrationRemoteService.class);
	}

	/**
	 * Adds the announcement.
	 * 
	 * @param announcement
	 *            the announcement
	 */
	public void addAnnouncement(AnnouncementBean announcementBean) {
		service.addAnnouncement(announcementBean, new BaseAsyncCallbackHandler<Void>() {
			public void onSuccess(Void a) {
				Dispatcher.forwardEvent(AppEvents.GO_TO_LIST_ANNOUNCEMENTS);
			}
		});
	}

	/**
	 * Update announcement.
	 * 
	 * @param announcement
	 *            the announcement
	 */
	public void updateAnnouncement(AnnouncementBean announcementBean) {
		service.updateAnnouncement(announcementBean, new BaseAsyncCallbackHandler<Void>() {
			public void onSuccess(Void a) {
				Dispatcher.forwardEvent(AppEvents.GO_TO_LIST_ANNOUNCEMENTS);
			}
		});
	}

	/**
	 * Gets the all announcement.
	 * 
	 * @return the all announcement
	 */
	public void getAllAnnouncement() {
		GXTUtil.showLoadingMessage();
		service.getAllAnnouncement(new BaseAsyncCallbackHandler<List<AnnouncementBean>>() {
			public void onSuccess(List<AnnouncementBean> result) {
				GXTUtil.hideLoadingMessage();
				Dispatcher.forwardEvent(AppEvents.REFRESH_ANNOUNCEMENTS, result);
			}
		});
	}

	public void generatePublishAnnouncement() {
		service.generatePublishAnnouncement(new BaseAsyncCallbackHandler<Void>() {
			public void onSuccess(Void result) {
				Window.alert("Data Generated Successfuly");
			}
		});
	}
}
