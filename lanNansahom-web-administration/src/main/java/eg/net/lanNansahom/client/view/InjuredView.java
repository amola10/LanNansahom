package eg.net.lanNansahom.client.view;

import java.util.List;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;

import eg.net.gxt.client.Event;
import eg.net.gxt.client.EventType;
import eg.net.gxt.client.view.BaseView;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.widget.injured.InjuredMask;
import eg.net.lanNansahom.client.widget.injured.SearchInjuriesWidget;
import eg.net.lanNansahom.shared.beans.InjuredBean;
import eg.net.lanNansahom.shared.beans.VictimBean;

public class InjuredView extends BaseView {

	private final SearchInjuriesWidget searchInjuriesWidget;

	public InjuredView(Controller controller) {
		super(controller);
		searchInjuriesWidget = new SearchInjuriesWidget();

	}

	@Override
	protected void handleEvent(AppEvent event) {

		switch (event.getType().getEventCode()) {
		case AppEvents.GO_TO_SEARCH_INJURIES_CODE:
			showContentInCenterArea(searchInjuriesWidget, new Event((EventType) event.getType()));
			break;
		case AppEvents.REFRESH_INJURIES_CODE:
			searchInjuriesWidget.populateData((List<? extends VictimBean>) event.getData());
			break;
		case AppEvents.GO_TO_ADD_INJURED_CODE:
			showContentInCenterArea(new InjuredMask(), new Event((EventType) event.getType()));
			break;
		case AppEvents.GO_TO_UPDATE_INJURED_CODE:
			showContentInCenterArea(new InjuredMask((InjuredBean) event.getData()),
					new Event((EventType) event.getType()));
			break;
		default:
			break;
		}

	}

}
