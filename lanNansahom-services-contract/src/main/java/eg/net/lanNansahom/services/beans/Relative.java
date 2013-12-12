package eg.net.lanNansahom.services.beans;

/**
 * The Class Relative.
 */
public class Relative extends Person {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4518174396667825867L;

	/** The relationship. */
	private Lookup relationship;

	/**
	 * Instantiates a new relative.
	 */
	public Relative() {
	}

	/**
	 * Gets the relationship.
	 * 
	 * @return the relationship
	 */
	public Lookup getRelationship() {
		return this.relationship;
	}

	/**
	 * Sets the relationship.
	 * 
	 * @param relationship
	 *            the new relationship
	 */
	public void setRelationship(Lookup relationship) {
		this.relationship = relationship;
	}

}
