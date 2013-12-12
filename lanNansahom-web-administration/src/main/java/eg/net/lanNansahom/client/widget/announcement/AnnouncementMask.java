package eg.net.lanNansahom.client.widget.announcement;

import java.util.Date;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.core.client.GWT;

import eg.net.gxt.client.widget.BaseFormPanel;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.shared.beans.AnnouncementBean;

/**
 * The Class AnnouncementMask.
 */
public class AnnouncementMask extends BaseFormPanel<AnnouncementBean> {

	/** The title control. */
	private TextField<String> titleControl;

	/** The description control. */
	private HtmlEditor descriptionControl;

	/**
	 * Instantiates a new announcement mask.
	 */
	public AnnouncementMask() {
		super(new AnnouncementBean(), constructTitle(true));
	}

	/**
	 * Instantiates a new announcement mask.
	 * 
	 * @param announcementBean
	 *            the announcement bean
	 */
	public AnnouncementMask(AnnouncementBean announcementBean) {
		super(announcementBean, constructTitle(false));
	}

	/**
	 * Constuct title.
	 * 
	 * @return the string
	 */
	private static String constructTitle(boolean isNew) {
		Messages messages = GWT.create(Messages.class);
		String result = messages.announcements() + "-> ";
		if (isNew) {
			result += messages.add();
		} else {
			result += messages.update();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.gxt.client.widget.BaseFormPanel#attachFormControls(com.extjs.gxt
	 * .ui.client.widget.form.FormPanel)
	 */
	@Override
	protected void attachFormControls(FormPanel panel) {
		Messages messages = GWT.create(Messages.class);
		titleControl = new TextField<String>();
		titleControl.setName(AnnouncementBean.BINDING_TITLE);
		titleControl.setFieldLabel(messages.title());
		panel.add(titleControl, new FormData("100%"));

		descriptionControl = new HtmlEditor();
		descriptionControl.setName(AnnouncementBean.BINDING_TEXT);
		descriptionControl.setHideLabel(true);
		panel.add(descriptionControl, new FormData("100% -53"));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.gxt.client.widget.BaseFormPanel#attachFormButtons(com.extjs.gxt
	 * .ui.client.widget.form.FormPanel)
	 */
	@Override
	protected void attachFormButtons(FormPanel panel) {
		Messages messages = GWT.create(Messages.class);
		Button button = new Button(messages.save());
		panel.addButton(button);
		button.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				AnnouncementBean bean = getBean();
				bean.setText(descriptionControl.getValue());
				bean.setDate(new Date());
				if (bean.getId() != 0) {
					Dispatcher.forwardEvent(AppEvents.UPDATE_ANNOUNCEMENT, bean);
				} else {
					Dispatcher.forwardEvent(AppEvents.ADD_ANNOUNCEMENT, bean);
				}

			}
		});

	}
}
