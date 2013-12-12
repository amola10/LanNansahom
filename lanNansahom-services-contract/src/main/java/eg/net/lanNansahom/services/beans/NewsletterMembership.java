package eg.net.lanNansahom.services.beans;

/**
 * The Class NewsletterMembership.
 */
public class NewsletterMembership implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2849420641726601521L;

	/** The id. */
	private int id;

	/** The email. */
	private String email;

	/**
	 * Instantiates a new newsletter membership.
	 */
	public NewsletterMembership() {
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
