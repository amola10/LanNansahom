package eg.net.lanNansahom.shared.beans;

/**
 * The Class EmailBean.
 */
public class EmailBean extends ResourceBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7889310269863585720L;

	/** The Constant BINDING_FROM. */
	public static final String BINDING_FROM = "BINDING_FROM";

	/** The Constant BINDING_TO. */
	public static final String BINDING_TO = "BINDING_TO";

	/** The Constant BINDING_SUBJECT. */
	public static final String BINDING_SUBJECT = "BINDING_SUBJECT";

	/** The Constant BINDING_MESSAGE. */
	public static final String BINDING_MESSAGE = "BINDING_MESSAGE";

	/**
	 * Instantiates a new email bean.
	 */
	public EmailBean() {
		super();
	}

	/**
	 * Sets the from.
	 * 
	 * @param pFrom
	 *            the new from
	 */
	public void setFrom(String pFrom) {
		set(BINDING_FROM, pFrom);
	}

	/**
	 * Gets the from.
	 * 
	 * @return the from
	 */
	public String getFrom() {
		return get(BINDING_FROM);
	}

	/**
	 * Sets the to.
	 * 
	 * @param pTo
	 *            the new to
	 */
	public void setTo(String pTo) {
		set(BINDING_TO, pTo);
	}

	/**
	 * Gets the to.
	 * 
	 * @return the to
	 */
	public String getTo() {
		return get(BINDING_TO);
	}

	/**
	 * Sets the subject.
	 * 
	 * @param pSubject
	 *            the new subject
	 */
	public void setSubject(String pSubject) {
		set(BINDING_SUBJECT, pSubject);
	}

	/**
	 * Gets the subject.
	 * 
	 * @return the subject
	 */
	public String getSubject() {
		return get(BINDING_SUBJECT);
	}

	/**
	 * Sets the message.
	 * 
	 * @param pMessage
	 *            the new message
	 */
	public void setMessage(String pMessage) {
		set(BINDING_MESSAGE, pMessage);
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return get(BINDING_MESSAGE);
	}

}
