package eg.net.gxt.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Widget;

import eg.net.gxt.client.view.MainView;

/**
 * The Class NavigationHistoryManager.
 */
public class NavigationHistoryManager implements ValueChangeHandler<String> {

	private static final String HOME_PAGE_TOKEN = "home";
	public static final String CRAWABLE_SIGN = "!";
	/** The instance. */
	private static NavigationHistoryManager instance;

	/** The history. */
	private final Map<String, Widget> WIDGET_HISTORY = new HashMap<String, Widget>();

	/** The current token. */
	private String currentToken;

	public static void inti() {
		if (instance == null) {
			instance = new NavigationHistoryManager();
		}
	}

	/**
	 * Gets the single instance of NavigationHistoryManager.
	 * 
	 * @return single instance of NavigationHistoryManager
	 */
	public static NavigationHistoryManager getInstance() {
		if (instance == null) {
			inti();
		}
		return instance;
	}

	private String getToken(String pToken) {
		return CRAWABLE_SIGN + pToken;
	}

	/**
	 * Instantiates a new navigation history manager.
	 */
	private NavigationHistoryManager() {
		super();
		if (History.getToken().length() == 0) {
			History.newItem(getToken(HOME_PAGE_TOKEN));
		}
		History.addValueChangeHandler(this);
		// Now that we've setup our listener, fire the initial history state.
		History.fireCurrentHistoryState();
	}

	/**
	 * Adds the view.
	 * 
	 * @param widget
	 *            the widget
	 */
	public void addView(Widget widget, Event event) {
		if (widget != null && event != null && event.isHistoryEvent()) {
			currentToken = getToken(event.getToken());
			WIDGET_HISTORY.put(currentToken, widget);
			History.newItem(currentToken, false);
		}
	}

	public void addHomePage(Widget widget) {
		if (widget != null) {
			WIDGET_HISTORY.put(getToken(HOME_PAGE_TOKEN), widget);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gwt.event.logical.shared.ValueChangeHandler#onValueChange(
	 * com.google.gwt.event.logical.shared.ValueChangeEvent)
	 */
	public void onValueChange(ValueChangeEvent<String> event) {
		if (event.getValue() != null && !"".equals(event.getValue()) && !event.getValue().equals(currentToken)) {
			currentToken = event.getValue();
			trackPageview(currentToken);
			if (WIDGET_HISTORY.get(currentToken) != null) {
				MainView.showContentInCenterArea(WIDGET_HISTORY.get(currentToken), null);
			}
		}
	}

	public static native void trackPageview(String pToken) /*-{
															if($wnd.trackPageview != null)
																$wnd.trackPageview(pToken);															
															}-*/;

}
