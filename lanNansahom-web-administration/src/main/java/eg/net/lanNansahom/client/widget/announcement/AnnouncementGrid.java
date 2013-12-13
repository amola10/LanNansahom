package eg.net.lanNansahom.client.widget.announcement;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
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
import com.google.gwt.i18n.client.DateTimeFormat;

import eg.net.gxt.client.widget.PagingDataGrid;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.shared.beans.AnnouncementBean;

/**
 * The Class AnnouncementGrid.
 */
public class AnnouncementGrid extends PagingDataGrid<AnnouncementBean> implements GridCellRenderer<ModelData> {

	/**
	 * Instantiates a new announcement grid.
	 */
	public AnnouncementGrid() {
		super(constructTitle(), 15);
	}

	/**
	 * Constuct title.
	 * 
	 * @return the string
	 */
	private static String constructTitle() {
		Messages messages = GWT.create(Messages.class);
		return messages.announcements() + "-> " + messages.listAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.gxt.client.widget.DataGrid#getColumnConfigurationList()
	 */
	@Override
	protected List<ColumnConfig> getColumnConfigurationList() {
		Messages messages = GWT.create(Messages.class);
		List<ColumnConfig> result = new ArrayList<ColumnConfig>();
		result.add(createColumnConfig(AnnouncementBean.BINDING_ID, messages.id(), 80));
		result.add(createColumnConfig(AnnouncementBean.BINDING_TITLE, messages.title(), 500));
		result.add(createColumnConfig(AnnouncementBean.BINDING_DATE, messages.date(), 250, this));
		result.add(createColumnConfig(AnnouncementBean.BINDING_PUBLISHED, messages.publish(), 75, this));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.gxt.client.widget.DataGrid#attachButtons(com.extjs.gxt.ui.client
	 * .widget.ContentPanel)
	 */
	@Override
	protected void attachButtons(ContentPanel panel) {
		Messages messages = GWT.create(Messages.class);
		Button button = new Button(messages.add());
		button.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent buttonEvent) {
				Dispatcher.forwardEvent(AppEvents.GO_TO_ADD_ANNOUNCEMENT);
			}
		});
		panel.addButton(button);

		button = new Button("Cancel");
		button.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent buttonEvent) {
				Dispatcher.forwardEvent(AppEvents.HOME_PAGE);
			}
		});
		panel.addButton(button);

		button = new Button(messages.generate());
		button.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Dispatcher.forwardEvent(AppEvents.GENERATE_ANNOUNCEMENT);

			}
		});
		panel.addButton(button);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.gxt.client.widget.DataGrid#customize(com.extjs.gxt.ui.client.widget
	 * .grid.Grid)
	 */
	@Override
	protected void attachGridListeners(final Grid<AnnouncementBean> grid) {
		grid.addListener(Events.RowClick, new Listener<BaseEvent>() {

			public void handleEvent(BaseEvent be) {
				@SuppressWarnings("unchecked")
				GridEvent<ModelData> event = (GridEvent<ModelData>) be;
				final AnnouncementBean announcementModel = grid.getStore().getAt(event.getRowIndex());
				Dispatcher.forwardEvent(AppEvents.GO_TO_UPDATE_ANNOUNCEMENT, announcementModel);

			}
		});
	}

	/**
	 * Populate data.
	 * 
	 * @param data
	 *            the data
	 */
	public void populateData(List<AnnouncementBean> data) {
		this.refreshStore(data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.extjs.gxt.ui.client.widget.grid.GridCellRenderer#render(com.extjs
	 * .gxt.ui.client.data.ModelData, java.lang.String,
	 * com.extjs.gxt.ui.client.widget.grid.ColumnData, int, int,
	 * com.extjs.gxt.ui.client.store.ListStore,
	 * com.extjs.gxt.ui.client.widget.grid.Grid)
	 */
	public Object render(ModelData model, String property, ColumnData config, int rowIndex, int colIndex,
			ListStore<ModelData> store, Grid<ModelData> grid) {
		Object result = null;
		final AnnouncementBean announcementModel = (AnnouncementBean) store.getAt(rowIndex);
		if (AnnouncementBean.BINDING_DATE.equals(property)) {
			result = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_TIME_SHORT).format(
					announcementModel.getDate());
		} else if (AnnouncementBean.BINDING_PUBLISHED.equals(property)) {
			final CheckBox checkBox = new CheckBox();
			checkBox.setValue(announcementModel.getPublished());
			checkBox.addListener(Events.OnClick, new Listener<BaseEvent>() {
				public void handleEvent(BaseEvent be) {
					announcementModel.setPublished(checkBox.getValue());
					Dispatcher.forwardEvent(AppEvents.UPDATE_ANNOUNCEMENT, announcementModel);

				}
			});
			result = checkBox;
		}
		return result;
	}
}
