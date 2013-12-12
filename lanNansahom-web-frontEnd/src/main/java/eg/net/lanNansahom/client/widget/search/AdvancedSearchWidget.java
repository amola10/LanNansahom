package eg.net.lanNansahom.client.widget.search;

import java.util.List;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.Element;

import eg.net.lanNansahom.client.widget.common.InnerPage;
import eg.net.lanNansahom.shared.beans.VictimInfoBean;

public class AdvancedSearchWidget extends InnerPage {

	private final SearchResultPanel searchResultPanel;

	public AdvancedSearchWidget() {
		super();
		searchResultPanel = new SearchResultPanel();
		setBorders(false);

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

		BorderLayoutData layoutData = new BorderLayoutData(LayoutRegion.CENTER);
		layoutData.setSize(0.5f);
		layoutData.setFloatable(false);
		layoutData.setMargins(new Margins(0, 5, 0, 0));

		ContentPanel subContainer = new ContentPanel();
		subContainer.setHeaderVisible(false);
		subContainer.setBorders(false);
		subContainer.setBodyBorder(false);
		subContainer.setLayout(new RowLayout(Orientation.VERTICAL));

		subContainer.add(new AdvancedSearchVictimsMask(), new RowData(1, 0.36));
		subContainer.add(searchResultPanel, new RowData(1, 0.65, new Margins(0, 0, 10, 0)));

		container.add(subContainer, layoutData);

	}

	public void showResult(List<VictimInfoBean> pVictimInfoBeans) {
		searchResultPanel.showResult(pVictimInfoBeans);
	}

}
