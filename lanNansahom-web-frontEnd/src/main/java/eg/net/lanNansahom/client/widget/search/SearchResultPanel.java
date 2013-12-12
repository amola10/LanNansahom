package eg.net.lanNansahom.client.widget.search;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.Image;

import eg.net.gxt.client.widget.PagingDataGrid;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.Resources;
import eg.net.lanNansahom.client.VictimNavigation;
import eg.net.lanNansahom.client.view.ApplicationView;
import eg.net.lanNansahom.shared.URLUtility;
import eg.net.lanNansahom.shared.beans.VictimInfoBean;

public class SearchResultPanel extends PagingDataGrid<VictimInfoBean> implements GridCellRenderer<ModelData> {

	private final VictimNavigation navigation = new VictimNavigation();

	public SearchResultPanel() {
		this(new ArrayList<VictimInfoBean>());
	}

	public SearchResultPanel(List<VictimInfoBean> victimInfoBeans) {
		super(null, victimInfoBeans, 5);
		setBorders(false);
		Messages messages = GWT.create(Messages.class);
		toolBar.getMessages().setAfterPageText(messages.pagingToolBar_afterPageText("{0}"));
		toolBar.getMessages().setBeforePageText(messages.pagingToolBar_beforePageText());
		toolBar.getMessages().setDisplayMsg(messages.pagingToolBar_displayMsg("{0}", "{1}", "{2}"));
		toolBar.getMessages().setEmptyMsg(messages.pagingToolBar_emptyMsg());
		toolBar.getMessages().setFirstText(messages.pagingToolBar_firstText());
		toolBar.getMessages().setLastText(messages.pagingToolBar_lastText());
		toolBar.getMessages().setNextText(messages.pagingToolBar_nextText());
		toolBar.getMessages().setPrevText(messages.pagingToolBar_prevText());
		toolBar.getMessages().setRefreshText(messages.pagingToolBar_refreshText());
		addAttachHandler(new AttachEvent.Handler() {

			public void onAttachOrDetach(AttachEvent event) {
				if (event.isAttached()) {
					Registry.register("VictimNavigation", navigation);
				} else {
					Registry.unregister("VictimNavigation");
				}
			}
		});

	}

	@Override
	protected List<ColumnConfig> getColumnConfigurationList() {
		List<ColumnConfig> result = new ArrayList<ColumnConfig>();
		Messages messages = GWT.create(Messages.class);
		result.add(createColumnConfig(VictimInfoBean.BINDING_IMAGE, "", 110, this, HorizontalAlignment.CENTER));
		result.add(createColumnConfig(VictimInfoBean.BINDING_NAME, messages.name(), 300, HorizontalAlignment.RIGHT));
		result.add(createColumnConfig(VictimInfoBean.BINDING_DEATH_AREA, messages.placeOfDeath(), 200,
				HorizontalAlignment.RIGHT));
		result.add(createColumnConfig(VictimInfoBean.BINDING_DEATH_DATE, messages.dateOfDeath(), 215, this,
				HorizontalAlignment.RIGHT));
		return result;
	}

	public Object render(ModelData model, String property, ColumnData config, int rowIndex, int colIndex,
			ListStore<ModelData> store, Grid<ModelData> grid) {
		Object result = null;
		final VictimInfoBean victim = (VictimInfoBean) store.getAt(rowIndex);
		if (VictimInfoBean.BINDING_IMAGE.equals(property)) {
			Image image = new Image();
			if (victim.getProfileThumbnail() != null) {
				image.setUrl(URLUtility.getImagesBaseURL() + victim.getProfileThumbnail().getUrl());

			} else {
				Resources resource = GWT.create(Resources.class);
				image.setResource(resource.anonymousThumbnail());
			}
			result = image;
		} else if (VictimInfoBean.BINDING_DEATH_DATE.equals(property)) {
			if (victim.getDeathDate() != null) {
				result = ApplicationView.formateDate(victim.getDeathDate());
			} else {
				result = "";
			}
		}
		return result;
	}

	@Override
	protected void attachButtons(ContentPanel panel) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.extjs.gxt.ui.client.widget.Container#onAfterLayout()
	 */
	@Override
	protected void onAfterLayout() {
		super.onAfterLayout();
		ApplicationView.customScroll("x-grid3-scroller");
	}

	@Override
	protected void attachGridListeners(final Grid<VictimInfoBean> grid) {
		grid.setBorders(false);
		grid.setColumnLines(false);
		grid.addListener(Events.RowClick, new Listener<BaseEvent>() {

			public void handleEvent(BaseEvent be) {
				@SuppressWarnings("unchecked")
				GridEvent<ModelData> event = (GridEvent<ModelData>) be;
				final VictimInfoBean victim = grid.getStore().getAt(event.getRowIndex());
				Dispatcher.forwardEvent(AppEvents.GO_TO_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT, new Integer(victim.getId()));

			}
		});

	}

	public void showResult(List<VictimInfoBean> pVictimInfoBeans) {
		this.refreshStore(pVictimInfoBeans);
		for (final VictimInfoBean victim : pVictimInfoBeans) {
			navigation.add(victim.getId());
		}
		Registry.register("VictimNavigation", navigation);
	}

}
