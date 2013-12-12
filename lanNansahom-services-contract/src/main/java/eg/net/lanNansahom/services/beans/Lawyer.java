package eg.net.lanNansahom.services.beans;

/**
 * The Class Lawyer.
 */
public class Lawyer implements java.io.Serializable {

	private static final long serialVersionUID = 7676895922119717149L;

	/** The id. */
	private int id;

	/** The person. */
	private Person person;

	/** The law organization. */
	private LawOrganization lawOrganization;

	/** The licence number. */
	private String licenceNumber;

	/**
	 * Instantiates a new lawyer.
	 */
	public Lawyer() {
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
	 * Gets the person.
	 * 
	 * @return the person
	 */
	public Person getPerson() {
		return this.person;
	}

	/**
	 * Sets the person.
	 * 
	 * @param person
	 *            the new person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * Gets the law organization.
	 * 
	 * @return the law organization
	 */
	public LawOrganization getLawOrganization() {
		return this.lawOrganization;
	}

	/**
	 * Sets the law organization.
	 * 
	 * @param lawOrganization
	 *            the new law organization
	 */
	public void setLawOrganization(LawOrganization lawOrganization) {
		this.lawOrganization = lawOrganization;
	}

	/**
	 * Gets the licence number.
	 * 
	 * @return the licence number
	 */
	public String getLicenceNumber() {
		return this.licenceNumber;
	}

	/**
	 * Sets the licence number.
	 * 
	 * @param licenceNumber
	 *            the new licence number
	 */
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

}
