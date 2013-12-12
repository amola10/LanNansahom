package eg.net.lanNansahom.client.widget.victims;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
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
import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

import eg.net.gxt.client.widget.BaseFormPanel;
import eg.net.gxt.client.widget.SimpleComboBox;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.Resources;
import eg.net.lanNansahom.client.widgets.LookupComboBox;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.SearchVictimsBean;

public abstract class SearchVictimsMask extends BaseFormPanel<SearchVictimsBean> {

	public SearchVictimsMask(String title, boolean martyrs) {
		super(new SearchVictimsBean(martyrs), title);

	}

	@Override
	protected void attachFormControls(FormPanel panel) {
		LayoutContainer main = new LayoutContainer();
		main.setLayout(new ColumnLayout());

		LayoutContainer one = new LayoutContainer();
		one.setStyleAttribute("paddingRight", "10px");
		FormLayout layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		one.setLayout(layout);

		LayoutContainer two = new LayoutContainer();
		two.setStyleAttribute("paddingRight", "10px");
		layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		two.setLayout(layout);

		LayoutContainer three = new LayoutContainer();
		three.setStyleAttribute("paddingLeft", "10px");
		layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		three.setLayout(layout);

		LayoutContainer four = new LayoutContainer();
		four.setStyleAttribute("paddingLeft", "10px");
		layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		four.setLayout(layout);

		main.add(one, new ColumnData(.25));
		main.add(two, new ColumnData(.25));
		main.add(three, new ColumnData(.25));
		main.add(four, new ColumnData(.25));

		panel.add(main, new FormData("100%"));
		panel.setBorders(true);

		Messages messages = GWT.create(Messages.class);
		final TextField<String> nameControl = new TextField<String>();
		nameControl.setName(SearchVictimsBean.BINDING_NAME);
		nameControl.setFieldLabel(messages.name());
		nameControl.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					getBean().setName(nameControl.getValue());
					Dispatcher.forwardEvent(getSearchEvent(), getBean());
				}
			}

		});
		one.add(nameControl);

		final NumberField ageControl = new NumberField();
		ageControl.setPropertyEditorType(Integer.class);
		ageControl.setName(SearchVictimsBean.BINDING_AGE);
		ageControl.setFieldLabel(messages.age());
		ageControl.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					getBean().setAge((Integer) ageControl.getValue());
					Dispatcher.forwardEvent(getSearchEvent(), getBean());
				}
			}

		});
		two.add(ageControl);

		final LookupComboBox education = new LookupComboBox(SearchVictimsBean.BINDING_EDUCATION, messages.education(),
				LookupType.EDUCATION);
		education.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					getBean().setEducation(education.getValue());
					Dispatcher.forwardEvent(getSearchEvent(), getBean());
				}
			}

		});

		three.add(education);

		final NumberField idControl = new NumberField();
		idControl.setPropertyEditorType(Integer.class);
		idControl.setName(SearchVictimsBean.BINDING_ID);
		idControl.setFieldLabel(messages.id());
		idControl.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					getBean().setId((Integer) idControl.getValue());
					Dispatcher.forwardEvent(getSearchEvent(), getBean());
				}
			}

		});
		four.add(idControl);

		final LookupComboBox area = new LookupComboBox(SearchVictimsBean.BINDING_AREA, messages.area(), LookupType.AREA);
		area.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					getBean().setArea(area.getValue());
					Dispatcher.forwardEvent(getSearchEvent(), getBean());
				}
			}

		});
		one.add(area);

		final DateField dateControl = new DateField();
		dateControl.setName(SearchVictimsBean.BINDING_DATE);
		dateControl.setFieldLabel(messages.date1());
		dateControl.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					getBean().setDate(dateControl.getValue());
					Dispatcher.forwardEvent(getSearchEvent(), getBean());
				}
			}

		});
		two.add(dateControl);

		final LookupComboBox job = new LookupComboBox(SearchVictimsBean.BINDING_JOB, messages.job(), LookupType.JOB);
		job.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					getBean().setJob(job.getValue());
					Dispatcher.forwardEvent(getSearchEvent(), getBean());
				}
			}

		});
		three.add(job);

		final SimpleComboBox published = new SimpleComboBox(SearchVictimsBean.BINDING_PUBLISHED, "Publish");
		published.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					getBean().setPublished(published.getValue());
					Dispatcher.forwardEvent(getSearchEvent(), getBean());
				}
			}

		});

		published.add("All");
		published.add("Only Published");
		published.add("Only Unpublished");
		published.setAsDefault("All");
		four.add(published);

		final LookupComboBox status = new LookupComboBox(SearchVictimsBean.BINDING_RECORD_STATUS,
				messages.recordStatus(), LookupType.RECORD_STATUS);
		status.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					getBean().setRecordStatus(status.getValue());
					Dispatcher.forwardEvent(getSearchEvent(), getBean());
				}
			}

		});
		one.add(status);

	}

	@Override
	protected void attachFormButtons(FormPanel panel) {
		panel.setButtonAlign(HorizontalAlignment.CENTER);
		Messages messages = GWT.create(Messages.class);
		Button button = new Button(messages.search());
		panel.addButton(button);
		button.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Dispatcher.forwardEvent(getSearchEvent(), getBean());

			}
		});

		final Resources resources = GWT.create(Resources.class);
		button = new Button(messages.export());
		button.setIcon(AbstractImagePrototype.create(resources.excel()));
		panel.addButton(button);
		button.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				UrlBuilder builder = Window.Location.createUrlBuilder();
				builder.setHash("");
				builder.setPath(Window.Location.getPath() + "export");
				if (getBean().getName() != null) {
					builder.setParameter("name", getBean().getName());
				}
				if (getBean().getArea() != null) {
					builder.setParameter("areaId", String.valueOf(getBean().getArea().getId()));
				}
				if (getBean().getAge() != null) {
					builder.setParameter("age", String.valueOf(getBean().getAge()));
				}
				builder.setParameter("isMartyr", String.valueOf(getBean().isMartyr()));

				if (getBean().getEducation() != null) {
					builder.setParameter("educationId", String.valueOf(getBean().getEducation().getId()));
				}

				if (getBean().getJob() != null) {
					builder.setParameter("jobId", String.valueOf(getBean().getJob().getId()));
				}

				if (getBean().getId() != null) {
					builder.setParameter("id", String.valueOf(getBean().getId()));
				}

				if (getBean().getPublished() != null) {
					builder.setParameter("published", getBean().getPublished().getName());
				}

				if (getBean().getDate() != null) {
					builder.setParameter("date", getBean().getDateInStringFormate(SearchVictimsBean.BINDING_DATE));
				}
				Window.open(builder.buildString(), "", "");
			}
		});

	}

	protected abstract EventType getSearchEvent();

}