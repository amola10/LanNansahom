package eg.net.lanNansahom.client.view;

import java.util.List;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;

import eg.net.gxt.client.Event;
import eg.net.gxt.client.EventType;
import eg.net.gxt.client.view.BaseView;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.widget.announcement.AnnouncementGrid;
import eg.net.lanNansahom.client.widget.announcement.AnnouncementMask;
import eg.net.lanNansahom.shared.beans.AnnouncementBean;

public class AnnouncementView extends BaseView {

	private final AnnouncementGrid grid;

	public AnnouncementView(Controller controller) {
		super(controller);
		grid = new AnnouncementGrid();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void handleEvent(AppEvent event) {
		switch (event.getType().getEventCode()) {
		case AppEvents.GO_TO_ADD_ANNOUNCEMENT_CODE:
			showContentInCenterArea(new AnnouncementMask(), new Event((EventType) event.getType()));
			break;
		case AppEvents.GO_TO_LIST_ANNOUNCEMENTS_CODE:
			showContentInCenterArea(grid, new Event((EventType) event.getType()));
			break;
		case AppEvents.REFRESH_ANNOUNCEMENTS_CODE:
			grid.populateData((List<AnnouncementBean>) event.getData());
			break;
		case AppEvents.GO_TO_UPDATE_ANNOUNCEMENT_CODE:
			showContentInCenterArea(new AnnouncementMask((AnnouncementBean) event.getData()), new Event(
					(EventType) event.getType()));
			break;
		default:
			break;
		}

	}
}
