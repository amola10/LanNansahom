package eg.net.lanNansahom.client.view;

import java.util.Date;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.i18n.client.DateTimeFormat;

import eg.net.gxt.client.Event;
import eg.net.gxt.client.EventType;
import eg.net.gxt.client.view.MainView;
import eg.net.gxt.client.widget.layout.border.CenterAreaWidget;
import eg.net.gxt.client.widget.layout.border.EastAreaWidget;
import eg.net.gxt.client.widget.layout.border.NorthAreaWidget;
import eg.net.gxt.client.widget.layout.border.SouthAreaWidget;
import eg.net.gxt.client.widget.layout.border.WestAreaWidget;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.LookupsManager;
import eg.net.lanNansahom.client.widget.application.AboutUsPanel;
import eg.net.lanNansahom.client.widget.application.ContactUsPanel;
import eg.net.lanNansahom.client.widget.application.Footer;
import eg.net.lanNansahom.client.widget.application.Header;
import eg.net.lanNansahom.client.widget.application.MainPanel;

public class ApplicationView extends MainView {

	private Header header = null;
	private final MainPanel mainPanel = new MainPanel();

	public ApplicationView(Controller controller) {
		super(controller);
	}

	@Override
	protected void handleEvent(AppEvent event) {
		switch (event.getType().getEventCode()) {
		case AppEvents.INITIALIZE_EVENT_CODE:
			showMainScreen();
			Event targetEvent = (Event) event.getData();
			if (targetEvent != null && AppEvents.GO_TO_ADVANCED_SEARCH_EVENT.equals(targetEvent.getType())) {
				LookupsManager.intializeLookups(AppEvents.GO_TO_ADVANCED_SEARCH_EVENT);
			} else {
				Dispatcher.forwardEvent(targetEvent);
			}
			break;
		case AppEvents.HOME_PAGE_EVENT_CODE:
			if (event.getData() == null) {
				showMainScreen();
			}
			showMainPanel(event);
			break;
		case AppEvents.SHOW_HEADER_EVENT_CODE:
			header.showHeader();
			break;
		case AppEvents.LEAVE_HOME_PAGE_EVENT_CODE:
			mainPanel.onLeave();
			header.layout(true);
			break;
		case AppEvents.ABOUT_US_EVENT_CODE:
			showContentInCenterArea(new AboutUsPanel(), new Event((EventType) event.getType()));
			break;
		case AppEvents.CONTACT_US_EVENT_CODE:
			showContentInCenterArea(new ContactUsPanel(), new Event((EventType) event.getType()));
			break;
		default:
			break;
		}
	}

	@Override
	public NorthAreaWidget constructNorthAreaWidget() {
		header = new Header();
		NorthAreaWidget widget = new NorthAreaWidget(header, getHeaderHieght());
		widget.getBorderLayoutData().setSplit(false);
		widget.getBorderLayoutData().setFloatable(false);
		widget.getBorderLayoutData().setHideCollapseTool(true);
		widget.getBorderLayoutData().setCollapsible(false);
		widget.getBorderLayoutData().setMargins(new Margins(20, getMargin(), 5, getMargin()));
		return widget;
	}

	@Override
	public CenterAreaWidget constructCenterAreaWidget() {
		ContentPanel panel = new ContentPanel();
		panel.setLayout(new FitLayout());
		panel.setHeaderVisible(false);
		panel.setBodyBorder(false);
		panel.setBorders(false);
		CenterAreaWidget widget = new CenterAreaWidget(panel);
		widget.getBorderLayoutData().setSplit(false);
		widget.getBorderLayoutData().setFloatable(false);
		widget.getBorderLayoutData().setHideCollapseTool(true);
		widget.getBorderLayoutData().setCollapsible(false);
		widget.getBorderLayoutData().setMargins(new Margins(0, getMargin(), 0, getMargin()));
		return widget;

	}

	@Override
	public SouthAreaWidget constructSouthAreaWidget() {
		SouthAreaWidget widget = new SouthAreaWidget(new Footer(), 32);
		widget.getBorderLayoutData().setSplit(false);
		widget.getBorderLayoutData().setFloatable(false);
		widget.getBorderLayoutData().setHideCollapseTool(true);
		widget.getBorderLayoutData().setCollapsible(false);
		widget.getBorderLayoutData().setMargins(new Margins(5, getMargin(), 0, getMargin()));
		return widget;
	}

	@Override
	public EastAreaWidget constructEastAreaWidget() {
		return null;
	}

	@Override
	public WestAreaWidget constructWestAreaWidget() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.gxt.client.view.MainView#getApplicationWidth()
	 */
	@Override
	public Integer getApplicationWidth() {
		return 940;
	}

	public static int getMargin() {
		return 0;
	}

	public static int getHeaderHieght() {
		return 44;
	}

	public static int getHeaderTotalHieght() {
		return getHeaderHieght() + 20 + 5;
	}

	public static native void customScroll(String pClass) /*-{
															$wnd.customScroll(pClass);
															}-*/;

	public static native void createImageLightBox(String id) /*-{
																$wnd.createImageLightBox(id);
																}-*/;

	public static native void createVideoLightBox(String id) /*-{
																$wnd.createVideoLightBox(id);
																}-*/;

	public static native void createPanelLightBox(String pContent) /*-{
																	$wnd.createPanelLightBox(pContent);
																	}-*/;

	public static native void initVictimLightBox() /*-{
													$wnd.initVictimLightBox();
													}-*/;

	public static native void createImageToolTip() /*-{
													$wnd.createImageToolTip();
													}-*/;

	public static native void closeLightBox() /*-{
												$wnd.closeLightBox();
												}-*/;

	public static String formateDate(Date date) {
		DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("dd.MM.yyyy");
		return dateTimeFormat.format(date);
	}

	public static Date parseDate(String dateString) {
		DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("dd.MM.yyyy");
		return dateTimeFormat.parse(dateString);
	}

	private void showMainPanel(AppEvent event) {
		showContentInCenterArea(mainPanel, new Event((EventType) event.getType()));
		mainPanel.onIn();
	}

}
