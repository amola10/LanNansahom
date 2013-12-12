package eg.net.lanNansahom.client.controller;

import com.extjs.gxt.ui.client.mvc.AppEvent;

import eg.net.gxt.client.controller.BaseController;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.model.LookupModel;
import eg.net.lanNansahom.client.view.LookupView;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.LookupBean;

/**
 * The Class AnnouncementController.
 */
public class LookupController extends BaseController {

	/** The model. */
	private final LookupModel model;

	/** The view. */
	private final LookupView view;

	/**
	 * Instantiates a new announcement controller.
	 */
	public LookupController() {
		super();
		model = new LookupModel();
		view = new LookupView(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.gxt.client.controller.BaseController#registerEvents()
	 */
	@Override
	protected void registerEvents() {
		registerEventTypes(AppEvents.GO_TO_ADD_LOOKUP);
		registerEventTypes(AppEvents.GO_TO_UPDATE_LOOKUP);
		registerEventTypes(AppEvents.GO_TO_LIST_LOOKUPS);
		registerEventTypes(AppEvents.REFRESH_LOOKUPS);
		registerEventTypes(AppEvents.ADD_LOOKUP);
		registerEventTypes(AppEvents.UPDATE_LOOKUP);
		registerEventTypes(AppEvents.LIST_LOOKUPS);

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
		case AppEvents.GO_TO_ADD_LOOKUP_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.GO_TO_UPDATE_LOOKUP_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.GO_TO_LIST_LOOKUPS_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.REFRESH_LOOKUPS_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.ADD_LOOKUP_CODE:
			model.addLookup((LookupBean) event.getData());
			break;
		case AppEvents.UPDATE_LOOKUP_CODE:
			model.updateLookup((LookupBean) event.getData());
			break;
		case AppEvents.LIST_LOOKUPS_CODE:
			model.getLookupByType((LookupType) event.getData());
			break;
		default:
			break;

		}
	}

}
