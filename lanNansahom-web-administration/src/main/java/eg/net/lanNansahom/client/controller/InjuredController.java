package eg.net.lanNansahom.client.controller;

import com.extjs.gxt.ui.client.mvc.AppEvent;

import eg.net.gxt.client.controller.BaseController;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.model.InjuredModel;
import eg.net.lanNansahom.client.view.InjuredView;
import eg.net.lanNansahom.shared.beans.InjuredBean;
import eg.net.lanNansahom.shared.beans.SearchVictimsBean;

/**
 * The Class AnnouncementController.
 */
public class InjuredController extends BaseController {

	/** The model. */
	private final InjuredModel model;

	/** The view. */
	private final InjuredView view;

	/**
	 * Instantiates a new injured controller.
	 */
	public InjuredController() {
		super();
		model = new InjuredModel();
		view = new InjuredView(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.gxt.client.controller.BaseController#registerEvents()
	 */
	@Override
	protected void registerEvents() {
		registerEventTypes(AppEvents.GO_TO_ADD_INJURED);
		registerEventTypes(AppEvents.GO_TO_UPDATE_INJURED);
		registerEventTypes(AppEvents.GO_TO_SEARCH_INJURIES);
		registerEventTypes(AppEvents.REFRESH_INJURIES);
		registerEventTypes(AppEvents.ADD_INJURED);
		registerEventTypes(AppEvents.UPDATE_INJURED);
		registerEventTypes(AppEvents.DELETE_INJURED);
		registerEventTypes(AppEvents.SEARCH_INJURIES);
		registerEventTypes(AppEvents.GENERATE_INJURED);
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
		case AppEvents.GO_TO_ADD_INJURED_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.GO_TO_UPDATE_INJURED_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.GO_TO_SEARCH_INJURIES_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.REFRESH_INJURIES_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.ADD_INJURED_CODE:
			model.addInjured((InjuredBean) event.getData());
			break;
		case AppEvents.UPDATE_INJURED_CODE:
			model.updateInjured((InjuredBean) event.getData());
			break;
		case AppEvents.SEARCH_INJURIES_CODE:
			model.searchInjuries((SearchVictimsBean) event.getData());
			break;
		case AppEvents.DELETE_INJURED_CODE:
			model.deleteInjured((InjuredBean) event.getData());
			break;
		case AppEvents.GENERATE_INJURED_CODE:
			model.generatePublishedInjuries();
			break;
		default:
			break;

		}
	}

}
