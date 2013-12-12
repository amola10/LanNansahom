package eg.net.gxt.client;

import java.util.HashMap;

public class EventTypeRegistry {

	private static HashMap<String, EventType> registeredTypes = new HashMap<String, EventType>();

	public static void registerEventType(EventType pEventType) {
		if (pEventType.getToken() != null) {
			registeredTypes.put(pEventType.getToken(), pEventType);
		}
	}

	public static EventType getEventType(String pKey) {
		return registeredTypes.get(pKey);
	}

}
