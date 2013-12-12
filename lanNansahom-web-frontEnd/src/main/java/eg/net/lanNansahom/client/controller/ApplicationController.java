package eg.net.lanNansahom.client.controller;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.google.gwt.user.client.Window;

import eg.net.gxt.client.controller.BaseController;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.view.ApplicationView;

public class ApplicationController extends BaseController {

	private static final String FACEBOOK_PAGE_URL = "http://www.facebook.com/pages/%D9%84%D9%86-%D9%86%D9%86%D8%B3%D8%A7%D9%87%D9%85-%D8%A7%D9%84%D9%85%D8%A8%D8%A7%D8%AF%D8%B1%D8%A9-%D8%A7%D9%84%D8%B4%D8%B9%D8%A8%D9%8A%D8%A9-%D9%84%D8%AA%D9%83%D8%B1%D9%8A%D9%85-%D8%B4%D9%87%D8%AF%D8%A7%D8%A1-%D9%88%D9%85%D8%B5%D8%A7%D8%A8%D9%89-%D8%A7%D9%84%D8%AB%D9%88%D8%B1%D8%A9/132838593473626";;
	private static final String YOUTUBE_URL = "http://www.youtube.com/LanNansahom1";
	private static final String TWITTER_URL = "https://twitter.com/#!/LanNansahom";
	private static final String RSS_URL = "/feeds/rss";

	private final ApplicationView view;

	public ApplicationController() {
		super();
		view = new ApplicationView(this);

	}

	@Override
	protected void registerEvents() {
		registerEventTypes(AppEvents.HOME_PAGE_EVENT);
		registerEventTypes(AppEvents.SHOW_HEADER_EVENT);
		registerEventTypes(AppEvents.OPEN_FACEBOOK_EVENT);
		registerEventTypes(AppEvents.OPEN_RSS_EVENT);
		registerEventTypes(AppEvents.OPEN_TWITTER_EVENT);
		registerEventTypes(AppEvents.OPEN_YOUTUBE_EVENT);
		registerEventTypes(AppEvents.ABOUT_US_EVENT);
		registerEventTypes(AppEvents.LEAVE_HOME_PAGE_EVENT);
		registerEventTypes(AppEvents.CONTACT_US_EVENT);
		registerEventTypes(AppEvents.INITIALIZE_EVENT);
	}

	@Override
	public void handleEvent(AppEvent event) {
		switch (event.getType().getEventCode()) {

		case AppEvents.HOME_PAGE_EVENT_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.INITIALIZE_EVENT_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.SHOW_HEADER_EVENT_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.OPEN_FACEBOOK_EVENT_CODE:
			Window.open(FACEBOOK_PAGE_URL, "", "");
			break;
		case AppEvents.OPEN_YOUTUBE_EVENT_CODE:
			Window.open(YOUTUBE_URL, "", "");
			break;
		case AppEvents.OPEN_TWITTER_EVENT_CODE:
			Window.open(TWITTER_URL, "", "");
			break;
		case AppEvents.OPEN_RSS_EVENT_CODE:
			String url = "http://" + Window.Location.getHost() + RSS_URL;
			Window.open(url, "", "");
			break;
		case AppEvents.LEAVE_HOME_PAGE_EVENT_CODE:
			forwardToView(view, event);
			break;
		case AppEvents.ABOUT_US_EVENT_CODE:
			forwardToView(view, new AppEvent(AppEvents.LEAVE_HOME_PAGE_EVENT));
			forwardToView(view, event);
			break;
		case AppEvents.CONTACT_US_EVENT_CODE:
			forwardToView(view, new AppEvent(AppEvents.LEAVE_HOME_PAGE_EVENT));
			forwardToView(view, event);
			break;

		default:
			break;
		}

	}

}
