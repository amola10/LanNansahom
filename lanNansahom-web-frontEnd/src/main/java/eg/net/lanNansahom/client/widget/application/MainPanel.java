package eg.net.lanNansahom.client.widget.application;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;

import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.widget.application.LogoPanel.AnimationListener;
import eg.net.lanNansahom.client.widget.victims.FadingVictimImagesPanel;
import eg.net.lanNansahom.client.widget.victims.FadingVictimImagesPanel.FadingListener;

public class MainPanel extends LayoutContainer implements FadingListener, AnimationListener {

	private LogoPanel logoPanel;
	private FadingVictimImagesPanel fadingImagesPanel;
	private boolean isHeaderShown = false;

	public MainPanel() {
		super();
		setLayout(new FitLayout());
		setScrollMode(Scroll.NONE);
		addAttachHandler(new AttachEvent.Handler() {

			public void onAttachOrDetach(AttachEvent event) {
				if (isAttached()) {
					Messages messages = GWT.create(Messages.class);
					Window.setTitle(messages.lannansahom() + " - " + messages.homepage());
				}

			}
		});
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
		fadingImagesPanel = new FadingVictimImagesPanel();
		add(fadingImagesPanel);
		logoPanel = new LogoPanel("logo");
		add(logoPanel);
		fadingImagesPanel.fadeImageList(this);
		Messages messages = GWT.create(Messages.class);
	}

	public void faddingFinishd() {
		logoPanel.showLogoOnCenterWithFading(this);
	}

	public void animationFinishd() {
		isHeaderShown = true;
		Dispatcher.forwardEvent(AppEvents.SHOW_HEADER_EVENT);
	}

	public void onLeave() {
		if (!isHeaderShown) {
			Dispatcher.forwardEvent(AppEvents.SHOW_HEADER_EVENT);
		}
	}

	public void onIn() {
	}
}
