package eg.net.lanNansahom.client.widget.lookup;

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
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.core.client.GWT;

import eg.net.gxt.client.widget.PagingDataGrid;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.shared.beans.LookupBean;

public class SearchLookupGrid extends PagingDataGrid<LookupBean> {

	/**
	 * Instantiates a new announcement grid.
	 */
	public SearchLookupGrid() {
		super(constructTitle(), 15);
	}

	/**
	 * Constuct title.
	 * 
	 * @return the string
	 */
	private static String constructTitle() {
		Messages messages = GWT.create(Messages.class);
		return messages.lookup() + "-> " + messages.listAll();
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
		result.add(createColumnConfig(LookupBean.BINDING_ID, messages.id(), 80));
		result.add(createColumnConfig(LookupBean.BINDING_NAME, messages.name(), 500));
		result.add(createColumnConfig(LookupBean.BINDING_DESCRIPTION, messages.description(), 325));
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
				Dispatcher.forwardEvent(AppEvents.GO_TO_ADD_LOOKUP);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.gxt.client.widget.DataGrid#customize(com.extjs.gxt.ui.client.widget
	 * .grid.Grid)
	 */
	@Override
	protected void attachGridListeners(final Grid<LookupBean> grid) {
		grid.addListener(Events.RowClick, new Listener<BaseEvent>() {

			public void handleEvent(BaseEvent be) {
				@SuppressWarnings("unchecked")
				GridEvent<ModelData> event = (GridEvent<ModelData>) be;
				final LookupBean lookupBean = grid.getStore().getAt(event.getRowIndex());
				Dispatcher.forwardEvent(AppEvents.GO_TO_UPDATE_LOOKUP, lookupBean);

			}
		});
	}

	/**
	 * Populate data.
	 * 
	 * @param data
	 *            the data
	 */
	public void populateData(List<LookupBean> data) {
		this.refreshStore(data);
	}

}
