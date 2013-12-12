package eg.net.lanNansahom.client.widget.victims;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

import eg.net.lanNansahom.client.Resources;
import eg.net.lanNansahom.client.view.ApplicationView;
import eg.net.lanNansahom.shared.beans.ImageBean;
import eg.net.lanNansahom.shared.beans.VictimInfoBean;

public class ListVictimsPanel extends LayoutContainer {

	private final List<VictimInfoBean> victims = new ArrayList<VictimInfoBean>();
	private final ContentPanel panel = new ContentPanel();
	private Widget latestView;

	public ListVictimsPanel() {
		super();
		setLayout(new FitLayout());
		setStyleName("victimsList");
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
		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);
		panel.setLayout(new FitLayout());
		panel.setScrollMode(Scroll.NONE);
		panel.setLayout(new BorderLayout());
		switchMode(ListMode.ByImage);
		add(panel);

	}

	public void showVictims(List<VictimInfoBean> pVictimInfoBeans) {
		this.victims.addAll(pVictimInfoBeans);
		switchMode(ListMode.ByImage);
	}

	private ContentPanel createHeader(ListMode pMode) {

		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);
		panel.setBodyStyleName("martyrsHeader");
		Resources resources = (Resources) GWT.create(Resources.class);
		if (ListMode.ByImage.equals(pMode)) {
			addImageToPanel(panel, "martyrsByImage", resources.byImagesSelected(), ListMode.ByImage);
		} else {
			addImageToPanel(panel, "martyrsByImage", resources.byImagesNormal(), ListMode.ByImage);

		}

		if (ListMode.ByName.equals(pMode)) {
			addImageToPanel(panel, "martyrsByName", resources.byNameSelected(), ListMode.ByName);
		} else {
			addImageToPanel(panel, "martyrsByName", resources.byNameNormal(), ListMode.ByName);
		}

		if (ListMode.Statistics.equals(pMode)) {
			addImageToPanel(panel, "martyrsStatistics", resources.statisticsSelected(), ListMode.Statistics);
		} else {
			addImageToPanel(panel, "martyrsStatistics", resources.statisticsNormal(), ListMode.Statistics);
		}

		return panel;
	}

	private List<ImageBean> extractImages() {
		List<ImageBean> result = new ArrayList<ImageBean>();
		for (VictimInfoBean victimInfoBean : victims) {
			ImageBean imageBean = victimInfoBean.getProfileThumbnail();
			if (imageBean != null) {
				imageBean.set(ImageBean.BINDING_VICTIM_ID, new Integer(victimInfoBean.getId()));
				result.add(imageBean);
			}
		}
		return result;
	}

	private void addImageToPanel(ContentPanel parentPenel, String pClass, ImageResource pImage, final ListMode pMode) {
		Image image = new Image(pImage);
		image.setStyleName(pClass);
		image.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				switchMode(pMode);
			}
		});
		parentPenel.add(image);
	}

	private void switchMode(ListMode pMode) {
		panel.removeAll();
		BorderLayoutData layoutData = new BorderLayoutData(LayoutRegion.NORTH);
		layoutData.setSize(22);
		layoutData.setFloatable(false);
		panel.add(createHeader(pMode), layoutData);

		layoutData = new BorderLayoutData(LayoutRegion.CENTER);
		layoutData.setFloatable(false);

		latestView = createView(pMode);
		panel.add(latestView, layoutData);
		panel.layout();
		ApplicationView.customScroll("scrollPane");

	}

	private Widget createView(ListMode pMode) {
		Widget result = null;
		if (pMode.equals(ListMode.ByImage)) {
			result = new VictimImagesPanel(extractImages(), true);
		} else if (pMode.equals(ListMode.ByName)) {
			result = new ListVictimsByNamePanel(victims);
		} else if (pMode.equals(ListMode.Statistics)) {
			result = new StatisticsPanel();
		}
		return result;
	}

	enum ListMode {
		ByImage, ByName, Statistics;
	}
}
