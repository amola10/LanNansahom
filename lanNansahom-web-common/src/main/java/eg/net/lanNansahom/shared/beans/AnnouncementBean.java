package eg.net.lanNansahom.shared.beans;

import java.util.Date;

import eg.net.gxt.client.BaseBean;

public class AnnouncementBean extends BaseBean {

	private static final long serialVersionUID = 3235931502115450416L;
	public static final String BINDING_ID = "BINDING_ID";
	public static final String BINDING_TITLE = "BINDING_TITLE";
	public static final String BINDING_TEXT = "BINDING_TEXT";
	public static final String BINDING_DATE = "BINDING_DATE";
	public static final String BINDING_PUBLISHED = "BINDING_PUBLISHED";

	public AnnouncementBean() {
		super();
	}

	public AnnouncementBean(int id, String title, String text, Date date, Boolean published) {
		super();
		setId(id);
		setTitle(title);
		setText(text);
		setDate(date);
		setPublished(published);
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
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return get(BINDING_TITLE, null);
	}

	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            the new text
	 */
	public void setTitle(String title) {
		set(BINDING_TITLE, title);
	}

	/**
	 * Gets the text.
	 * 
	 * @return the text
	 */
	public String getText() {
		return get(BINDING_TEXT, null);
	}

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		set(BINDING_TEXT, text);
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return get(BINDING_DATE, null);
	}

	/**
	 * Sets the date.
	 * 
	 * @param date
	 *            the new date
	 */
	public void setDate(Date date) {
		set(BINDING_DATE, date);
	}

	public Boolean getPublished() {
		return get(BINDING_PUBLISHED, false);
	}

	public void setPublished(Boolean published) {
		set(BINDING_PUBLISHED, published);
	}
}
