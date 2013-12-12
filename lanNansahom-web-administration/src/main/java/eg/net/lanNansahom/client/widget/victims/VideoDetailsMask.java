package eg.net.lanNansahom.client.widget.victims;

import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;

import eg.net.gxt.client.widget.BaseFormPanel;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.widgets.LookupComboBox;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.VideoBean;

public class VideoDetailsMask extends BaseFormPanel<VideoBean> {

	public VideoDetailsMask(VideoBean bean) {
		super(bean, null);
	}

	@Override
	protected void attachFormControls(FormPanel panel) {
		panel.setSize(295, 195);

		Messages messages = GWT.create(Messages.class);

		TextField<String> namrControl = new TextField<String>();
		namrControl.setName(VideoBean.BINDING_DESCRIPTION);
		namrControl.setFieldLabel(messages.name());
		panel.add(namrControl);

		TextField<String> urlControl = new TextField<String>();
		urlControl.setName(VideoBean.BINDING_URL);
		urlControl.setFieldLabel(messages.videoId());
		panel.add(urlControl);

		panel.add(new LookupComboBox(VideoBean.BINDING_CATEGORY, messages.category(), LookupType.VIDEO_CATEGORY));

		TextField<String> ownerControl = new TextField<String>();
		ownerControl.setName(VideoBean.BINDING_OWNER);
		ownerControl.setFieldLabel(messages.takenBy());
		panel.add(ownerControl);

		DateField dateControl = new DateField();
		dateControl.setName(VideoBean.BINDING_DATE);
		dateControl.setFieldLabel(messages.takenDate());
		panel.add(dateControl);

	}

	@Override
	protected void attachFormButtons(FormPanel panel) {
	}

}
