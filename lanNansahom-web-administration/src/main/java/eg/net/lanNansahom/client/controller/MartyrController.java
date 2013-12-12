package eg.net.lanNansahom.client.controller;

import com.extjs.gxt.ui.client.mvc.AppEvent;

import eg.net.gxt.client.controller.BaseController;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.model.MartyrModel;
import eg.net.lanNansahom.client.view.MartyrView;
import eg.net.lanNansahom.shared.beans.EmailBean;
import eg.net.lanNansahom.shared.beans.MartyrBean;
import eg.net.lanNansahom.shared.beans.SearchVictimsBean;

/**
 * The Class MartyrController.
 */
public class MartyrController extends BaseController {

	/** The model. */
	private final MartyrModel model;

	/** The view. */
	private final MartyrView view;

	/**
	 * Instantiates a new martyr controller.
	 */
	public MartyrController() {
		super();
		model = new MartyrModel();
		view = new MartyrView(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.gxt.client.controller.BaseController#registerEvents()
	 */
	@Override
	protected void registerEvents() {
		registerEventTypes(AppEvents.GO_TO_ADD_MARTYR);
		registerEventTypes(AppEvents.GO_TO_UPDATE_MARTYR);
		registerEventTypes(AppEvents.GO_TO_SEARCH_MARTYRS);
		registerEventTypes(AppEvents.REFRESH_MARTYRS);
		registerEventTypes(AppEvents.ADD_MARTYR);
		registerEventTypes(AppEvents.UPDATE_MARTYR);
		registerEventTypes(AppEvents.DELETE_MARTYR);
		registerEventTypes(AppEvents.SEARCH_MARTYRS);
		registerEventTypes(AppEvents.SEND_EMAIL);
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
		case AppEvents.GO_TO_ADD_MARTYR_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.GO_TO_UPDATE_MARTYR_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.GO_TO_SEARCH_MARTYRS_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.REFRESH_MARTYRS_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.ADD_MARTYR_CODE:
			model.addMartyr((MartyrBean) event.getData());
			break;
		case AppEvents.UPDATE_MARTYR_CODE:
			model.updateMartyr((MartyrBean) event.getData());
			break;
		case AppEvents.SEARCH_MARTYRS_CODE:
			model.searchMartyrs((SearchVictimsBean) event.getData());
			break;
		case AppEvents.DELETE_MARTYR_CODE:
			model.deleteMartyr((MartyrBean) event.getData());
			break;
		case AppEvents.SEND_EMAIL_CODE:
			model.sendEmail((EmailBean) event.getData());
			break;
		default:
			break;

		}
	}

}
