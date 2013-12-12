package eg.net.lanNansahom.client.view;

import java.util.List;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;

import eg.net.gxt.client.Event;
import eg.net.gxt.client.EventType;
import eg.net.gxt.client.view.BaseView;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.widget.victims.VictimsHomePage;
import eg.net.lanNansahom.shared.beans.VictimInfoBean;

public class MartyrsView extends BaseView {

	VictimsHomePage homePage = new VictimsHomePage();

	public MartyrsView(Controller controller) {
		super(controller);
	}

	@Override
	protected void handleEvent(AppEvent event) {
		switch (event.getType().getEventCode()) {
		case AppEvents.GO_TO_MARTYRS_HOMEPAGE_EVENT_CODE:
			showContentInCenterArea(homePage, new Event((EventType) event.getType()));
			break;
		case AppEvents.MARTYRS_HOMEPAGE_EVENT_CODE:
			homePage.showVictims((List<VictimInfoBean>) event.getData());
			break;
		default:
			break;
		}

	}

}
