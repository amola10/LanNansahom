package eg.net.lanNansahom.services.beans;

/**
 * The Class LawOrganization.
 */
public class LawOrganization extends Lookup {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1710287096351413112L;

	/** The is human right center. */
	private Boolean isHumanRightCenter;

	/**
	 * Instantiates a new law organization.
	 */
	public LawOrganization() {
		super();
	}

	/**
	 * Gets the checks if is human right center.
	 * 
	 * @return the checks if is human right center
	 */
	public Boolean getIsHumanRightCenter() {
		return this.isHumanRightCenter;
	}

	/**
	 * Sets the checks if is human right center.
	 * 
	 * @param isHumanRightCenter
	 *            the new checks if is human right center
	 */
	public void setIsHumanRightCenter(Boolean isHumanRightCenter) {
		this.isHumanRightCenter = isHumanRightCenter;
	}

}
