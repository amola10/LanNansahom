package eg.net.gxt.client.widget;

import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;

public class SimpleComboBox extends ComboBox<ComboBoxBean> {

	ListStore<ComboBoxBean> store = new ListStore<ComboBoxBean>();

	public SimpleComboBox(String name, String label) {
		super();
		setName(name);
		if (label != null) {
			setFieldLabel(label);
		}
		setValueField(ComboBoxBean.BINDING_NAME);
		setDisplayField(ComboBoxBean.BINDING_NAME);
		setTriggerAction(TriggerAction.ALL);
		setStore(store);

	}

	public void add(String pValue) {
		store.add(new ComboBoxBean(pValue));
	}

	public void setAsDefault(String pValue) {
		setValue(new ComboBoxBean(pValue));
	}
}
