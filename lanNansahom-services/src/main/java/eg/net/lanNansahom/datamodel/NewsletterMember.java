package eg.net.lanNansahom.datamodel;

// Generated Aug 19, 2011 8:10:22 PM by Hibernate Tools 3.4.0.CR1

/**
 * NewsletterMember generated by hbm2java
 */
public class NewsletterMember implements java.io.Serializable {

	private static final long serialVersionUID = 2849420641726601521L;
	private int id;
	private String email;

	public NewsletterMember() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
