package eg.net.lanNansahom.client.widget.martyr;

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
import eg.net.lanNansahom.shared.beans.MartyrBean;

public class MartyrDethDataPanel extends LayoutContainer {

	private final LayoutContainer left;
	private final LayoutContainer center;
	private final LayoutContainer right;

	public MartyrDethDataPanel() {
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
		left.add(new LookupComboBox(MartyrBean.BINDING_DEATH_AREA, messages.deathArea(), LookupType.AREA));

		DateField deathDateControl = new DateField();
		deathDateControl.setName(MartyrBean.BINDING_DEATH_DATE);
		deathDateControl.setFieldLabel(messages.deathDate());
		center.add(deathDateControl);

		left.add(new LookupComboBox(MartyrBean.BINDING_CORPSE_DISCOVERY_AREA, messages.corpseDiscoveryArea(),
				LookupType.AREA));

		DateField corpseDiscoveryDateControl = new DateField();
		corpseDiscoveryDateControl.setName(MartyrBean.BINDING_CORPSE_DISCOVERY_DATE);
		corpseDiscoveryDateControl.setFieldLabel(messages.corpseDiscoveryDate());
		center.add(corpseDiscoveryDateControl);

	}

}
