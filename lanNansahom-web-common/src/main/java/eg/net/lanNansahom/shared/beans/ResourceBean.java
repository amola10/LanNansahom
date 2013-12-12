package eg.net.lanNansahom.shared.beans;

import java.util.Date;

import eg.net.gxt.client.BaseBean;

public class ResourceBean extends BaseBean {

	private static final long serialVersionUID = 364504457904375007L;
	public static final String BINDING_ID = "BINDING_ID";
	public static final String BINDING_DESCRIPTION = "BINDING_DESCRIPTION";
	public static final String BINDING_URL = "BINDING_URL";
	public static final String BINDING_OWNER = "BINDING_OWNER";
	public static final String BINDING_DATE = "BINDING_DATE";

	/**
	 * Amal :Unused field added to avoid serializationException bug in GXT &
	 * GWT.Please don't Remove.
	 */
	@SuppressWarnings("unused")
	private LookupBean unsed;

	/**
	 * Instantiates a new resource.
	 */
	public ResourceBean() {
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

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return get(BINDING_URL);
	}

	/**
	 * Sets the url.
	 * 
	 * @param url
	 *            the new url
	 */
	public void setUrl(String url) {
		set(BINDING_URL, url);
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return get(BINDING_OWNER);
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(String owner) {
		set(BINDING_OWNER, owner);
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return get(BINDING_DATE);
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		set(BINDING_DATE, date);
	}
}
