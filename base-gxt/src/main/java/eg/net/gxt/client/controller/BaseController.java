package eg.net.gxt.client.controller;

import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;

/**
 * The Class BaseController.
 */
public abstract class BaseController extends Controller {

	/**
	 * Instantiates a new base controller.
	 */
	public BaseController() {
		super();
		registerEvents();
	}

	/**
	 * Forward event.
	 * 
	 * @param event
	 *            the event
	 */
	protected void forwardEvent(EventType event) {
		Dispatcher.forwardEvent(event);
	}

	/**
	 * Forward event.
	 * 
	 * @param event
	 *            the event
	 * @param data
	 *            the data
	 */
	protected void forwardEvent(EventType event, Object data) {
		Dispatcher.forwardEvent(event, data);
	}

	/**
	 * Register events.
	 */
	protected abstract void registerEvents();

}
