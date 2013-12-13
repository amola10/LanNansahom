package eg.net.gxt.client;

import com.google.gwt.user.client.Window;

/**
 * The Class ClientExceptionHandler.
 */
public class ClientExceptionHandler {

	/**
	 * Handler exception.
	 * 
	 * @param throwable
	 *            the throwable
	 */
	public void handlerException(Throwable throwable) {
		throwable.printStackTrace();

		Window.alert("An exception of type " + throwable.getClass().getName() + " was raised with message"
				+ throwable.getMessage());

	}

}
