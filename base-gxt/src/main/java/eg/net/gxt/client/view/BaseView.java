package eg.net.gxt.client.view;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.google.gwt.user.client.ui.Widget;

import eg.net.gxt.client.ClientRuntimeException;
import eg.net.gxt.client.Event;
import eg.net.gxt.client.NavigationHistoryManager;
import eg.net.gxt.client.widget.MainViewPort;

/**
 * The Class BaseView.
 */
public abstract class BaseView extends View {

	/**
	 * Instantiates a new base view.
	 * 
	 * @param controller
	 *            the controller
	 */
	public BaseView(Controller controller) {
		super(controller);
	}

	/**
	 * Gets the main view port.
	 * 
	 * @return the main view port
	 */
	public static MainViewPort getMainViewPort() {
		return (MainViewPort) Registry.get("MAIN_VIEW");
	}

	public static Widget getCenterWidget() {
		Widget result = null;
		if (getMainViewPort() != null && getMainViewPort().getCenterWidget() != null) {
			result = getMainViewPort().getCenterWidget().getWidget();
		}
		return result;
	}

	/**
	 * Show content in center area.
	 * 
	 * @param widget
	 *            the widget
	 */
	public static void showContentInCenterArea(Widget widget, Event event) {
		if (getMainViewPort() != null && getMainViewPort().getCenterWidget() != null) {
			NavigationHistoryManager.getInstance().addView(widget, event);
			getMainViewPort().remove(getMainViewPort().getCenterWidget().getWidget());
			// Update Reference
			getMainViewPort().getCenterWidget().setWidget(widget);
			// Add New Widget
			getMainViewPort().add(widget, getMainViewPort().getCenterWidget().getBorderLayoutData());
			getMainViewPort().layout();
		} else {
			throw new ClientRuntimeException("Center are not prepared. Center widget is null");
		}
	}

}
