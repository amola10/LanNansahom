package eg.net.lanNansahom.services.beans;

public class Image extends Resource {

	private static final long serialVersionUID = -8849773801537695958L;
	private Lookup category;

	/**
	 * @return the category
	 */
	public Lookup getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(Lookup category) {
		this.category = category;
	}

}
