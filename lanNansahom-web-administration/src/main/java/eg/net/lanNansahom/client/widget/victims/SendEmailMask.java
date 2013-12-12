package eg.net.lanNansahom.client.widget.victims;

import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;

import eg.net.gxt.client.widget.BaseFormPanel;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.shared.beans.EmailBean;

public class SendEmailMask extends BaseFormPanel<EmailBean> {

	private HtmlEditor messageControl;

	public SendEmailMask(EmailBean bean) {
		super(bean, null);
	}

	@Override
	protected void attachFormControls(FormPanel panel) {
		panel.setSize(545, 395);

		Messages messages = GWT.create(Messages.class);

		TextField<String> fromControl = new TextField<String>();
		fromControl.setName(EmailBean.BINDING_FROM);
		fromControl.setFieldLabel(messages.from());
		fromControl.setReadOnly(true);
		panel.add(fromControl);

		TextField<String> toControl = new TextField<String>();
		toControl.setName(EmailBean.BINDING_TO);
		toControl.setFieldLabel(messages.to());
		toControl.setReadOnly(true);
		panel.add(toControl);

		TextField<String> subjectControl = new TextField<String>();
		subjectControl.setName(EmailBean.BINDING_SUBJECT);
		subjectControl.setFieldLabel(messages.subject());
		subjectControl.setAllowBlank(false);
		panel.add(subjectControl);

		messageControl = new HtmlEditor();
		messageControl.setName(EmailBean.BINDING_MESSAGE);
		messageControl.setFieldLabel(messages.message());
		messageControl.setSize(500, 210);
		panel.add(messageControl);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.gxt.client.widget.BaseFormPanel#getBean()
	 */
	@Override
	public EmailBean getBean() {
		EmailBean result = super.getBean();
		result.setMessage(messageControl.getValue());
		return result;
	}

	@Override
	protected void attachFormButtons(FormPanel panel) {
	}

}
