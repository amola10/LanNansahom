package eg.net.lanNansahom.client.widget.common;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;

import eg.net.gxt.client.widget.MainViewPort;
import eg.net.lanNansahom.client.widget.application.Header;
import eg.net.lanNansahom.client.widget.application.SubHeader;

public class InnerPage extends LayoutContainer {

	protected ContentPanel container;

	public InnerPage() {
		super();
		setLayout(new FitLayout());
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
		setScrollMode(Scroll.NONE);
		container = new ContentPanel();
		container.setHeaderVisible(false);
		container.setBorders(false);
		container.setBodyBorder(false);
		container.setLayout(new FitLayout());
		container.setScrollMode(Scroll.NONE);
		container.setLayout(new BorderLayout());

		BorderLayoutData layoutData = new BorderLayoutData(LayoutRegion.NORTH);
		layoutData.setSize(100);
		layoutData.setFloatable(false);
		layoutData.setMargins(new Margins(0, 0, 10, 0));
		container.add(new SubHeader(), layoutData);
		add(container);
		showHeaderIfMissing();
	}

	private void showHeaderIfMissing() {
		MainViewPort viewPort = Registry.get("MAIN_VIEW");
		if (viewPort != null) {
			Header header = (Header) viewPort.getNorthWidget().getWidget();
			if (!header.isHeaderShown()) {
				header.showHeader();
			}
		}
	}

}
