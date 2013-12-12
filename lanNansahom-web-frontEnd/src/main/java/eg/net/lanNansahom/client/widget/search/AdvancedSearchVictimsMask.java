package eg.net.lanNansahom.client.widget.search;

import java.util.Date;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;

import eg.net.gxt.client.widget.BaseFormPanel;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.widgets.LookupComboBox;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.SearchVictimsBean;

public class AdvancedSearchVictimsMask extends BaseFormPanel<SearchVictimsBean> {

	public AdvancedSearchVictimsMask() {
		super(new SearchVictimsBean(), null);
		setBorders(false);

	}

	@Override
	protected void attachFormControls(FormPanel panel) {
		LayoutContainer main = new LayoutContainer();
		main.setLayout(new ColumnLayout());
		main.setBorders(false);

		LayoutContainer left = new LayoutContainer();
		FormLayout layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		left.setLayout(layout);

		LayoutContainer center = new LayoutContainer();
		layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		center.setLayout(layout);

		LayoutContainer right = new LayoutContainer();
		layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		right.setLayout(layout);

		main.add(right, new ColumnData(.4));
		main.add(center, new ColumnData(.3));
		main.add(left, new ColumnData(.3));

		Messages messages = GWT.create(Messages.class);
		final TextField<String> nameControl = new TextField<String>();
		nameControl.setName(SearchVictimsBean.BINDING_NAME);
		nameControl.setFieldLabel(messages.name());
		nameControl.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					getBean().setName(nameControl.getValue());
					Dispatcher.forwardEvent(AppEvents.ADVANCED_SEARCH_EVENT, getBean());
				}
			}

		});
		left.add(nameControl);

		final NumberField ageControl = new NumberField();
		ageControl.setPropertyEditorType(Integer.class);
		ageControl.setName(SearchVictimsBean.BINDING_AGE);
		ageControl.setFieldLabel(messages.age());
		ageControl.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					getBean().setAge((Integer) ageControl.getValue());
					Dispatcher.forwardEvent(AppEvents.ADVANCED_SEARCH_EVENT, getBean());
				}
			}

		});

		center.add(ageControl);

		final LookupComboBox education = new LookupComboBox(SearchVictimsBean.BINDING_EDUCATION, messages.education(),
				LookupType.EDUCATION);
		education.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					getBean().setEducation(education.getValue());
					Dispatcher.forwardEvent(AppEvents.ADVANCED_SEARCH_EVENT, getBean());
				}
			}

		});
		right.add(education);

		final LookupComboBox area = new LookupComboBox(SearchVictimsBean.BINDING_AREA, messages.placeOfDeath(),
				LookupType.AREA);
		area.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					getBean().setArea(area.getValue());
					Dispatcher.forwardEvent(AppEvents.ADVANCED_SEARCH_EVENT, getBean());
				}
			}

		});
		left.add(area);

		final DateField dateControl = new DateField();
		dateControl.setName(SearchVictimsBean.BINDING_DATE);
		dateControl.setFieldLabel(messages.dateOfDeath());
		dateControl.getDatePicker().getMessages().setCancelText(messages.cancle());
		dateControl.getDatePicker().getMessages().setOkText(messages.ok());
		dateControl.getDatePicker().getMessages().setMonthYearText(messages.selectMonthYear());
		dateControl.getDatePicker().getMessages().setNextText(messages.nextMonth());
		dateControl.getDatePicker().getMessages().setPrevText(messages.prevMoth());
		dateControl.getDatePicker().getMessages().setTodayText(messages.today());
		dateControl.getDatePicker().getMessages().setTodayTip(DateTimeFormat.getShortDateFormat().format(new Date()));
		dateControl.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					getBean().setDate(dateControl.getValue());
					Dispatcher.forwardEvent(AppEvents.ADVANCED_SEARCH_EVENT, getBean());
				}
			}

		});
		center.add(dateControl);

		final LookupComboBox job = new LookupComboBox(SearchVictimsBean.BINDING_JOB, messages.job(), LookupType.JOB);
		job.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					getBean().setJob(job.getValue());
					Dispatcher.forwardEvent(AppEvents.ADVANCED_SEARCH_EVENT, getBean());
				}
			}

		});
		right.add(job);

		panel.add(main, new FormData("100%"));
		panel.setBorders(false);
		panel.setBodyBorder(false);

	}

	@Override
	protected void attachFormButtons(FormPanel panel) {
		panel.setButtonAlign(HorizontalAlignment.LEFT);
		Messages messages = GWT.create(Messages.class);

		Button button = new Button(messages.search());
		panel.addButton(button);
		button.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Dispatcher.forwardEvent(AppEvents.ADVANCED_SEARCH_EVENT, getBean());
			}
		});

	}

}