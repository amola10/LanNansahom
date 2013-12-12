package eg.net.lanNansahom.services.beans;

import eg.net.lanNansahom.shared.LookupType;

/**
 * The Class Lookup.
 */
public class Lookup implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4636935037897516500L;

	/** The id. */
	private int id;

	/** The name. */
	private String name;

	/** The description. */
	private String description;

	private LookupType lookupType;

	/**
	 * Instantiates a new lookup.
	 */
	public Lookup() {
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
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * @return the lookuptype
	 */
	public LookupType getLookupType() {
		return lookupType;
	}

	/**
	 * @param lookuptype
	 *            the lookuptype to set
	 */
	public void setLookupType(LookupType lookuptype) {
		this.lookupType = lookuptype;
	}

	public String getType() {
		return this.lookupType != null ? this.lookupType.name() : null;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setType(String type) {
		if (type != null) {
			this.lookupType = LookupType.valueOf(type);
		}
	}

}
