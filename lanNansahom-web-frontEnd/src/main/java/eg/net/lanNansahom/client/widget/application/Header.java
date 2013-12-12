package eg.net.lanNansahom.client.widget.application;

import com.extjs.gxt.ui.client.Style.Direction;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.fx.FxConfig;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Image;

import eg.net.gxt.client.EventType;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Resources;

public class Header extends LayoutContainer {

	private ContentPanel panel;

	public Header() {
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

		panel = new ContentPanel();
		panel.setLayout(new RowLayout(Orientation.HORIZONTAL));

		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);
		panel.setVisible(false);
		panel.setBodyStyleName("header");

		ContentPanel rightPanel = new ContentPanel();
		rightPanel.setHeaderVisible(false);
		rightPanel.setBorders(false);
		rightPanel.setBodyBorder(false);
		rightPanel.setBodyStyleName("rightHeader");

		ContentPanel leftPanel = new ContentPanel();
		leftPanel.setHeaderVisible(false);
		leftPanel.setBorders(false);
		leftPanel.setBodyBorder(false);
		leftPanel.setBodyStyleName("leftHeader");

		ContentPanel middlePanel = new ContentPanel();
		middlePanel.setHeaderVisible(false);
		middlePanel.setBorders(false);
		middlePanel.setBodyBorder(false);
		middlePanel.setBodyStyleName("middleHeader");

		Resources resources = GWT.create(Resources.class);
		addImageToPanel(rightPanel, "homepage_link", resources.homepage(), null, AppEvents.HOME_PAGE_EVENT,
				Boolean.FALSE);
		addDivider(rightPanel);
		addImageToPanel(rightPanel, "about_link", resources.about(), null, AppEvents.ABOUT_US_EVENT, null);
		addDivider(rightPanel);
		addImageToPanel(rightPanel, "martyrs_link", resources.martyrs(), null, AppEvents.GO_TO_MARTYRS_HOMEPAGE_EVENT,
				null);
		addDivider(rightPanel);
		addImageToPanel(rightPanel, "injured_link", resources.injured(), null, AppEvents.GO_TO_INJURIES_HOMEPAGE_EVENT,
				null);
		addDivider(rightPanel);
		addImageToPanel(rightPanel, "contactus_link", resources.conatctus(), null, AppEvents.CONTACT_US_EVENT, null);

		addImageToPanel(leftPanel, "twitter_link", resources.twitter(), resources.twitterHover(),
				AppEvents.OPEN_TWITTER_EVENT, null);
		addImageToPanel(leftPanel, "youtube_link", resources.youtube(), resources.youtubeHover(),
				AppEvents.OPEN_YOUTUBE_EVENT, null);
		addImageToPanel(leftPanel, "rss_link", resources.rss(), resources.rssHover(), AppEvents.OPEN_RSS_EVENT, null);
		addImageToPanel(leftPanel, "facebook_link", resources.facebook(), resources.facebookHover(),
				AppEvents.OPEN_FACEBOOK_EVENT, null);

		panel.add(rightPanel, new RowData(0.55, 1, new Margins(0)));
		panel.add(middlePanel, new RowData(0.23, 1, new Margins(0)));
		panel.add(leftPanel, new RowData(0.22, 1, new Margins(0)));

		add(panel);
	}

	public void showHeader() {
		if (panel != null && panel.isVisible() == false) {
			panel.setVisible(true);
			animateHeader();
		}
	}

	public boolean isHeaderShown() {
		if (panel != null) {
			return panel.isVisible();
		}
		return false;
	}

	private void animateHeader() {
		panel.el().slideIn(Direction.DOWN, FxConfig.NONE);
	}

	private void addImageToPanel(ContentPanel parentPenel, String pClass, final ImageResource pImage,
			final ImageResource pHoverImage, final EventType pEventType, final Object pData) {

		Anchor anchor = new Anchor();
		anchor.setStyleName(pClass);

		// workaround to identify main links
		if (pHoverImage == null) {
			anchor.setHref(Window.Location.getHref().replaceFirst("#" + History.getToken(), "") + "#!"
					+ pEventType.getToken());
		}

		final Image image = new Image(pImage);
		if (pEventType != null) {
			anchor.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					event.preventDefault();
					Dispatcher.forwardEvent(AppEvents.LEAVE_HOME_PAGE_EVENT);
					if (pData != null) {
						Dispatcher.forwardEvent(pEventType, pData);
					} else {
						Dispatcher.forwardEvent(pEventType);
					}
				}
			});
		}
		if (pHoverImage != null) {
			anchor.addMouseOverHandler(new MouseOverHandler() {

				public void onMouseOver(MouseOverEvent event) {
					image.setResource(pHoverImage);

				}
			});
			anchor.addMouseOutHandler(new MouseOutHandler() {

				public void onMouseOut(MouseOutEvent event) {
					image.setResource(pImage);
				}
			});
		}

		parentPenel.add(anchor);

		DOM.insertChild(anchor.getElement(), image.getElement(), 0);
	}

	private void addDivider(ContentPanel parentPenel) {
		Resources resources = GWT.create(Resources.class);
		final Image image = new Image(resources.divider());
		parentPenel.add(image);
	}

}
