package eg.net.lanNansahom.services.beans;

/**
 * The Class Person.
 */
public class Person implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6304094234564176310L;

	private int id;
	private String name;
	private String nationalId;
	private String email;
	private String homeNumber;
	private String mobileNumber;
	private Boolean published;
	private Boolean contatctPublished;

	/**
	 * Instantiates a new person.
	 */
	public Person() {
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the national id.
	 * 
	 * @return the national id
	 */
	public String getNationalId() {
		return this.nationalId;
	}

	/**
	 * Sets the national id.
	 * 
	 * @param nationalId
	 *            the new national id
	 */
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
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

	/**
	 * @return the homeNumber
	 */
	public String getHomeNumber() {
		return homeNumber;
	}

	/**
	 * @param homeNumber
	 *            the homeNumber to set
	 */
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber
	 *            the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the published
	 */
	public Boolean getPublished() {
		return published;
	}

	/**
	 * @param published
	 *            the published to set
	 */
	public void setPublished(Boolean published) {
		this.published = published;
	}

	/**
	 * @return the contatctPublished
	 */
	public Boolean getContatctPublished() {
		return contatctPublished;
	}

	/**
	 * @param contatctPublished
	 *            the contatctPublished to set
	 */
	public void setContatctPublished(Boolean contatctPublished) {
		this.contatctPublished = contatctPublished;
	}

}
