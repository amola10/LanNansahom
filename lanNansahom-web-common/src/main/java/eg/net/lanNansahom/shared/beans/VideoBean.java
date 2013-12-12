package eg.net.lanNansahom.shared.beans;

public class VideoBean extends ResourceBean {

	private static final long serialVersionUID = 7889310269863585720L;
	public static final String BINDING_CATEGORY = "BINDING_CATEGORY";
	private static final int NORMAL_CATEGORY_ID = 1;

	public VideoBean() {
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
