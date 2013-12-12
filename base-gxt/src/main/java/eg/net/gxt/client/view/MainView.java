package eg.net.gxt.client.view;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.google.gwt.user.client.ui.RootPanel;

import eg.net.gxt.client.NavigationHistoryManager;
import eg.net.gxt.client.widget.MainViewPort;
import eg.net.gxt.client.widget.layout.border.CenterAreaWidget;
import eg.net.gxt.client.widget.layout.border.EastAreaWidget;
import eg.net.gxt.client.widget.layout.border.NorthAreaWidget;
import eg.net.gxt.client.widget.layout.border.SouthAreaWidget;
import eg.net.gxt.client.widget.layout.border.WestAreaWidget;

public abstract class MainView extends BaseView {

	private MainViewPort viewport;

	public MainView(Controller controller) {
		super(controller);
		init();
	}

	private void init() {
		CenterAreaWidget centerAreaWidget = constructCenterAreaWidget();
		viewport = new MainViewPort(constructNorthAreaWidget(), constructEastAreaWidget(), constructWestAreaWidget(),
				centerAreaWidget, constructSouthAreaWidget(), getApplicationWidth());
		if (centerAreaWidget != null) {
			NavigationHistoryManager.getInstance().addHomePage(centerAreaWidget.getWidget());
		}
		Registry.register("MAIN_VIEW", viewport);
	}

	public void showMainScreen() {
		RootPanel.get().add(getMainViewPort());
	}

	public Integer getApplicationWidth() {
		return null;
	}

	public abstract NorthAreaWidget constructNorthAreaWidget();

	public abstract EastAreaWidget constructEastAreaWidget();

	public abstract WestAreaWidget constructWestAreaWidget();

	public abstract CenterAreaWidget constructCenterAreaWidget();

	public abstract SouthAreaWidget constructSouthAreaWidget();

}
