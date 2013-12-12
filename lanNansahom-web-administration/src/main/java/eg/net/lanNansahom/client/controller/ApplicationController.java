package eg.net.lanNansahom.client.controller;

import com.extjs.gxt.ui.client.mvc.AppEvent;

import eg.net.gxt.client.controller.BaseController;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.view.ApplicationView;

public class ApplicationController extends BaseController {

	private final ApplicationView view;

	public ApplicationController() {
		super();
		view = new ApplicationView(this);

	}

	@Override
	protected void registerEvents() {
		registerEventTypes(AppEvents.HOME_PAGE);
	}

	@Override
	public void handleEvent(AppEvent event) {
		switch (event.getType().getEventCode()) {

		case AppEvents.HOME_PAGE_EVENT_CODE:
			forwardToView(view, event);
			break;

		default:
			break;
		}

	}

}
