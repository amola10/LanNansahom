package eg.net.lanNansahom.datamodel;

// Generated Aug 19, 2011 8:10:22 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Image generated by hbm2java
 */
public class Image implements java.io.Serializable {

	private static final long serialVersionUID = 7658476489421389401L;
	private int id;
	private String description;
	private String url;
	private String owner;
	private Date date;
	private ImageCategory category;

	public Image() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the category
	 */
	public ImageCategory getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(ImageCategory category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}