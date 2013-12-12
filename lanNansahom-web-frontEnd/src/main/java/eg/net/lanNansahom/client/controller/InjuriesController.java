package eg.net.lanNansahom.client.controller;

import com.extjs.gxt.ui.client.mvc.AppEvent;

import eg.net.gxt.client.controller.BaseController;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.model.InjuresModel;
import eg.net.lanNansahom.client.view.InjuriesView;

public class InjuriesController extends BaseController {

	private final InjuriesView view;
	private final InjuresModel model;

	public InjuriesController() {
		super();
		view = new InjuriesView(this);
		model = new InjuresModel();
	}

	@Override
	protected void registerEvents() {
		registerEventTypes(AppEvents.INJURIES_HOMEPAGE_EVENT);
		registerEventTypes(AppEvents.GO_TO_INJURIES_HOMEPAGE_EVENT);
	}

	@Override
	public void handleEvent(AppEvent event) {
		switch (event.getType().getEventCode()) {
		case AppEvents.GO_TO_INJURIES_HOMEPAGE_EVENT_CODE:
			forwardToView(view, event);
			model.getAllInjuries();
			break;
		case AppEvents.INJURIES_HOMEPAGE_EVENT_CODE:
			forwardToView(view, event);
			break;
		default:
			break;

		}
	}

}
