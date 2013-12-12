package eg.net.lanNansahom.client.widget.lookup;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;

import eg.net.gxt.client.widget.BaseFormPanel;
import eg.net.gxt.client.widget.SimpleComboBox;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.SearchLookupsBean;

public class SearchLookupMask extends BaseFormPanel<SearchLookupsBean> {

	public SearchLookupMask() {
		super(new SearchLookupsBean(), constructTitle());
	}

	/**
	 * Constuct title.
	 * 
	 * @return the string
	 */
	private static String constructTitle() {
		Messages messages = GWT.create(Messages.class);
		return messages.lookup() + "-> " + messages.search();
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
		SimpleComboBox typeControl = new SimpleComboBox(SearchLookupsBean.BINDING_TYPE, messages.type());
		for (LookupType type : LookupType.values()) {
			typeControl.add(type.name());
			if (typeControl.getValue() == null) {
				typeControl.setAsDefault(type.name());

			}

		}
		typeControl.setEditable(false);
		one.add(typeControl);

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
				Dispatcher.forwardEvent(AppEvents.LIST_LOOKUPS, LookupType.valueOf(getBean().getType().getName()));

			}
		});

	}

}
