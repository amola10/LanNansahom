package eg.net.lanNansahom.client.view;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;

import eg.net.gxt.client.Event;
import eg.net.gxt.client.EventType;
import eg.net.gxt.client.view.BaseView;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.CustomGXTUtil;
import eg.net.lanNansahom.client.widget.search.AdvancedSearchWidget;
import eg.net.lanNansahom.client.widget.search.SearchWidget;
import eg.net.lanNansahom.shared.beans.VictimInfoBean;

public class SearchView extends BaseView {

	private AdvancedSearchWidget advancedSearchWidget;
	private SearchWidget searchWidget;

	public SearchView(Controller controller) {
		super(controller);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void handleEvent(AppEvent event) {
		switch (event.getType().getEventCode()) {
		case AppEvents.SEARCH_EVENT_CODE:
			searchWidget = new SearchWidget(new ArrayList<VictimInfoBean>());
			showContentInCenterArea(searchWidget, new Event((EventType) event.getType()));
			break;
		case AppEvents.GO_TO_ADVANCED_SEARCH_EVENT_CODE:
			CustomGXTUtil.hideLoading();
			advancedSearchWidget = new AdvancedSearchWidget();
			showContentInCenterArea(advancedSearchWidget, new Event((EventType) event.getType()));
			break;
		case AppEvents.SEARCH_RESULT_EVENT_CODE:
			searchWidget.showResult((List<VictimInfoBean>) event.getData());
			break;
		case AppEvents.ADVANCED_SEARCH_RESULT_EVENT_CODE:
			advancedSearchWidget.showResult((List<VictimInfoBean>) event.getData());
			break;

		default:
			break;
		}

	}
}
