package eg.net.lanNansahom.client.widget.victims;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

import eg.net.gxt.client.widget.PagingDataGrid;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.Resources;
import eg.net.lanNansahom.shared.beans.VictimBean;

public abstract class SearchVictimsGrid<T extends VictimBean> extends PagingDataGrid<T> implements
		GridCellRenderer<ModelData> {

	private final boolean isMartyrs;

	public SearchVictimsGrid(boolean martyrs) {
		super(null, 15);
		isMartyrs = martyrs;
	}

	@Override
	protected List<ColumnConfig> getColumnConfigurationList() {
		Messages messages = GWT.create(Messages.class);
		List<ColumnConfig> result = new ArrayList<ColumnConfig>();
		result.add(createColumnConfig(VictimBean.BINDING_ID, messages.id(), 80));
		result.add(createColumnConfig(VictimBean.BINDING_NAME, messages.name(), 300));
		result.add(createColumnConfig(VictimBean.BINDING_AGE, messages.age(), 100));
		result.add(createColumnConfig(VictimBean.BINDING_EDUCATION, messages.education(), 150));
		result.add(createColumnConfig(VictimBean.BINDING_JOB, messages.job(), 150));
		result.add(createColumnConfig(VictimBean.BINDING_PUBLISHED, messages.publish(), 75, this));
		result.add(createColumnConfig("Remove", messages.remove(), 50, this));

		return result;
	}

	@SuppressWarnings("unchecked")
	public Object render(ModelData model, String property, ColumnData config, int rowIndex, int colIndex,
			ListStore<ModelData> store, Grid<ModelData> grid) {
		Object result = null;
		final T victimModel = (T) store.getAt(rowIndex);
		if (VictimBean.BINDING_PUBLISHED.equals(property)) {
			final CheckBox checkBox = new CheckBox();
			checkBox.setValue(victimModel.getPublished());
			checkBox.addListener(Events.OnClick, new Listener<BaseEvent>() {
				public void handleEvent(BaseEvent be) {
					victimModel.setPublished(checkBox.getValue());
					Dispatcher.forwardEvent(getUpdateEvent(), victimModel);

				}
			});
			result = checkBox;
		} else if ("Remove".equals(property)) {
			Resources resources = GWT.create(Resources.class);
			Button button = new Button();
			button.setIcon(AbstractImagePrototype.create(resources.remove()));
			button.addSelectionListener(new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					Dispatcher.forwardEvent(getDeleteEvent(), victimModel);
				}
			});
			result = button;

		}
		return result;
	}

	@Override
	protected void attachButtons(ContentPanel panel) {
		Messages messages = GWT.create(Messages.class);
		Button button = new Button(messages.add());
		button.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent buttonEvent) {
				Dispatcher.forwardEvent(getGoToAddEvent());
			}
		});
		panel.addButton(button);

		button = new Button("Cancel");
		button.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent buttonEvent) {
				Dispatcher.forwardEvent(AppEvents.HOME_PAGE, "back");
			}
		});
		panel.addButton(button);
	}

	@Override
	protected void attachGridListeners(final Grid<T> grid) {
		grid.addListener(Events.RowClick, new Listener<BaseEvent>() {

			public void handleEvent(BaseEvent be) {
				@SuppressWarnings("unchecked")
				GridEvent<ModelData> event = (GridEvent<ModelData>) be;
				final T victimModel = grid.getStore().getAt(event.getRowIndex());
				Dispatcher.forwardEvent(getGoToUpdateAddEvent(), victimModel);

			}
		});
	}

	public void populateData(List<T> data) {
		refreshStore(data);
	}

	protected abstract EventType getGoToAddEvent();

	protected abstract EventType getGoToUpdateAddEvent();

	protected abstract EventType getUpdateEvent();

	protected abstract EventType getDeleteEvent();

}
