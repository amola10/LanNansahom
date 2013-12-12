package eg.net.services;

import java.io.Serializable;

/**
 * The Class ServiceException.
 * 
 * @author Amal.Khalil
 * @version 1.0
 */
public class ServiceException extends Exception implements Serializable {

	/** The Constant serialVersionUID. */
	private static long serialVersionUID = 5251486500936132320L;

	/** The code. */
	private String code;

	/**
	 * Instantiates a new service exception.
	 * 
	 * @param throwable
	 *            the throwable
	 */
	public ServiceException(Throwable throwable) {
		this("001", "technical exception raised during service proccessing", throwable);
	}

	/**
	 * Instantiates a new service exception.
	 * 
	 * @param code
	 *            the code
	 * @param description
	 *            the description
	 * @param throwable
	 *            the throwable
	 */
	public ServiceException(String code, String description, Throwable throwable) {
		super(description, throwable);
		this.code = code;
	}

	/**
	 * Instantiates a new service exception.
	 * 
	 * @param code
	 *            the code
	 * @param description
	 *            the description
	 */
	public ServiceException(String code, String description) {
		super(description);
		this.code = code;
	}

	/**
	 * Instantiates a new service exception.
	 * 
	 * @param description
	 *            the description
	 * @param throwable
	 *            the throwable
	 */
	public ServiceException(String description, Throwable throwable) {
		this("001", description, throwable);
	}

	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 * 
	 * @param code
	 *            the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
