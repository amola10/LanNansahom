package eg.net.gxt.client;

import com.extjs.gxt.ui.client.mvc.AppEvent;

/**
 * The Class Event.
 */
public class Event extends AppEvent {

	/**
	 * Instantiates a new event.
	 * 
	 * @param type
	 *            the type
	 */
	public Event(EventType type) {
		this(type, null);
	}

	/**
	 * Instantiates a new event.
	 * 
	 * @param type
	 *            the type
	 * @param data
	 *            the data
	 */
	public Event(EventType eventType, Object data) {
		super(eventType, data);
		if (eventType.getToken() != null) {
			String token = getData() != null ? eventType.getToken() + ";" + getData() : eventType.getToken();
			setToken(token);
			setHistoryEvent(true);
		} else {
			setHistoryEvent(false);
		}

	}

	public static EventType parseType(String token) {
		return token.split(";").length > 0 ? EventTypeRegistry.getEventType(token.split(";")[0]) : EventTypeRegistry
				.getEventType(token);
	}

	public static Object parseData(String token) {
		return token.split(";").length > 1 ? Integer.valueOf(token.split(";")[1]) : null;
	}
}
