package eg.net.gxt.client;

/**
 * The Class ClientException.
 */
public class ClientRuntimeException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6089832489055786942L;

	/**
	 * Instantiates a new client exception.
	 */
	public ClientRuntimeException() {
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
	public ClientRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new client exception.
	 * 
	 * @param message
	 *            the message
	 */
	public ClientRuntimeException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new client exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public ClientRuntimeException(Throwable cause) {
		super(cause);
	}

}
