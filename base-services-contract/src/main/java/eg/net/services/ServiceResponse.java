package eg.net.services;

/**
 * @author Amal.Khalil
 * @version 1.0
 */
public class ServiceResponse {

	/**
	 * requestRecievingTime Field.
	 */
	private long requestRecievingTime;

	/**
	 * responseSendingTime Field.
	 */
	private long responseSendingTime;

	public void setRequestRecievingTime(long requestRecievingTime) {
		this.requestRecievingTime = requestRecievingTime;
	}

	public long getRequestRecievingTime() {
		return requestRecievingTime;
	}

	public void setResponseSendingTime(long responseSendingTime) {
		this.responseSendingTime = responseSendingTime;
	}

	public long getResponseSendingTime() {
		return responseSendingTime;
	}

}
