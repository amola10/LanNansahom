package eg.net.lanNansahom.shared.beans;

public class RelativeBean extends PersonBean {

	private static final long serialVersionUID = -2348135183844372941L;
	public static final String BINDING_RELEATIONSHIP = "BINDING_RELEATIONSHIP";

	public RelativeBean() {
		super();
	}

	/**
	 * Gets the relationship.
	 * 
	 * @return the relationship
	 */
	public LookupBean getRelationship() {
		return get(BINDING_RELEATIONSHIP);
	}

	/**
	 * Sets the relationship.
	 * 
	 * @param relationship
	 *            the new relationship
	 */
	public void setRelationship(LookupBean relationship) {
		set(BINDING_RELEATIONSHIP, relationship);
	}
}
