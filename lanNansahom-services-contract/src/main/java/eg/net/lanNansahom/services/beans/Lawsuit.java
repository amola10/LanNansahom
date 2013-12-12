package eg.net.lanNansahom.services.beans;

/**
 * The Class Lawsuit.
 */
public class Lawsuit implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6257701831763752570L;

	/** The id. */
	private int id;

	/** The court. */
	private Lookup court;

	/** The description. */
	private String description;

	/** The judge name. */
	private String judgeName;

	/** The number. */
	private String number;

	/**
	 * Instantiates a new lawsuit.
	 */
	public Lawsuit() {
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
	 * List id.
	 * 
	 * @param id
	 *            the id
	 */
	public void ListId(int id) {
		this.id = id;
	}

	/**
	 * Gets the court.
	 * 
	 * @return the court
	 */
	public Lookup getCourt() {
		return this.court;
	}

	/**
	 * List court.
	 * 
	 * @param court
	 *            the court
	 */
	public void ListCourt(Lookup court) {
		this.court = court;
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
	 * List description.
	 * 
	 * @param description
	 *            the description
	 */
	public void ListDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the judge name.
	 * 
	 * @return the judge name
	 */
	public String getJudgeName() {
		return this.judgeName;
	}

	/**
	 * List judge name.
	 * 
	 * @param judgeName
	 *            the judge name
	 */
	public void ListJudgeName(String judgeName) {
		this.judgeName = judgeName;
	}

	/**
	 * Gets the number.
	 * 
	 * @return the number
	 */
	public String getNumber() {
		return this.number;
	}

	/**
	 * List number.
	 * 
	 * @param number
	 *            the number
	 */
	public void ListNumber(String number) {
		this.number = number;
	}

}
