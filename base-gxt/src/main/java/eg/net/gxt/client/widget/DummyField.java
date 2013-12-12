package eg.net.gxt.client.widget;

import com.extjs.gxt.ui.client.widget.form.AdapterField;
import com.google.gwt.user.client.ui.HTML;

public class DummyField extends AdapterField {

	public DummyField(int height) {
		super(new HTML("<div style=\"height: " + height + "px; width: 1px;\"></div>"));
		this.setLabelSeparator("");
	}

}
