package eg.net.lanNansahom.shared.beans;

import java.util.Date;

import eg.net.gxt.client.BaseBean;

public class ArticleBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1076598761992459039L;
	public static final String BINDING_ID = "BINDING_ID";
	public static final String BINDING_TITLE = "BINDING_TITLE";
	public static final String BINDING_BODY = "BINDING_BODY";
	public static final String BINDING_DATE = "BINDING_DATE";
	public static final String BINDING_AUTHOR = "BINDING_AUTHOR";
	public static final String BINDING_REFERANCE = "BINDING_REFERANCE";

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
		return get(BINDING_TITLE);
	}

	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		set(BINDING_TITLE, title);
	}

	/**
	 * Gets the author.
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return get(BINDING_AUTHOR);
	}

	/**
	 * Sets the author.
	 * 
	 * @param author
	 *            the new author
	 */
	public void setAuthor(String author) {
		set(BINDING_AUTHOR, author);
	}

	/**
	 * Gets the body.
	 * 
	 * @return the body
	 */
	public String getBody() {
		return get(BINDING_BODY);
	}

	/**
	 * Sets the body.
	 * 
	 * @param body
	 *            the new body
	 */
	public void setBody(String body) {
		set(BINDING_BODY, body);
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return get(BINDING_DATE);
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

	/**
	 * Gets the reference.
	 * 
	 * @return the reference
	 */
	public String getReference() {
		return get(BINDING_REFERANCE);
	}

	/**
	 * Sets the reference.
	 * 
	 * @param reference
	 *            the new reference
	 */
	public void setReference(String reference) {
		set(BINDING_REFERANCE, reference);
	}

}
