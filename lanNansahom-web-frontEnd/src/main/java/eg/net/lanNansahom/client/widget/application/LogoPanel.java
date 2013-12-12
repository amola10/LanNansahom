package eg.net.lanNansahom.client.widget.application;

import com.extjs.gxt.ui.client.core.El.VisMode;
import com.extjs.gxt.ui.client.event.FxEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.fx.FxConfig;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Image;

import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.Resources;

public class LogoPanel extends ContentPanel {

	private static final int WIDTH = 432;

	public LogoPanel(String pCSSClass) {
		super();
		setHeaderVisible(false);
		setBorders(false);
		setBodyBorder(false);
		setBodyStyleName(pCSSClass);
		setWidth(WIDTH);
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
		Resources resources = (Resources) GWT.create(Resources.class);
		ClickHandler clickHandler = new ClickHandler() {
			public void onClick(ClickEvent event) {
				Dispatcher.forwardEvent(AppEvents.HOME_PAGE_EVENT, Boolean.FALSE);
			}
		};

		Messages messages = GWT.create(Messages.class);

		Image image = new Image(resources.logo());
		image.addClickHandler(clickHandler);
		image.setAltText(messages.homepage());
		// image.setTitle(messages.homepage());
		add(image);
	}

	/**
	 * Show logo.
	 * 
	 * @param panel
	 *            the panel
	 */
	public void showLogoOnCenterWithFading(final AnimationListener listener) {
		this.showLogoOnCenterWithoutFading();
		if (listener != null) {
			el().setVisibilityMode(VisMode.VISIBILITY);
			el().setVisibility(false);

			el().fadeIn(new FxConfig(new Listener<FxEvent>() {
				public void handleEvent(FxEvent be) {
					listener.animationFinishd();
				}
			}));
		}

	}

	public void showLogoOnCenterWithoutFading() {
		el().makePositionable(true);
		el().setLeft(0);
		el().setTop((3 * 72) + 1);
	}

	public interface AnimationListener {
		void animationFinishd();
	}

}
