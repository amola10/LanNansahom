package eg.net.lanNansahom.services.beans;

import java.util.Date;

/**
 * The Class Article.
 */
public class Article implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4988657860521411358L;

	/** The id. */
	private int id;

	/** The title. */
	private String title;

	/** The author. */
	private String author;

	/** The body. */
	private String body;

	/** The date. */
	private Date date;

	/** The reference. */
	private String reference;

	/**
	 * Instantiates a new article.
	 */
	public Article() {
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
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the author.
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * Sets the author.
	 * 
	 * @param author
	 *            the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Gets the body.
	 * 
	 * @return the body
	 */
	public String getBody() {
		return this.body;
	}

	/**
	 * Sets the body.
	 * 
	 * @param body
	 *            the new body
	 */
	public void setBody(String body) {
		this.body = body;
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
	 * Gets the reference.
	 * 
	 * @return the reference
	 */
	public String getReference() {
		return this.reference;
	}

	/**
	 * Sets the reference.
	 * 
	 * @param reference
	 *            the new reference
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}
}
