package eg.net.gxt.server;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import eg.net.gxt.client.ClientException;

/**
 * The Class BaseRemoteServiceServlet.
 */
public abstract class BaseRemoteServiceServlet extends RemoteServiceServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1305453763110436254L;
	private static final Logger LOGGER = Logger.getLogger(BaseRemoteServiceServlet.class);
	protected SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd.MM.yyyy");

	/**
	 * Translat exception.
	 * 
	 * @param throwable
	 *            the throwable
	 * @return the client exception
	 */
	protected ClientException translatException(Throwable throwable) {
		LOGGER.error("a server sid exception was raised", throwable);
		return new ClientException(throwable.getMessage());
	}

	/**
	 * Translate exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 * @return the client exception
	 */
	protected ClientException translatException(String message, Throwable cause) {
		LOGGER.error(message, cause);
		return new ClientException(message, cause);
	}

	/**
	 * Translat exception.
	 * 
	 * @param code
	 *            the code
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 * @return the client exception
	 */
	protected ClientException translatException(String code, String message, Throwable cause) {
		LOGGER.error(message, cause);
		return translatException(code + ": " + message, cause);
	}
}
