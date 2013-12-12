package eg.net.lanNansahom.client.widget.lookup;

import java.util.List;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowData;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.Element;

import eg.net.lanNansahom.shared.beans.LookupBean;

public class SearchLookupWidget extends LayoutContainer {

	private final SearchLookupMask searchLookupMask;
	private final SearchLookupGrid searchLookupGrid;

	public SearchLookupWidget() {
		super();
		this.searchLookupMask = new SearchLookupMask();
		this.searchLookupGrid = new SearchLookupGrid();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.extjs.gxt.ui.client.widget.LayoutContainer#onRender(com.google.gwt
	 * .user.client.Element, int)
	 */
	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);
		setLayout(new FitLayout());
		setScrollMode(Scroll.AUTOY);
		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.setLayout(new RowLayout(Orientation.VERTICAL));
		panel.setFrame(true);
		panel.setCollapsible(false);

		panel.add(this.searchLookupMask, new RowData(1, 0.3, new Margins(4)));
		panel.add(this.searchLookupGrid, new RowData(1, 0.7, new Margins(0, 4, 0, 4)));

		add(panel, new FlowData(10));
	}

	public void populateData(final List<LookupBean> data) {
		this.searchLookupGrid.populateData(data);
	}

	public String getActiveType() {
		return searchLookupMask.getBean().getType() != null ? searchLookupMask.getBean().getType().getName() : null;

	}
}
