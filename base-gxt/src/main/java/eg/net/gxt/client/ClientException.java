package eg.net.gxt.client;

/**
 * The Class ClientException.
 */
public class ClientException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6089832489055786942L;

	/**
	 * Instantiates a new client exception.
	 */
	public ClientException() {
		super();
	}

	/**
	 * Instantiates a new client exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public ClientException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new client exception.
	 * 
	 * @param message
	 *            the message
	 */
	public ClientException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new client exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public ClientException(Throwable cause) {
		super(cause);
	}

}
