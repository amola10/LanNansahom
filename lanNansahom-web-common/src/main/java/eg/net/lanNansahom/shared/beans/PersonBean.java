package eg.net.lanNansahom.shared.beans;

import eg.net.gxt.client.BaseBean;

public class PersonBean extends BaseBean {

	private static final long serialVersionUID = -7032478985796440960L;
	public static final String BINDING_ID = "BINDING_ID";
	public static final String BINDING_NAME = "BINDING_NAME";
	public static final String BINDING_NATIONAL_ID = "BINDING_NATIONAL_ID";
	public static final String BINDING_EMAIL = "BINDING_EMAIL";
	public static final String BINDING_HOME_NUMBER = "BINDING_HOME_NUMBER";
	public static final String BINDING_MOBILE_NUMBER = "BINDING_MOBILE_NUMBER";
	public static final String BINDING_PUBLISHED = "BINDING_PUBLISHED";
	public static final String BINDING_CONTATCT_PUBLISHED = "BINDING_CONTATCT_PUBLISHED";

	/**
	 * Amal :Unused field added to avoid serializationException bug in GXT &
	 * GWT.Please don't Remove.
	 */
	@SuppressWarnings("unused")
	private LookupBean unsed;

	public PersonBean() {
		super();
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return get(BINDING_ID, 0);
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		set(BINDING_ID, id);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return get(BINDING_NAME);
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		set(BINDING_NAME, name);
	}

	/**
	 * Gets the national id.
	 * 
	 * @return the national id
	 */
	public String getNationalId() {
		return get(BINDING_NATIONAL_ID);
	}

	/**
	 * Sets the national id.
	 * 
	 * @param nationalId
	 *            the new national id
	 */
	public void setNationalId(String nationalId) {
		set(BINDING_NATIONAL_ID, nationalId);
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return get(BINDING_EMAIL);
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		set(BINDING_EMAIL, email);
	}

	/**
	 * @return the homeNumber
	 */
	public String getHomeNumber() {
		return get(BINDING_HOME_NUMBER);
	}

	/**
	 * @param homeNumber
	 *            the homeNumber to set
	 */
	public void setHomeNumber(String homeNumber) {
		set(BINDING_HOME_NUMBER, homeNumber);
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return get(BINDING_MOBILE_NUMBER);
	}

	/**
	 * @param mobileNumber
	 *            the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		set(BINDING_MOBILE_NUMBER, mobileNumber);
	}

	/**
	 * @return the isPublished
	 */
	public Boolean getPublished() {
		return get(BINDING_PUBLISHED, false);
	}

	/**
	 * @param isPublished
	 *            the isPublished to set
	 */
	public void setPublished(Boolean published) {
		set(BINDING_PUBLISHED, published);
	}

	/**
	 * @return the isContatctPublished
	 */
	public Boolean getContatctPublished() {
		return get(BINDING_CONTATCT_PUBLISHED, false);
	}

	/**
	 * @param isContatctPublished
	 *            the isContatctPublished to set
	 */
	public void setContatctPublished(Boolean contatctPublished) {
		set(BINDING_CONTATCT_PUBLISHED, contatctPublished);
	}

	public boolean hasContact() {
		boolean result = false;
		if (getMobileNumber() != null || getHomeNumber() != null || getEmail() != null) {
			result = true;
		}
		return result;
	}

}
