package eg.net.lanNansahom.datamodel;


// Generated Aug 19, 2011 8:10:22 PM by Hibernate Tools 3.4.0.CR1

/**
 * Lawyer generated by hbm2java
 */
public class Relative extends Person implements java.io.Serializable {

	private static final long serialVersionUID = -3622885951008980718L;
	private Relationship relationship;

	public Relative() {
		super();
	}

	/**
	 * @return the relationship
	 */
	public Relationship getRelationship() {
		return relationship;
	}

	/**
	 * @param relationship
	 *            the relationship to set
	 */
	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

}