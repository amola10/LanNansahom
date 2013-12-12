package eg.net.lanNansahom.client.view;

import java.util.List;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;

import eg.net.gxt.client.Event;
import eg.net.gxt.client.EventType;
import eg.net.gxt.client.view.BaseView;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.widget.lookup.LookupMask;
import eg.net.lanNansahom.client.widget.lookup.SearchLookupWidget;
import eg.net.lanNansahom.shared.beans.LookupBean;

public class LookupView extends BaseView {

	private final SearchLookupWidget searchLookupWidget;

	public LookupView(Controller controller) {
		super(controller);
		searchLookupWidget = new SearchLookupWidget();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void handleEvent(AppEvent event) {
		switch (event.getType().getEventCode()) {
		case AppEvents.GO_TO_ADD_LOOKUP_CODE:
			showContentInCenterArea(new LookupMask(searchLookupWidget.getActiveType()),
					new Event((EventType) event.getType()));
			break;
		case AppEvents.GO_TO_LIST_LOOKUPS_CODE:
			showContentInCenterArea(searchLookupWidget, new Event((EventType) event.getType()));
			break;
		case AppEvents.REFRESH_LOOKUPS_CODE:
			searchLookupWidget.populateData((List<LookupBean>) event.getData());
			break;
		case AppEvents.GO_TO_UPDATE_LOOKUP_CODE:
			showContentInCenterArea(new LookupMask((LookupBean) event.getData()),
					new Event((EventType) event.getType()));
			break;
		default:
			break;
		}

	}
}
