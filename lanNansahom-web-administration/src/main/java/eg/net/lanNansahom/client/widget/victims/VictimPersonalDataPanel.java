package eg.net.lanNansahom.client.widget.victims;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;

import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.widgets.LookupComboBox;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.VictimBean;

public class VictimPersonalDataPanel extends LayoutContainer {

	private final LayoutContainer left;
	private final LayoutContainer center;
	private final LayoutContainer right;

	public VictimPersonalDataPanel() {
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

		TextField<String> nameControl = new TextField<String>();
		nameControl.setName(VictimBean.BINDING_NAME);
		nameControl.setFieldLabel(messages.name());
		left.add(nameControl);

		TextField<String> nationalIdControl = new TextField<String>();
		nationalIdControl.setName(VictimBean.BINDING_NATIONAL_ID);
		nationalIdControl.setFieldLabel(messages.nationalId());
		center.add(nationalIdControl);

		right.add(new LookupComboBox(VictimBean.BINDING_SOURCE, messages.source(), LookupType.SOURCE));

		DateField birthDayControl = new DateField();
		birthDayControl.setName(VictimBean.BINDING_BIRTHDATE);
		birthDayControl.setFieldLabel(messages.birthday());
		left.add(birthDayControl);

		center.add(new LookupComboBox(VictimBean.BINDING_PLACE_OF_BIRTH, messages.placeOfBirth(), LookupType.AREA));

		NumberField ageControl = new NumberField();
		ageControl.setPropertyEditorType(Integer.class);
		ageControl.setName(VictimBean.BINDING_AGE);
		ageControl.setFieldLabel(messages.age());
		right.add(ageControl);

		left.add(new LookupComboBox(VictimBean.BINDING_EDUCATION, messages.education(), LookupType.EDUCATION));

		center.add(new LookupComboBox(VictimBean.BINDING_JOB, messages.job(), LookupType.JOB));

		TextField<String> employerControl = new TextField<String>();
		employerControl.setName(VictimBean.BINDING_EMPLOYER);
		employerControl.setFieldLabel(messages.employer());
		right.add(employerControl);

		TextField<String> addressControl = new TextField<String>();
		addressControl.setName(VictimBean.BINDING_ADDRESS);
		addressControl.setFieldLabel(messages.address());
		left.add(addressControl);

		center.add(new LookupComboBox(VictimBean.BINDING_RESIDENCE_AREA, messages.residenceArea(), LookupType.AREA));

		right.add(new LookupComboBox(VictimBean.BINDING_RECORD_STATUS, messages.recordStatus(),
				LookupType.RECORD_STATUS));

	}

}
