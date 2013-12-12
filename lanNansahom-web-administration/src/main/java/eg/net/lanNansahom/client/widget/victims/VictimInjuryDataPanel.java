package eg.net.lanNansahom.client.widget.victims;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;

import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.widgets.LookupComboBox;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.VictimBean;

public class VictimInjuryDataPanel extends LayoutContainer {
	private final LayoutContainer left;
	private final LayoutContainer center;
	private final LayoutContainer right;

	public VictimInjuryDataPanel() {
		super();
		setLayout(new ColumnLayout());

		left = new LayoutContainer();
		left.setStyleAttribute("paddingRight", "10px");
		FormLayout layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		left.setLayout(layout);

		center = new LayoutContainer();
		center.setStyleAttribute("paddingRight", "10px");
		layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		center.setLayout(layout);

		right = new LayoutContainer();
		right.setStyleAttribute("paddingLeft", "10px");
		layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		right.setLayout(layout);

		init();

		add(left, new ColumnData(.3));
		add(center, new ColumnData(.3));
		add(right, new ColumnData(.4));

	}

	private void init() {
		Messages messages = GWT.create(Messages.class);

		left.add(new LookupComboBox(VictimBean.BINDING_INJURY_AREA, messages.injuryArea(), LookupType.AREA));

		DateField injuryDateControl = new DateField();
		injuryDateControl.setName(VictimBean.BINDING_INJURY_DATE);
		injuryDateControl.setFieldLabel(messages.injuryDate());
		center.add(injuryDateControl);

		left.add(new LookupComboBox(VictimBean.BINDING_HOSPITAL, messages.hospital(), LookupType.HOSPITAL));

	}

}
