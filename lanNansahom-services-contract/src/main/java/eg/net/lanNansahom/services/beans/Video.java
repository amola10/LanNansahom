package eg.net.lanNansahom.services.beans;

public class Video extends Resource {

	private static final long serialVersionUID = 7562159306534965247L;
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
