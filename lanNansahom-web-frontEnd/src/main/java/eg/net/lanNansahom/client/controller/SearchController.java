package eg.net.lanNansahom.client.controller;

import com.extjs.gxt.ui.client.mvc.AppEvent;

import eg.net.gxt.client.controller.BaseController;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.model.SearchModel;
import eg.net.lanNansahom.client.view.SearchView;
import eg.net.lanNansahom.shared.beans.SearchVictimsBean;

public class SearchController extends BaseController {

	private final SearchView view;
	private final SearchModel model;

	public SearchController() {
		super();
		view = new SearchView(this);
		model = new SearchModel();
	}

	@Override
	protected void registerEvents() {
		registerEventTypes(AppEvents.SEARCH_EVENT);
		registerEventTypes(AppEvents.GO_TO_ADVANCED_SEARCH_EVENT);
		registerEventTypes(AppEvents.ADVANCED_SEARCH_EVENT);
		registerEventTypes(AppEvents.SEARCH_RESULT_EVENT);
		registerEventTypes(AppEvents.ADVANCED_SEARCH_RESULT_EVENT);

	}

	@Override
	public void handleEvent(AppEvent event) {
		switch (event.getType().getEventCode()) {
		case AppEvents.SEARCH_EVENT_CODE:
			forwardToView(view, event);
			model.search((String) event.getData());
			break;
		case AppEvents.ADVANCED_SEARCH_EVENT_CODE:
			model.advancedSearch((SearchVictimsBean) event.getData());
			break;
		case AppEvents.GO_TO_ADVANCED_SEARCH_EVENT_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.SEARCH_RESULT_EVENT_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.ADVANCED_SEARCH_RESULT_EVENT_CODE:
			forwardToView(view, event);
			break;

		default:
			break;

		}
	}

}
