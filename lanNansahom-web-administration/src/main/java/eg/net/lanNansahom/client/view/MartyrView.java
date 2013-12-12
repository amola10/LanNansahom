package eg.net.lanNansahom.client.view;

import java.util.List;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;

import eg.net.gxt.client.Event;
import eg.net.gxt.client.EventType;
import eg.net.gxt.client.view.BaseView;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.widget.martyr.MartyrMask;
import eg.net.lanNansahom.client.widget.martyr.SearchMartyrsWidget;
import eg.net.lanNansahom.shared.beans.MartyrBean;
import eg.net.lanNansahom.shared.beans.VictimBean;

public class MartyrView extends BaseView {

	private final SearchMartyrsWidget searchMartyrsWidget;

	public MartyrView(Controller controller) {
		super(controller);
		searchMartyrsWidget = new SearchMartyrsWidget();
	}

	@Override
	protected void handleEvent(AppEvent event) {

		switch (event.getType().getEventCode()) {
		case AppEvents.GO_TO_SEARCH_MARTYRS_CODE:
			showContentInCenterArea(searchMartyrsWidget, new Event((EventType) event.getType()));
			break;
		case AppEvents.REFRESH_MARTYRS_CODE:
			searchMartyrsWidget.populateData((List<? extends VictimBean>) event.getData());
			break;
		case AppEvents.GO_TO_ADD_MARTYR_CODE:
			showContentInCenterArea(new MartyrMask(), new Event((EventType) event.getType()));
			break;
		case AppEvents.GO_TO_UPDATE_MARTYR_CODE:
			showContentInCenterArea(new MartyrMask((MartyrBean) event.getData()),
					new Event((EventType) event.getType()));
			break;
		default:
			break;
		}

	}

}
