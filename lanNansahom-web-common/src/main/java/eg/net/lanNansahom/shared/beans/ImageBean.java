package eg.net.lanNansahom.shared.beans;

public class ImageBean extends ResourceBean {

	private static final long serialVersionUID = -2376375445732525097L;
	public static final String BINDING_CATEGORY = "BINDING_CATEGORY";
	public static final String BINDING_VICTIM_ID = "BINDING_VICTIM_ID";

	private static final int NORMAL_CATEGORY_ID = 1;

	public ImageBean() {
		super();
		LookupBean bean = new LookupBean();
		bean.setId(NORMAL_CATEGORY_ID);
		bean.setName("Normal");
		setCategory(bean);
	}

	/**
	 * @return the category
	 */
	public LookupBean getCategory() {
		return get(BINDING_CATEGORY);
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(LookupBean category) {
		set(BINDING_CATEGORY, category);
	}

}
