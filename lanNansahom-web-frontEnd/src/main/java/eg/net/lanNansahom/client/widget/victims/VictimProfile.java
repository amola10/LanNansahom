package eg.net.lanNansahom.client.widget.victims;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;

import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.Resources;
import eg.net.lanNansahom.client.view.ApplicationView;
import eg.net.lanNansahom.client.widget.common.ImageGalleryPanel;
import eg.net.lanNansahom.client.widget.common.InnerPage;
import eg.net.lanNansahom.client.widget.common.VideosGallery;
import eg.net.lanNansahom.shared.beans.ImageBean;
import eg.net.lanNansahom.shared.beans.ImageCategry;
import eg.net.lanNansahom.shared.beans.MartyrBean;
import eg.net.lanNansahom.shared.beans.VictimBean;
import eg.net.lanNansahom.shared.beans.VideoBean;

public class VictimProfile extends InnerPage {

	private final VictimBean victimBean;

	public VictimProfile(VictimBean pVictimBean) {
		super();
		victimBean = pVictimBean;
		addAttachHandler(new AttachEvent.Handler() {

			public void onAttachOrDetach(AttachEvent event) {
				if (isAttached()) {
					Messages messages = GWT.create(Messages.class);
					Window.setTitle(messages.lannansahom() + " - " + victimBean.getName());

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
		layoutData.setSize(0.5f);
		layoutData.setFloatable(false);
		layoutData.setMargins(new Margins(0, 0, 0, 5));
		container.add(prepateProfileInformation(), layoutData);

		layoutData = new BorderLayoutData(LayoutRegion.CENTER);
		layoutData.setSize(0.5f);
		layoutData.setFloatable(false);
		layoutData.setMargins(new Margins(0, 5, 0, 0));

		ContentPanel subContainer = new ContentPanel();
		subContainer.setHeaderVisible(false);
		subContainer.setBorders(false);
		subContainer.setBodyBorder(false);
		subContainer.setLayout(new RowLayout(Orientation.VERTICAL));

		List<ImageBean> images = new ArrayList<ImageBean>();
		images.addAll(victimBean.getImagesByType(ImageCategry.Banner));
		images.addAll(victimBean.getImagesByType(ImageCategry.Normal));

		List<VideoBean> videos = victimBean.getVideos();

		subContainer.add(prepateProfile(), new RowData(1, calculateProfileHieght(images, videos)));

		if (videos.size() > 0) {
			subContainer.add(new VideosGallery(videos), new RowData(1, 0.25));
		}

		if (images.size() > 0) {
			subContainer.add(new ImageGalleryPanel(images), new RowData(1, 0.25));
		}

		container.add(subContainer, layoutData);
	}

	private float calculateProfileHieght(List<ImageBean> images, List<VideoBean> videos) {
		float result = 0.5f;
		if (images.size() == 0) {
			result += 0.25;
		}

		if (videos.size() == 0) {
			result += 0.25;
		}

		return result;

	}

	@Override
	protected void onLoad() {
		ApplicationView.customScroll("scrollPane");
		Element element = DOM.getElementById("title");
		if (element != null) {
			element.setAttribute("content", victimBean.getName());
		}

	}

	private LayoutContainer prepateProfile() {
		LayoutContainer container = new LayoutContainer();
		container.setLayout(new VBoxLayout(VBoxLayoutAlign.CENTER));
		container.setStyleName("profilePicture");
		List<ImageBean> profileImages = victimBean.getImagesByType(ImageCategry.Profile);
		Image image = new Image();
		if (profileImages.size() > 0) {
			image.setUrl("http://" + Window.Location.getHost() + "/images/" + profileImages.get(0).getUrl());
		} else {
			Resources resource = GWT.create(Resources.class);
			image.setResource(resource.anonymousProfile());
		}
		container.add(image, new VBoxLayoutData(new Margins(0)));

		// show facebook thumbnail
		List<ImageBean> thumbnailsImages = victimBean.getImagesByType(ImageCategry.Thumbnail);
		if (thumbnailsImages.size() > 0) {
			// Set Shortcut
			Element element = DOM.getElementById("shortcutImage");
			if (element != null) {
				element.setAttribute("content", "http://lan-nansahom.org/images/" + thumbnailsImages.get(0).getUrl());
			}
		}
		return container;
	}

	private ContentPanel prepateProfileInformation() {
		Messages messages = GWT.create(Messages.class);

		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);
		panel.setBodyStyleName("scrollPane");
		Text name = new Text(victimBean.getName());
		name.setStyleName("victimName");
		panel.add(createText(victimBean.getName(), "victimName"));

		if (victimBean instanceof MartyrBean) {
			MartyrBean martyrBean = (MartyrBean) victimBean;
			if (martyrBean.getAge() != null)
				panel.add(createText(messages.age() + " : " + martyrBean.getAge(), "victimAge"));

			if (martyrBean.getDeathArea() != null)
				panel.add(createText(messages.placeOfDeath() + " : " + martyrBean.getDeathArea().getName(),
						"victimArea"));

			if (martyrBean.getDeathDate() != null)
				panel.add(createText(
						messages.dateOfDeath() + " : " + ApplicationView.formateDate(martyrBean.getDeathDate()),
						"victimDate"));

		} else {
			if (victimBean.getInjuryArea() != null)
				panel.add(createText(messages.placeOfInjury() + " : " + victimBean.getInjuryArea().getName(),
						"victimArea"));
			if (victimBean.getInjuryDate() != null)
				panel.add(createText(
						messages.dateOfInjury() + " : " + ApplicationView.formateDate(victimBean.getInjuryDate()),
						"victimDate"));

		}

		if (victimBean.getEducation() != null)
			panel.add(createText(messages.education() + " : " + victimBean.getEducation().getName(), "victimEducation"));
		if (victimBean.getJob() != null)
			panel.add(createText(messages.job() + " : " + victimBean.getJob().getName(), "victimJob"));

		if (victimBean.getDescription() != null) {
			panel.add(createText(victimBean.getDescription(), "victimDescription"));
		} else {
			panel.add(createText(messages.missingDescription(), "victimDescription"));
		}

		return panel;
	}

	private Text createText(String pText, String pClass) {
		Text result = new Text(pText);
		result.setStyleName(pClass);
		return result;

	}
}
