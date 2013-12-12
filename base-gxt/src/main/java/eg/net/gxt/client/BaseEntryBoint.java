package eg.net.gxt.client;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.util.Theme;
import com.extjs.gxt.ui.client.util.ThemeManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;

import eg.net.gxt.client.controller.BaseController;

/**
 * The Class BaseEntryBoint.
 */
public abstract class BaseEntryBoint implements EntryPoint {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	public void onModuleLoad() {
		if (getActiveTheme() != null) {
			setActiveTheme(getActiveTheme());
		}
		registerErrorHandler();
		// Init NavigationHistoryManager
		NavigationHistoryManager.inti();
		init();
		start();
	}

	/**
	 * Inits the.
	 */
	public void init() {

	}

	/**
	 * Sets the active theme.
	 * 
	 * @param theme
	 *            the active theme
	 */
	public void setActiveTheme(Theme theme) {
		ThemeManager.register(theme);
		GXT.setDefaultTheme(theme, true);
	}

	/**
	 * Register controller.
	 * 
	 * @param controller
	 *            the controller
	 */
	protected void registerController(BaseController controller) {
		Dispatcher dispatcher = Dispatcher.get();
		dispatcher.addController(controller);
	}

	/**
	 * Fire event.
	 * 
	 * @param eventType
	 *            the event type
	 */
	protected void fireEvent(EventType eventType) {
		Dispatcher dispatcher = Dispatcher.get();
		dispatcher.dispatch(eventType);
	}

	/**
	 * Fire event.
	 * 
	 * @param eventType
	 *            the event type
	 */
	protected void fireEvent(EventType eventType, Object data) {
		Dispatcher dispatcher = Dispatcher.get();
		dispatcher.dispatch(eventType, data);
	}

	/**
	 * Register error handler.
	 */
	private void registerErrorHandler() {
		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			public void onUncaughtException(Throwable throwable) {
				ClientExceptionHandler handler = new ClientExceptionHandler();
				handler.handlerException(throwable);

			}
		});

	}

	/**
	 * Gets the active theme.
	 * 
	 * @return the active theme
	 */
	public abstract Theme getActiveTheme();

	/**
	 * Start.
	 */
	public abstract void start();

}
