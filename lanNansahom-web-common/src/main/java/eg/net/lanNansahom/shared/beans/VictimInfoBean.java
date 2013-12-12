package eg.net.lanNansahom.shared.beans;

import java.util.Date;

import eg.net.gxt.client.BaseBean;

public class VictimInfoBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2624228321118506608L;
	public static final String BINDING_ID = "BINDING_ID";
	public static final String BINDING_NAME = "BINDING_NAME";
	public static final String BINDING_IMAGE = "BINDING_IMAGE";
	public static final String BINDING_DEATH_AREA = "BINDING_DEATH_AREA";
	public static final String BINDING_DEATH_DATE = "BINDING_DEATH_DATE";

	/**
	 * Amal :Unused field added to avoid serializationException bug in GXT &
	 * GWT.Please don't Remove.
	 */
	@SuppressWarnings("unused")
	private ImageBean unsed;
	@SuppressWarnings("unused1")
	private LookupBean unsed1;

	public VictimInfoBean() {
		super();
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

	/**
	 * @return the profileThumbnail
	 */
	public ImageBean getProfileThumbnail() {
		return get(BINDING_IMAGE);
	}

	/**
	 * @param profileThumbnail
	 *            the profileThumbnail to set
	 */
	public void setProfileThumbnail(ImageBean profileThumbnail) {
		set(BINDING_IMAGE, profileThumbnail);
	}

	/**
	 * @return the deathArea
	 */
	public LookupBean getDeathArea() {
		return get(BINDING_DEATH_AREA);
	}

	/**
	 * @param deathArea
	 *            the deathArea to set
	 */
	public void setDeathArea(LookupBean deathArea) {
		set(BINDING_DEATH_AREA, deathArea);
	}

	/**
	 * @return the deathDate
	 */
	public Date getDeathDate() {
		return get(BINDING_DEATH_DATE);
	}

	/**
	 * @param deathDate
	 *            the deathDate to set
	 */
	public void setDeathDate(Date deathDate) {
		set(BINDING_DEATH_DATE, deathDate);
	}

}
