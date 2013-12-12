package eg.net.lanNansahom.client.widget.application;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;

import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.widget.common.InnerPage;

public class AboutUsPanel extends InnerPage {

	public AboutUsPanel() {
		super();
		addAttachHandler(new AttachEvent.Handler() {

			public void onAttachOrDetach(AttachEvent event) {
				if (isAttached()) {
					Messages messages = GWT.create(Messages.class);
					Window.setTitle(messages.lannansahom() + " - " + messages.aboutusTitle());
				}

			}
		});
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
		layoutData.setMargins(new Margins(0, 5, 0, 0));

		Messages messages = GWT.create(Messages.class);
		ContentPanel panel = new ContentPanel();
		panel.setBodyStyleName("aboutUs");
		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);
		panel.add(new Text(messages.aboutusP1()));
		panel.add(new Text(messages.aboutusP2()));
		panel.add(new Text(messages.aboutusP3()));
		panel.add(new Text(messages.aboutusP4()));
		panel.add(new Text());
		panel.add(new Text(messages.aboutusP5()));
		panel.add(new Text());
		panel.add(new Text(messages.aboutusP6()));
		panel.add(new Text(messages.aboutusP7()));
		panel.add(new Text());
		panel.add(new Text(messages.aboutusP9()));
		panel.add(new Text(messages.aboutusP10()));
		container.add(panel, layoutData);

	}
}
