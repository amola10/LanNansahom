package eg.net.lanNansahom.shared.beans;

import java.io.Serializable;

import eg.net.gxt.client.BaseBean;

public class LookupBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 2757534783691655657L;
	public static final String BINDING_ID = "BINDING_ID";
	public static final String BINDING_NAME = "BINDING_NAME";
	public static final String BINDING_TYPE = "BINDING_TYPE";
	public static final String BINDING_DESCRIPTION = "BINDING_DESCRIPTION";

	public LookupBean() {
		super();
	}

	public LookupBean(int id, String pName) {
		super();
		setId(id);
		setName(pName);
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

	public String getType() {
		return get(BINDING_TYPE);
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setType(String type) {
		set(BINDING_TYPE, type);
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return get(BINDING_DESCRIPTION);
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		set(BINDING_DESCRIPTION, description);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName();
	}

}
