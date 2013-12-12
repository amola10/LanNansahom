package eg.net.lanNansahom.client.widget.victims;

import java.util.List;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.Element;

import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.VictimNavigation;
import eg.net.lanNansahom.client.view.ApplicationView;
import eg.net.lanNansahom.client.widget.common.AbstractImagesPanel;
import eg.net.lanNansahom.shared.beans.ImageBean;

public class VictimImagesPanel extends AbstractImagesPanel {

	private final boolean isScrollable;
	private final VictimNavigation navigation;

	public VictimImagesPanel(List<ImageBean> pImages, boolean pIsScrollable) {
		super(pImages);
		isScrollable = pIsScrollable;
		navigation = new VictimNavigation();
		for (ImageBean bean : pImages) {
			navigation.add((Integer) bean.get(ImageBean.BINDING_VICTIM_ID));
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
	 * eg.net.lanNansahom.client.widget.common.AbstractImagesPanel#onRender(
	 * com.google.gwt.user.client.Element, int)
	 */
	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);
		if (isScrollable) {
			view.setStyleName("scrollPane");
		}

	}

	@Override
	protected void imageSelected(ImageBean imageBean) {
		Dispatcher.forwardEvent(AppEvents.GO_TO_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT,
				imageBean.get(ImageBean.BINDING_VICTIM_ID));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.extjs.gxt.ui.client.widget.ScrollContainer#afterRender()
	 */
	@Override
	protected void onLoad() {
		ApplicationView.createImageToolTip();
	}

}
