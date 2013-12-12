package eg.net.gxt.client;

public class EventType extends com.extjs.gxt.ui.client.event.EventType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5727095767292739322L;

	private String token;

	public EventType() {
		super();
	}

	public EventType(int eventCode) {
		super(eventCode);
	}

	public EventType(int eventCode, String pToken) {
		super(eventCode);
		token = pToken;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof com.extjs.gxt.ui.client.event.EventType) {
			return getEventCode() == ((EventType) obj).getEventCode();
		} else {
			return false;
		}
	}

}
