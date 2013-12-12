package eg.net.lanNansahom.client.widget.search;

import java.util.List;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;

import eg.net.lanNansahom.client.widget.common.InnerPage;
import eg.net.lanNansahom.shared.beans.VictimInfoBean;

public class SearchWidget extends InnerPage {

	private final List<VictimInfoBean> victimInfoBeans;
	private SearchResultPanel searchResultPanel;

	public SearchWidget(List<VictimInfoBean> pVictimInfoBeans) {
		super();
		setBorders(false);
		setLayout(new FitLayout());
		setScrollMode(Scroll.AUTOY);
		victimInfoBeans = pVictimInfoBeans;

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
		searchResultPanel = new SearchResultPanel(victimInfoBeans);
		container.add(searchResultPanel, layoutData);

	}

	public void showResult(List<VictimInfoBean> pVictimInfoBeans) {
		searchResultPanel.showResult(pVictimInfoBeans);

	}

}
