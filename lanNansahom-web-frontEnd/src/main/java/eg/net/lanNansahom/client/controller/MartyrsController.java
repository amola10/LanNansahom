package eg.net.lanNansahom.client.controller;

import com.extjs.gxt.ui.client.mvc.AppEvent;

import eg.net.gxt.client.controller.BaseController;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.model.MartyrsModel;
import eg.net.lanNansahom.client.view.MartyrsView;

public class MartyrsController extends BaseController {

	private final MartyrsView view;
	private final MartyrsModel model;

	public MartyrsController() {
		super();
		view = new MartyrsView(this);
		model = new MartyrsModel();
	}

	@Override
	protected void registerEvents() {
		registerEventTypes(AppEvents.GO_TO_MARTYRS_HOMEPAGE_EVENT);
		registerEventTypes(AppEvents.MARTYRS_HOMEPAGE_EVENT);

	}

	@Override
	public void handleEvent(AppEvent event) {
		switch (event.getType().getEventCode()) {
		case AppEvents.GO_TO_MARTYRS_HOMEPAGE_EVENT_CODE:
			forwardToView(view, event);
			model.getAllMartyrs();
			break;
		case AppEvents.MARTYRS_HOMEPAGE_EVENT_CODE:
			forwardToView(view, event);
			break;
		default:
			break;

		}
	}

}
