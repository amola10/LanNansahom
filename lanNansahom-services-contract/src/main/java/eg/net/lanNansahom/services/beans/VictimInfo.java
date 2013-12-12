package eg.net.lanNansahom.services.beans;

import java.util.Date;

public class VictimInfo {

	private int id;
	private String name;
	private Lookup deathArea;
	private Date deathDate;
	private Image profileThumbnail;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the profileThumbnail
	 */
	public Image getProfileThumbnail() {
		return profileThumbnail;
	}

	/**
	 * @param profileThumbnail
	 *            the profileThumbnail to set
	 */
	public void setProfileThumbnail(Image profileThumbnail) {
		this.profileThumbnail = profileThumbnail;
	}

	/**
	 * @return the deathArea
	 */
	public Lookup getDeathArea() {
		return deathArea;
	}

	/**
	 * @param deathArea
	 *            the deathArea to set
	 */
	public void setDeathArea(Lookup deathArea) {
		this.deathArea = deathArea;
	}

	/**
	 * @return the deathDate
	 */
	public Date getDeathDate() {
		return deathDate;
	}

	/**
	 * @param deathDate
	 *            the deathDate to set
	 */
	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

}
