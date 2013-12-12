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

public class InjuredHomePage extends InnerPage {

	public InjuredHomePage() {
		super();
		addAttachHandler(new AttachEvent.Handler() {

			public void onAttachOrDetach(AttachEvent event) {
				if (isAttached()) {
					Messages messages = GWT.create(Messages.class);
					Window.setTitle(messages.lannansahom() + " - " + messages.injuredTitle());
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
		panel.setBodyStyleName("contactUs");
		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);
		panel.add(new Text(messages.injuriedP1()));
		panel.add(new Text());
		panel.add(new Text(messages.injuriedP2()));
		Text text = new Text(messages.contactusEmail());
		text.setStyleName("contactUsEmail");
		panel.add(text);

		container.add(panel, layoutData);
	}
}
