package eg.net.lanNansahom.client.widget.victims;

import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.core.client.GWT;

import eg.net.gxt.client.widget.BaseFormPanel;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.shared.beans.ArticleBean;

public class ArticleDetailsMask extends BaseFormPanel<ArticleBean> {

	private HtmlEditor descriptionControl;

	public ArticleDetailsMask(ArticleBean bean) {
		super(bean, null);
	}

	@Override
	protected void attachFormControls(FormPanel panel) {
		panel.setSize(495, 395);

		Messages messages = GWT.create(Messages.class);

		TextField<String> titleControl = new TextField<String>();
		titleControl.setName(ArticleBean.BINDING_TITLE);
		titleControl.setFieldLabel(messages.title());
		panel.add(titleControl);

		TextField<String> referanceControl = new TextField<String>();
		referanceControl.setName(ArticleBean.BINDING_REFERANCE);
		referanceControl.setFieldLabel(messages.referance());
		panel.add(referanceControl);

		TextField<String> authorControl = new TextField<String>();
		authorControl.setName(ArticleBean.BINDING_AUTHOR);
		authorControl.setFieldLabel(messages.author());
		panel.add(authorControl);

		DateField dateControl = new DateField();
		dateControl.setName(ArticleBean.BINDING_DATE);
		dateControl.setFieldLabel(messages.takenDate());
		panel.add(dateControl);

		descriptionControl = new HtmlEditor();
		descriptionControl.setName(ArticleBean.BINDING_BODY);
		descriptionControl.setHideLabel(true);
		panel.add(descriptionControl, new FormData("100% -53"));

	}

	@Override
	protected void attachFormButtons(FormPanel panel) {
	}

	public String getBody() {
		return descriptionControl.getValue();
	}

}
