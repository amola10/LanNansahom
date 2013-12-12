package eg.net.lanNansahom.services.beans;

import java.util.Date;

/**
 * The Class CourtSession.
 */
public class CourtSession implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7636533085904819206L;

	/** The id. */
	private int id;

	/** The date. */
	private Date date;

	/** The decision. */
	private String decision;

	/** The description. */
	private String description;

	/**
	 * Instantiates a new court session.
	 */
	public CourtSession() {
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
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * Sets the date.
	 * 
	 * @param date
	 *            the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the decision.
	 * 
	 * @return the decision
	 */
	public String getDecision() {
		return decision;
	}

	/**
	 * Sets the decision.
	 * 
	 * @param decision
	 *            the new decision
	 */
	public void setDecision(String decision) {
		this.decision = decision;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
