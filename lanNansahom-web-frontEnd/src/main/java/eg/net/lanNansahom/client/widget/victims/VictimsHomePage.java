package eg.net.lanNansahom.client.widget.victims;

import java.util.List;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;

import eg.net.lanNansahom.client.JSONDataReader;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.widget.announcement.AnnouncementPanel;
import eg.net.lanNansahom.client.widget.common.ImageGalleryPanel;
import eg.net.lanNansahom.client.widget.common.InnerPage;
import eg.net.lanNansahom.client.widget.common.VideosGallery;
import eg.net.lanNansahom.shared.beans.ImageBean;
import eg.net.lanNansahom.shared.beans.VictimInfoBean;
import eg.net.lanNansahom.shared.beans.VideoBean;

public class VictimsHomePage extends InnerPage {

	private final ListVictimsPanel listVictimsPanel = new ListVictimsPanel();

	public VictimsHomePage() {
		super();
		addAttachHandler(new AttachEvent.Handler() {

			public void onAttachOrDetach(AttachEvent event) {
				if (isAttached()) {
					Messages messages = GWT.create(Messages.class);
					Window.setTitle(messages.lannansahom() + " - " + messages.martyrsTitle());
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

		BorderLayoutData layoutData = new BorderLayoutData(LayoutRegion.WEST);
		layoutData.setSize(452);
		layoutData.setFloatable(false);
		layoutData.setMargins(new Margins(5));
		container.add(listVictimsPanel, layoutData);

		layoutData = new BorderLayoutData(LayoutRegion.CENTER);
		layoutData.setFloatable(false);
		layoutData.setMargins(new Margins(5, 50, 5, 5));

		ContentPanel subContainer = new ContentPanel();
		subContainer.setHeaderVisible(false);
		subContainer.setBorders(false);
		subContainer.setBodyBorder(false);
		subContainer.setLayout(new RowLayout(Orientation.VERTICAL));

		List<ImageBean> images = JSONDataReader.loadImages();
		List<VideoBean> videos = JSONDataReader.loadVideos();

		subContainer.add(new AnnouncementPanel(JSONDataReader.loadAnnouncements()), new RowData(1,
				calculateAnnouncementHieght(images, videos)));

		if (videos.size() > 0) {
			subContainer.add(new VideosGallery(videos), new RowData(1, 0.25));
		}

		if (images.size() > 0) {
			subContainer.add(new ImageGalleryPanel(images), new RowData(1, 0.25));
		}

		container.add(subContainer, layoutData);
	}

	private float calculateAnnouncementHieght(List<ImageBean> images, List<VideoBean> videos) {
		float result = 0.5f;
		if (images.size() == 0) {
			result += 0.25;
		}

		if (videos.size() == 0) {
			result += 0.25;
		}
		return result;

	}

	public void showVictims(List<VictimInfoBean> pVictimInfoBeans) {
		listVictimsPanel.showVictims(pVictimInfoBeans);
	}

}
