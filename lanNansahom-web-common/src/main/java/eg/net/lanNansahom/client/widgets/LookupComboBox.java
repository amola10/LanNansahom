package eg.net.lanNansahom.client.widgets;

import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.widget.form.ComboBox;

import eg.net.lanNansahom.client.LookupsManager;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.LookupBean;

public class LookupComboBox extends ComboBox<LookupBean> {

	public LookupComboBox(String name, String label, LookupType lookupType) {
		super();
		setName(name);
		if (label != null) {
			setFieldLabel(label);
		}
		setValueField(LookupBean.BINDING_ID);
		setDisplayField(LookupBean.BINDING_NAME);
		setTriggerAction(TriggerAction.ALL);
		setEditable(true);
		setStore(LookupsManager.getLookupStore(lookupType));

	}

	public LookupComboBox(String name, String label, LookupType lookupType, KeyListener keyListener) {
		this(name, label, lookupType);
		addKeyListener(keyListener);

	}

}
