package eg.net.lanNansahom.client.widget.application;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.Element;

import eg.net.lanNansahom.client.widget.search.SearchMask;

public class SubHeader extends LayoutContainer {

	public SubHeader() {
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
		ContentPanel panel = new ContentPanel();
		panel.setLayout(new RowLayout(Orientation.HORIZONTAL));

		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);

		panel.add(new LogoPanel("logoHeader"), new RowData(0.5, 1, new Margins(0)));
		panel.add(new SearchMask(), new RowData(0.5, 1, new Margins(0)));

		add(panel);

	}
}
