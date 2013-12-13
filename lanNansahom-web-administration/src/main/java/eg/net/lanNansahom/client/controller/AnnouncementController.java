package eg.net.lanNansahom.client.controller;

import com.extjs.gxt.ui.client.mvc.AppEvent;

import eg.net.gxt.client.controller.BaseController;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.model.AnnouncementModel;
import eg.net.lanNansahom.client.view.AnnouncementView;
import eg.net.lanNansahom.shared.beans.AnnouncementBean;

/**
 * The Class AnnouncementController.
 */
public class AnnouncementController extends BaseController {

	/** The model. */
	private final AnnouncementModel model;

	/** The view. */
	private final AnnouncementView view;

	/**
	 * Instantiates a new announcement controller.
	 */
	public AnnouncementController() {
		super();
		model = new AnnouncementModel();
		view = new AnnouncementView(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.gxt.client.controller.BaseController#registerEvents()
	 */
	@Override
	protected void registerEvents() {
		registerEventTypes(AppEvents.GO_TO_ADD_ANNOUNCEMENT);
		registerEventTypes(AppEvents.GO_TO_UPDATE_ANNOUNCEMENT);
		registerEventTypes(AppEvents.GO_TO_LIST_ANNOUNCEMENTS);
		registerEventTypes(AppEvents.REFRESH_ANNOUNCEMENTS);
		registerEventTypes(AppEvents.ADD_ANNOUNCEMENT);
		registerEventTypes(AppEvents.UPDATE_ANNOUNCEMENT);
		registerEventTypes(AppEvents.LIST_ANNOUNCEMENTS);
		registerEventTypes(AppEvents.GENERATE_ANNOUNCEMENT);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.extjs.gxt.ui.client.mvc.Controller#handleEvent(com.extjs.gxt.ui.client
	 * .mvc.AppEvent)
	 */
	@Override
	public void handleEvent(AppEvent event) {
		switch (event.getType().getEventCode()) {
		case AppEvents.GO_TO_ADD_ANNOUNCEMENT_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.GO_TO_UPDATE_ANNOUNCEMENT_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.GO_TO_LIST_ANNOUNCEMENTS_CODE:
			forwardToView(view, event);
			forwardEvent(AppEvents.LIST_ANNOUNCEMENTS);
			break;
		case AppEvents.REFRESH_ANNOUNCEMENTS_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.ADD_ANNOUNCEMENT_CODE:
			model.addAnnouncement((AnnouncementBean) event.getData());
			break;
		case AppEvents.UPDATE_ANNOUNCEMENT_CODE:
			model.updateAnnouncement((AnnouncementBean) event.getData());
			break;
		case AppEvents.LIST_ANNOUNCEMENTS_CODE:
			model.getAllAnnouncement();
			break;
		case AppEvents.GENERATE_ANNOUNCEMENT_CODE:
			model.generatePublishAnnouncement();
			break;
		default:
			break;

		}
	}

}
