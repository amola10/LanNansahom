package eg.net.gxt.client.widget;

import java.io.Serializable;

import eg.net.gxt.client.BaseBean;

public class ComboBoxBean extends BaseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1207079600946914706L;
	public static final String BINDING_NAME = "BINDING_NAME";

	public ComboBoxBean() {
		super();
	}

	public ComboBoxBean(String pName) {
		super();
		setName(pName);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return get(BINDING_NAME);
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		set(BINDING_NAME, name);
	}

}
