package eg.net.lanNansahom.client.widget.victims;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout.HBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Image;

import eg.net.gxt.client.widget.ImageLink;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.CustomGXTUtil;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.Resources;
import eg.net.lanNansahom.client.VictimNavigation;
import eg.net.lanNansahom.client.view.ApplicationView;
import eg.net.lanNansahom.shared.beans.ImageBean;
import eg.net.lanNansahom.shared.beans.ImageCategry;
import eg.net.lanNansahom.shared.beans.MartyrBean;
import eg.net.lanNansahom.shared.beans.VictimBean;

public class VictimsLightBox extends ContentPanel {

	private final int NUMBER_OF_CHARACTERS = 240;
	private final VictimBean victimBean;
	private ImageLink nextButton;
	private ImageLink perviousButton;
	private ImageLink firstButton;
	private ImageLink lastButton;
	private boolean isNextEnabled;
	private boolean isPreviousEnabled;
	private final String url;
	private final List<HandlerRegistration> handlers = new ArrayList<HandlerRegistration>();

	public VictimsLightBox(VictimBean pVictimBean) {
		super();
		victimBean = pVictimBean;
		url = Window.Location.getHref().replaceFirst("#" + History.getToken(), "") + "#!martyr;" + victimBean.getId();

		setHeaderVisible(false);
		setBorders(false);
		setBodyBorder(false);
		setScrollMode(Scroll.NONE);
		setLayout(new BorderLayout());
		setSize("700", "500");

	}

	private void attachListeners(final VictimNavigation navigation) {
		CustomGXTUtil.hideLoading();
		if (isNextEnabled) {
			handlers.add(nextButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					deattachListeners();
					Dispatcher.forwardEvent(AppEvents.GO_TO_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT,
							navigation.getNextId(victimBean.getId()));

				}
			}));

			handlers.add(lastButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					deattachListeners();
					Dispatcher.forwardEvent(AppEvents.GO_TO_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT, navigation.getLastId());

				}
			}));
		}

		if (isPreviousEnabled) {
			handlers.add(perviousButton.addClickHandler(new ClickHandler() {

				public void onClick(ClickEvent event) {
					deattachListeners();
					Dispatcher.forwardEvent(AppEvents.GO_TO_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT,
							navigation.getPreviousId(victimBean.getId()));

				}
			}));

			handlers.add(firstButton.addClickHandler(new ClickHandler() {

				public void onClick(ClickEvent event) {
					deattachListeners();
					Dispatcher.forwardEvent(AppEvents.GO_TO_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT, navigation.getFirstId());

				}
			}));
		}

	}

	private void deattachListeners() {
		CustomGXTUtil.showLoading();
		for (int i = 0; i < handlers.size(); i++) {
			handlers.get(i).removeHandler();
		}
		handlers.clear();
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
		layoutData.setMargins(new Margins(30, 5, 0, 5));
		add(prepateProfileInformation(), layoutData);

		layoutData = new BorderLayoutData(LayoutRegion.CENTER);
		layoutData.setSize(0.5f);
		layoutData.setFloatable(false);
		layoutData.setMargins(new Margins(30, 5, 0, 0));

		add(prepateProfile(), layoutData);

		layoutData = new BorderLayoutData(LayoutRegion.SOUTH);
		layoutData.setSize(68);
		layoutData.setFloatable(false);
		layoutData.setMargins(new Margins(0, 5, 0, 0));

		add(prepareFooter(), layoutData);

	}

	private ContentPanel prepateProfile() {
		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);
		panel.setLayout(new RowLayout(Orientation.VERTICAL));

		LayoutContainer container = new LayoutContainer();
		container.setLayout(new VBoxLayout(VBoxLayoutAlign.CENTER));
		List<ImageBean> profileImages = victimBean.getImagesByType(ImageCategry.Profile);
		Image image = new Image();
		if (profileImages.size() > 0) {
			image.setUrl("http://" + Window.Location.getHost() + "/images/" + profileImages.get(0).getUrl());
		} else {
			Resources resource = GWT.create(Resources.class);
			image.setResource(resource.anonymousProfile());
		}
		container.add(image, new VBoxLayoutData());

		panel.add(container, new RowData(1, 1));
		return panel;
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
			if (victimBean.getDescription().length() > NUMBER_OF_CHARACTERS) {
				String description = victimBean.getDescription().substring(0, NUMBER_OF_CHARACTERS);
				description = description.substring(0, description.lastIndexOf(" ")) + " .....";
				panel.add(createText(description, "victimDescription"));
			} else {
				panel.add(createText(victimBean.getDescription(), "victimDescription"));
			}

		} else {
			panel.add(createText(messages.missingDescription(), "victimDescription"));
		}

		Anchor anchor = new Anchor(messages.more());
		anchor.setHref(url);
		anchor.setStyleName("more");
		anchor.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				event.preventDefault();
				ApplicationView.closeLightBox();
				Dispatcher.forwardEvent(AppEvents.GO_TO_VICTIM_DETAILS_EVENT, new Integer(victimBean.getId()));

			}
		});
		panel.add(anchor);
		return panel;
	}

	private ContentPanel prepareFooter() {

		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);
		panel.setLayout(new RowLayout(Orientation.VERTICAL));

		panel.add(prepareNavigation());
		panel.add(prepareSharingButtons());
		return panel;

	}

	private ContentPanel prepareNavigation() {
		final VictimNavigation navigation = Registry.get("VictimNavigation");
		isNextEnabled = navigation != null && navigation.getNextId(victimBean.getId()) != null ? true : false;
		isPreviousEnabled = navigation != null && navigation.getPreviousId(victimBean.getId()) != null ? true : false;

		HBoxLayout layout = new HBoxLayout();
		layout.setHBoxLayoutAlign(HBoxLayoutAlign.MIDDLE);

		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);
		panel.setLayout(layout);
		panel.setBodyStyleName("navigationPanel");
		panel.setHeight(28);

		Resources resources = (Resources) GWT.create(Resources.class);
		firstButton = new ImageLink(isPreviousEnabled ? resources.first() : resources.firstDisabled());
		if (isPreviousEnabled) {
			addHoverEffect(firstButton);
		}
		panel.add(firstButton, new HBoxLayoutData(new Margins(3, 348, 3, 0)));

		perviousButton = new ImageLink(isPreviousEnabled ? resources.previous() : resources.previousDisabled());
		if (isPreviousEnabled) {
			addHoverEffect(perviousButton);
		}
		panel.add(perviousButton, new HBoxLayoutData(new Margins(3, 0, 3, 0)));

		nextButton = new ImageLink(isNextEnabled ? resources.next() : resources.nextDisabled());
		if (isNextEnabled) {
			addHoverEffect(nextButton);
		}
		panel.add(nextButton, new HBoxLayoutData(new Margins(3, 0, 3, 0)));

		lastButton = new ImageLink(isNextEnabled ? resources.last() : resources.lastDisabled());
		if (isNextEnabled) {
			addHoverEffect(lastButton);
		}
		panel.add(lastButton, new HBoxLayoutData(new Margins(3, 0, 3, 308)));

		attachListeners(navigation);
		return panel;

	}

	private void addHoverEffect(final ImageLink imageLink) {
		imageLink.addMouseOverHandler(new MouseOverHandler() {

			public void onMouseOver(MouseOverEvent event) {
				imageLink.getElement().getStyle().setBackgroundColor("red");
			}
		});
		imageLink.addMouseOutHandler(new MouseOutHandler() {

			public void onMouseOut(MouseOutEvent event) {
				imageLink.getElement().getStyle().setBackgroundColor("transparent");
			}
		});

	}

	private ContentPanel prepareSharingButtons() {

		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);
		panel.setLayout(new RowLayout(Orientation.HORIZONTAL));
		panel.setHeight(40);
		panel.add(createAddThisOtherButtons(), new RowData(120, 1, new Margins(10, 0, 0, 0)));
		panel.add(createEmptyPanel(), new RowData(250, 1, new Margins(10, 0, 0, 0)));
		panel.add(createAddThisFacebookButtons(), new RowData(310, 1, new Margins(10, 0, 0, 0)));

		return panel;

	}

	private Html createAddThisOtherButtons() {
		String html = "<div class=\"addthis_toolbox addthis_default_style \" addthis:url=\"" + url + "\" >";
		html += "<a class=\"addthis_button_preferred_1\"></a>";
		html += "<a class=\"addthis_button_preferred_2\"></a>";
		html += "<a class=\"addthis_button_preferred_3\"></a>";
		html += "<a class=\"addthis_button_preferred_4\"></a>";
		html += "<a class=\"addthis_button_compact\"></a>";
		html += "<a class=\"addthis_counter addthis_bubble_style\"></a>";
		html += "</div>";

		return new Html(html);
	}

	private Html createAddThisFacebookButtons() {

		String html = "<div class=\"addthis_toolbox addthis_default_style \" addthis:url=\"" + url + "\">";
		html += "<a class=\"addthis_button_facebook_like\" fb:like:layout=\"button_count\" id=\"facebookLike\"></a>";
		html += "<a class=\"addthis_button_tweet\" ></a>";
		html += "<a class=\"addthis_button_google_plusone\" g:plusone:size=\"medium\"></a>";
		html += "</div>";

		return new Html(html);
	}

	private ContentPanel createEmptyPanel() {
		ContentPanel spacePanel = new ContentPanel();
		spacePanel.setHeaderVisible(false);
		spacePanel.setBorders(false);
		spacePanel.setBodyBorder(false);
		return spacePanel;
	}

	private Text createText(String pText, String pClass) {
		Text result = new Text(pText);
		result.setStyleName(pClass);
		return result;

	}
}