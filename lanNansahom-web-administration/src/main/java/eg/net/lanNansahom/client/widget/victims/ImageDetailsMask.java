package eg.net.lanNansahom.client.widget.victims;

import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;

import eg.net.gxt.client.widget.BaseFormPanel;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.widgets.LookupComboBox;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.ImageBean;

public class ImageDetailsMask extends BaseFormPanel<ImageBean> {

	public ImageDetailsMask(ImageBean bean) {
		super(bean, null);
	}

	@Override
	protected void attachFormControls(FormPanel panel) {
		panel.setSize(295, 195);

		Messages messages = GWT.create(Messages.class);

		TextField<String> urlControl = new TextField<String>();
		urlControl.setName(ImageBean.BINDING_URL);
		urlControl.setFieldLabel(messages.id());
		panel.add(urlControl);

		TextField<String> nameControl = new TextField<String>();
		nameControl.setName(ImageBean.BINDING_DESCRIPTION);
		nameControl.setFieldLabel(messages.name());
		nameControl.setEnabled(false);
		panel.add(nameControl);

		panel.add(new LookupComboBox(ImageBean.BINDING_CATEGORY, messages.category(), LookupType.IMAGE_CATEGORY));

		TextField<String> ownerControl = new TextField<String>();
		ownerControl.setName(ImageBean.BINDING_OWNER);
		ownerControl.setFieldLabel(messages.takenBy());
		panel.add(ownerControl);

		DateField dateControl = new DateField();
		dateControl.setName(ImageBean.BINDING_DATE);
		dateControl.setFieldLabel(messages.takenDate());
		panel.add(dateControl);

	}

	@Override
	protected void attachFormButtons(FormPanel panel) {
	}

}
