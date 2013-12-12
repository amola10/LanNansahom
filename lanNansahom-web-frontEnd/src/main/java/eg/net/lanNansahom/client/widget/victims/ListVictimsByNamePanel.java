package eg.net.lanNansahom.client.widget.victims;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;

import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.VictimNavigation;
import eg.net.lanNansahom.shared.beans.VictimInfoBean;

public class ListVictimsByNamePanel extends LayoutContainer {

	private List<VictimInfoBean> victims = new ArrayList<VictimInfoBean>();
	private final VictimNavigation navigation = new VictimNavigation();

	public ListVictimsByNamePanel(List<VictimInfoBean> pVictims) {
		super();
		victims = pVictims;
		setLayout(new FitLayout());
		setBorders(false);
		for (final VictimInfoBean victim : victims) {
			navigation.add(victim.getId());
		}
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
		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);
		panel.setScrollMode(Scroll.AUTO);
		panel.setBodyStyleName("scrollPane");

		for (final VictimInfoBean victim : victims) {
			ContentPanel linkPanel = new ContentPanel();
			linkPanel.setHeaderVisible(false);
			linkPanel.setBorders(false);
			linkPanel.setBodyBorder(false);
			linkPanel.setBodyStyleName("victimNameLink");
			SafeHtmlBuilder builder = new SafeHtmlBuilder();
			builder.appendHtmlConstant(victim.getName());
			Anchor anchor = new Anchor(builder.toSafeHtml());
			anchor.setHref(Window.Location.getHref().replaceFirst("#" + History.getToken(), "") + "#!martyr;"
					+ victim.getId());
			anchor.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					event.preventDefault();
					Dispatcher.forwardEvent(AppEvents.GO_TO_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT,
							new Integer(victim.getId()));

				}
			});

			linkPanel.add(anchor);
			panel.add(linkPanel);

		}

		add(panel);

	}
}
