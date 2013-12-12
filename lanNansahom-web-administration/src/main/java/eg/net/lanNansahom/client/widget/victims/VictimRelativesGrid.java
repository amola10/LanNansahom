package eg.net.lanNansahom.client.widget.victims;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.RowEditor;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

import eg.net.gxt.client.widget.PagingDataGrid;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.Resources;
import eg.net.lanNansahom.client.widgets.LookupComboBox;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.EmailBean;
import eg.net.lanNansahom.shared.beans.PersonBean;
import eg.net.lanNansahom.shared.beans.RelativeBean;

public class VictimRelativesGrid extends PagingDataGrid<RelativeBean> implements GridCellRenderer<ModelData> {

	private final RowEditor<RelativeBean> editor;

	public VictimRelativesGrid(List<RelativeBean> relatives) {
		super(null, relatives, 13);
		editor = new RowEditor<RelativeBean>();

	}

	@Override
	protected List<ColumnConfig> getColumnConfigurationList() {
		Messages messages = GWT.create(Messages.class);
		List<ColumnConfig> result = new ArrayList<ColumnConfig>();
		result.add(createColumnConfig(RelativeBean.BINDING_NAME, messages.name(), 250, new CellEditor(
				new TextField<String>())));
		result.add(createColumnConfig(RelativeBean.BINDING_RELEATIONSHIP, messages.releationship(), 150,
				new CellEditor(new LookupComboBox(RelativeBean.BINDING_RELEATIONSHIP, null, LookupType.RELEATIONSHIP))));
		result.add(createColumnConfig(RelativeBean.BINDING_EMAIL, messages.email(), 150, new CellEditor(
				new TextField<String>())));
		result.add(createColumnConfig(RelativeBean.BINDING_HOME_NUMBER, messages.homeNumber(), 150, new CellEditor(
				new TextField<String>())));
		result.add(createColumnConfig(RelativeBean.BINDING_MOBILE_NUMBER, messages.mobileNumber(), 150, new CellEditor(
				new TextField<String>())));
		result.add(createColumnConfig(RelativeBean.BINDING_PUBLISHED, messages.publish(), 100, new CellEditor(
				new CheckBox()), this));
		result.add(createColumnConfig(RelativeBean.BINDING_CONTATCT_PUBLISHED, messages.contactPublished(), 100,
				new CellEditor(new CheckBox()), this));
		result.add(createColumnConfig("", messages.remove(), 50, this));
		result.add(createColumnConfig("", messages.sendEmail(), 50, this));
		return result;
	}

	@Override
	protected void attachButtons(ContentPanel panel) {
		Resources resources = GWT.create(Resources.class);
		ToolBar toolBar = new ToolBar();
		Button addButton = new Button();
		addButton.setIcon(AbstractImagePrototype.create(resources.add()));
		addButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				List<RelativeBean> data = new ArrayList<RelativeBean>();
				RelativeBean bean = new RelativeBean();
				data.add(bean);
				addToStore(bean);

				editor.startEditing(getModels().size() - 1, true);

			}

		});
		toolBar.add(addButton);
		this.panel.setTopComponent(toolBar);
	}

	@Override
	protected void attachGridListeners(Grid<RelativeBean> grid) {
		setHeight(565);
		grid.addPlugin(editor);
	}

	public Object render(ModelData model, String property, ColumnData config, int rowIndex, int colIndex,
			ListStore<ModelData> store, Grid<ModelData> grid) {
		Object result = null;
		final RelativeBean relativeBean = (RelativeBean) store.getAt(rowIndex);
		if (property.contains(PersonBean.BINDING_PUBLISHED)) {
			result = new CheckBox();
			((CheckBox) result).setValue(relativeBean.getPublished());
		} else if (property.contains(PersonBean.BINDING_CONTATCT_PUBLISHED)) {
			result = new CheckBox();
			((CheckBox) result).setValue(relativeBean.getContatctPublished());
		} else if (colIndex == 7) {
			Resources resources = GWT.create(Resources.class);
			Button button = new Button();
			button.setIcon(AbstractImagePrototype.create(resources.remove()));
			button.addSelectionListener(new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					removeFromStore(relativeBean);

				}
			});
			result = button;
		} else if (colIndex == 8) {
			Resources resources = GWT.create(Resources.class);
			Button button = new Button();
			button.setIcon(AbstractImagePrototype.create(resources.email()));
			if (relativeBean.getEmail() != null && !"".equals(relativeBean.getEmail())) {
				button.addSelectionListener(new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
						showEmailDialog(relativeBean);

					}

				});
			} else {
				button.setEnabled(false);
			}
			result = button;
		}

		return result;
	}

	private void showEmailDialog(RelativeBean pRelativeBean) {
		EmailBean emailBean = new EmailBean();
		emailBean.setFrom("contactus@lan-nansahom.org");
		emailBean.setTo(pRelativeBean.getEmail());

		final SendEmailMask sendEmailMask = new SendEmailMask(emailBean);
		Dialog dialog = new Dialog();
		dialog.setButtons(Dialog.OKCANCEL);
		dialog.setSize(550, 400);
		dialog.setHideOnButtonClick(true);
		dialog.setLayout(new BorderLayout());
		dialog.setModal(true);
		Messages messages = GWT.create(Messages.class);

		dialog.okText = messages.send();
		// center
		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.add(sendEmailMask);
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
		dialog.add(panel, data);
		dialog.addListener(Events.Hide, new Listener<BaseEvent>() {

			public void handleEvent(BaseEvent be) {
				EmailBean emailBean = sendEmailMask.getBean();
				if (be.isCancelled() == false && emailBean.getSubject() != null && emailBean.getMessage() != null) {
					Dispatcher.forwardEvent(AppEvents.SEND_EMAIL, emailBean);
				} else {
					Window.alert("Email will not be send. Please enter subject & message");
				}
			}
		});
		dialog.show();

	}

	public List<RelativeBean> getRelatives() {
		return getModels();
	}

}
