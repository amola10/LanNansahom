package eg.net.lanNansahom.client.widget.common;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Image;

import eg.net.lanNansahom.client.Resources;

public class UnderConstructionPage extends InnerPage {

	public UnderConstructionPage() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.extjs.gxt.ui.client.widget.ContentPanel#onRender(com.google.gwt.user
	 * .client.Element, int)
	 */
	@Override
	protected void onRender(Element parent, int pos) {
		super.onRender(parent, pos);

		BorderLayoutData layoutData = new BorderLayoutData(LayoutRegion.CENTER);
		layoutData.setSize(0.5f);
		layoutData.setFloatable(false);
		layoutData.setMargins(new Margins(30, 5, 0, 0));

		Resources resource = GWT.create(Resources.class);

		LayoutContainer panel = new LayoutContainer();
		panel.setLayout(new VBoxLayout(VBoxLayoutAlign.CENTER));
		Image image = new Image(resource.underConstruction());
		panel.add(image, new VBoxLayoutData(new Margins(0)));

		container.add(panel, layoutData);
	}
}
