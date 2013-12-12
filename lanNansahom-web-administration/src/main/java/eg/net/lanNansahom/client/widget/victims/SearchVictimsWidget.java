package eg.net.lanNansahom.client.widget.victims;

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

public class SearchVictimsWidget<M extends SearchVictimsMask, G extends SearchVictimsGrid<?>> extends LayoutContainer {

	private final M searchVictimsMask;
	private final G searchVictimsGrid;

	public SearchVictimsWidget(M searchVictimsMask, G searchVictimsGrid) {
		super();
		this.searchVictimsMask = searchVictimsMask;
		this.searchVictimsGrid = searchVictimsGrid;
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

		panel.add(this.searchVictimsMask, new RowData(1, 0.35, new Margins(4)));
		panel.add(this.searchVictimsGrid, new RowData(1, 0.65, new Margins(0, 4, 0, 4)));

		add(panel, new FlowData(10));
	}

	public void populateData(final List data) {
		this.searchVictimsGrid.populateData(data);
	}
}
