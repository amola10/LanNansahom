package eg.net.gxt.client;

import com.allen_sauer.gwt.log.client.Log;

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
		Log.error(
				"An exception of type " + throwable.getClass().getName() + " was raised with message"
						+ throwable.getMessage(), throwable);

	}

}
