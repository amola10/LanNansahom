package eg.net.lanNansahom.client.controller;

import com.extjs.gxt.ui.client.mvc.AppEvent;

import eg.net.gxt.client.controller.BaseController;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.model.VictimModel;
import eg.net.lanNansahom.client.view.VictimView;

public class VictimController extends BaseController {

	private final VictimView view;
	private final VictimModel model;

	public VictimController() {
		super();
		view = new VictimView(this);
		model = new VictimModel();
	}

	@Override
	protected void registerEvents() {
		registerEventTypes(AppEvents.GO_TO_VICTIM_DETAILS_EVENT);
		registerEventTypes(AppEvents.SHOW_VICTIM_DETAILS_EVENT);
		registerEventTypes(AppEvents.GO_TO_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT);
		registerEventTypes(AppEvents.SHOW_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT);
	}

	@Override
	public void handleEvent(AppEvent event) {
		switch (event.getType().getEventCode()) {
		case AppEvents.GO_TO_VICTIM_DETAILS_EVENT_CODE:
			model.getVictimById((Integer) event.getData(), AppEvents.SHOW_VICTIM_DETAILS_EVENT);
			break;
		case AppEvents.SHOW_VICTIM_DETAILS_EVENT_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.GO_TO_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT_CODE:
			model.getVictimById((Integer) event.getData(), AppEvents.SHOW_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT);
			break;
		case AppEvents.SHOW_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT_CODE:
			forwardToView(view, event);
			break;
		default:
			break;

		}
	}
}
