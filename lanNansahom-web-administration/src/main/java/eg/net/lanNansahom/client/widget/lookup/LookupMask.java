package eg.net.lanNansahom.client.widget.lookup;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.core.client.GWT;

import eg.net.gxt.client.widget.BaseFormPanel;
import eg.net.gxt.client.widget.ComboBoxBean;
import eg.net.gxt.client.widget.SimpleComboBox;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.LookupBean;

public class LookupMask extends BaseFormPanel<LookupBean> {

	/** The title control. */
	private SimpleComboBox typeControl;

	/** The title control. */
	private TextField<String> nameControl;

	/** The description control. */
	private TextField<String> descriptionControl;

	/**
	 * Instantiates a new lookup mask.
	 */
	public LookupMask(String pLookupType) {
		super(new LookupBean(), constructTitle(true));
		if (pLookupType != null) {
			getBean().setType(pLookupType);
		}
	}

	/**
	 * Instantiates a new lookup mask.
	 * 
	 * @param announcementBean
	 *            the announcement bean
	 */
	public LookupMask(LookupBean lookupBean) {
		super(lookupBean, constructTitle(false));
	}

	/**
	 * Constuct title.
	 * 
	 * @return the string
	 */
	private static String constructTitle(boolean isNew) {
		Messages messages = GWT.create(Messages.class);
		String result = messages.lookup() + "-> ";
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
		typeControl = new SimpleComboBox("", messages.type());
		for (LookupType type : LookupType.values()) {
			typeControl.add(type.name());
		}
		typeControl.setEditable(false);
		if (getBean().getType() != null) {
			typeControl.setValue(new ComboBoxBean(getBean().getType()));
		}
		panel.add(typeControl, new FormData("30%"));

		nameControl = new TextField<String>();
		nameControl.setName(LookupBean.BINDING_NAME);
		nameControl.setFieldLabel(messages.name());
		panel.add(nameControl, new FormData("30%"));

		descriptionControl = new TextField<String>();
		descriptionControl.setName(LookupBean.BINDING_DESCRIPTION);
		descriptionControl.setFieldLabel(messages.description());
		panel.add(descriptionControl, new FormData("30%"));

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
				LookupBean bean = getBean();
				bean.setType(typeControl.getValue().getName());
				if (bean.getId() != 0) {
					Dispatcher.forwardEvent(AppEvents.UPDATE_LOOKUP, bean);
				} else {
					Dispatcher.forwardEvent(AppEvents.ADD_LOOKUP, bean);
				}

			}
		});

	}
}
