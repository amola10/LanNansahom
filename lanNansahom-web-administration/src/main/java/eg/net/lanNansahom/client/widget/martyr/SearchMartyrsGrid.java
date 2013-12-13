package eg.net.lanNansahom.client.widget.martyr;

import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;

import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.widget.victims.SearchVictimsGrid;
import eg.net.lanNansahom.shared.beans.MartyrBean;

public class SearchMartyrsGrid extends SearchVictimsGrid<MartyrBean> {

	public SearchMartyrsGrid() {
		super(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.lanNansahom.client.widget.victims.SearchVictimsGrid#
	 * getColumnConfigurationList()
	 */
	@Override
	protected List<ColumnConfig> getColumnConfigurationList() {
		Messages messages = GWT.create(Messages.class);
		List<ColumnConfig> result = super.getColumnConfigurationList();
		result.add(result.size() - 2, createColumnConfig(MartyrBean.BINDING_DEATH_AREA, messages.deathArea(), 100));
		result.add(result.size() - 2,
				createColumnConfig(MartyrBean.BINDING_DEATH_DATE, messages.deathDate(), 100, this));
		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.client.widget.victims.SearchVictimsGrid#render(com
	 * .extjs.gxt.ui.client.data.ModelData, java.lang.String,
	 * com.extjs.gxt.ui.client.widget.grid.ColumnData, int, int,
	 * com.extjs.gxt.ui.client.store.ListStore,
	 * com.extjs.gxt.ui.client.widget.grid.Grid)
	 */
	@Override
	public Object render(ModelData model, String property, ColumnData config, int rowIndex, int colIndex,
			ListStore<ModelData> store, Grid<ModelData> grid) {
		Object result = super.render(model, property, config, rowIndex, colIndex, store, grid);
		if (MartyrBean.BINDING_DEATH_DATE.equals(property) && model.get(MartyrBean.BINDING_DEATH_DATE) != null) {
			final MartyrBean martyrBean = (MartyrBean) store.getAt(rowIndex);
			result = DateTimeFormat.getFormat("dd-MMM-yyyy").format(martyrBean.getDeathDate());

		}
		return result;
	}

	@Override
	protected EventType getGoToAddEvent() {
		return AppEvents.GO_TO_ADD_MARTYR;
	}

	@Override
	protected EventType getGoToUpdateAddEvent() {
		return AppEvents.GO_TO_UPDATE_MARTYR;
	}

	@Override
	protected EventType getUpdateEvent() {
		return AppEvents.UPDATE_MARTYR;
	}

	@Override
	protected EventType getDeleteEvent() {
		return AppEvents.DELETE_MARTYR;
	}

	@Override
	protected EventType getGenerateEvent() {
		return AppEvents.GENERATE_MARTYRS;
	}

}
