package eg.net.lanNansahom.client.view;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;

import eg.net.gxt.client.Event;
import eg.net.gxt.client.view.MainView;
import eg.net.gxt.client.widget.layout.border.CenterAreaWidget;
import eg.net.gxt.client.widget.layout.border.EastAreaWidget;
import eg.net.gxt.client.widget.layout.border.NorthAreaWidget;
import eg.net.gxt.client.widget.layout.border.SouthAreaWidget;
import eg.net.gxt.client.widget.layout.border.WestAreaWidget;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.widget.application.ApplicationMenu;
import eg.net.lanNansahom.client.widget.application.HomePage;

public class ApplicationView extends MainView {

	public ApplicationView(Controller controller) {
		super(controller);
	}

	@Override
	protected void handleEvent(AppEvent event) {
		switch (event.getType().getEventCode()) {
		case AppEvents.HOME_PAGE_EVENT_CODE:
			if (event.getData() == null) {
				showMainScreen();
			} else {
				replaceMainPanel();
			}
			break;
		default:
			break;
		}
	}

	@Override
	public NorthAreaWidget constructNorthAreaWidget() {
		return null;
	}

	@Override
	public EastAreaWidget constructEastAreaWidget() {
		return null;
	}

	@Override
	public WestAreaWidget constructWestAreaWidget() {
		ApplicationMenu menu = new ApplicationMenu();
		menu.init();
		return new WestAreaWidget(menu, 200);
	}

	@Override
	public CenterAreaWidget constructCenterAreaWidget() {
		HomePage panel = new HomePage();
		return new CenterAreaWidget(panel);
	}

	@Override
	public SouthAreaWidget constructSouthAreaWidget() {
		return null;
	}

	private void replaceMainPanel() {
		HomePage panel = new HomePage();
		showContentInCenterArea(panel, new Event(AppEvents.HOME_PAGE));
	}

}
