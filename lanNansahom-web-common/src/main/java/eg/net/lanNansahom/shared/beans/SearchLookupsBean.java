package eg.net.lanNansahom.shared.beans;

import eg.net.gxt.client.BaseBean;
import eg.net.gxt.client.widget.ComboBoxBean;

public class SearchLookupsBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1511197128577835537L;
	public static final String BINDING_TYPE = "BINDING_TYPE";

	public SearchLookupsBean() {
		super();
	}

	public ComboBoxBean getType() {
		return get(BINDING_TYPE);
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setType(ComboBoxBean type) {
		set(BINDING_TYPE, type);
	}

}
