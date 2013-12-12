package eg.net.lanNansahom.client;

import eg.net.gxt.client.EventType;
import eg.net.gxt.client.EventTypeRegistry;

public class AppEvents {

	public static final int HOME_PAGE_EVENT_CODE = 1;
	public static final int INITIALIZE_EVENT_CODE = 2;
	public static final int SHOW_HEADER_EVENT_CODE = 3;

	public static final int OPEN_FACEBOOK_EVENT_CODE = 4;
	public static final int OPEN_TWITTER_EVENT_CODE = 5;
	public static final int OPEN_YOUTUBE_EVENT_CODE = 6;
	public static final int OPEN_RSS_EVENT_CODE = 7;

	public static final int ABOUT_US_EVENT_CODE = 8;
	public static final int MARTYRS_HOMEPAGE_EVENT_CODE = 9;
	public static final int INJURIES_HOMEPAGE_EVENT_CODE = 10;
	public static final int CONTACT_US_EVENT_CODE = 11;
	public static final int LEAVE_HOME_PAGE_EVENT_CODE = 12;
	public static final int GO_TO_MARTYRS_HOMEPAGE_EVENT_CODE = 13;
	public static final int GO_TO_INJURIES_HOMEPAGE_EVENT_CODE = 14;

	public static final int GO_TO_VICTIM_DETAILS_EVENT_CODE = 15;

	public static final int SHOW_VICTIM_DETAILS_EVENT_CODE = 16;

	public static final int SEARCH_EVENT_CODE = 17;
	public static final int GO_TO_ADVANCED_SEARCH_EVENT_CODE = 18;
	public static final int ADVANCED_SEARCH_EVENT_CODE = 19;
	public static final int SEARCH_RESULT_EVENT_CODE = 20;
	public static final int ADVANCED_SEARCH_RESULT_EVENT_CODE = 21;

	public static final int GO_TO_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT_CODE = 22;
	public static final int SHOW_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT_CODE = 23;

	public static final EventType HOME_PAGE_EVENT = new EventType(HOME_PAGE_EVENT_CODE, "homepage");
	public static final EventType ABOUT_US_EVENT = new EventType(ABOUT_US_EVENT_CODE, "about-us");
	public static final EventType GO_TO_MARTYRS_HOMEPAGE_EVENT = new EventType(GO_TO_MARTYRS_HOMEPAGE_EVENT_CODE,
			"martyrs");
	public static final EventType GO_TO_INJURIES_HOMEPAGE_EVENT = new EventType(GO_TO_INJURIES_HOMEPAGE_EVENT_CODE,
			"injuries");
	public static final EventType CONTACT_US_EVENT = new EventType(CONTACT_US_EVENT_CODE, "contact-us");

	public static final EventType INITIALIZE_EVENT = new EventType(INITIALIZE_EVENT_CODE);
	public static final EventType SHOW_HEADER_EVENT = new EventType(SHOW_HEADER_EVENT_CODE);
	public static final EventType OPEN_FACEBOOK_EVENT = new EventType(OPEN_FACEBOOK_EVENT_CODE);
	public static final EventType OPEN_TWITTER_EVENT = new EventType(OPEN_TWITTER_EVENT_CODE);
	public static final EventType OPEN_YOUTUBE_EVENT = new EventType(OPEN_YOUTUBE_EVENT_CODE);
	public static final EventType OPEN_RSS_EVENT = new EventType(OPEN_RSS_EVENT_CODE);

	public static final EventType INJURIES_HOMEPAGE_EVENT = new EventType(INJURIES_HOMEPAGE_EVENT_CODE);
	public static final EventType LEAVE_HOME_PAGE_EVENT = new EventType(LEAVE_HOME_PAGE_EVENT_CODE);

	public static final EventType MARTYRS_HOMEPAGE_EVENT = new EventType(MARTYRS_HOMEPAGE_EVENT_CODE);
	public static final EventType GO_TO_VICTIM_DETAILS_EVENT = new EventType(GO_TO_VICTIM_DETAILS_EVENT_CODE);
	public static final EventType SHOW_VICTIM_DETAILS_EVENT = new EventType(SHOW_VICTIM_DETAILS_EVENT_CODE, "martyr");

	public static final EventType SEARCH_EVENT = new EventType(SEARCH_EVENT_CODE, "search");
	public static final EventType GO_TO_ADVANCED_SEARCH_EVENT = new EventType(GO_TO_ADVANCED_SEARCH_EVENT_CODE,
			"advanced-search");

	public static final EventType ADVANCED_SEARCH_EVENT = new EventType(ADVANCED_SEARCH_EVENT_CODE);
	public static final EventType SEARCH_RESULT_EVENT = new EventType(SEARCH_RESULT_EVENT_CODE);
	public static final EventType ADVANCED_SEARCH_RESULT_EVENT = new EventType(ADVANCED_SEARCH_RESULT_EVENT_CODE);
	public static final EventType GO_TO_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT = new EventType(
			GO_TO_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT_CODE);
	public static final EventType SHOW_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT = new EventType(
			SHOW_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT_CODE);

	public static void registerEventType() {
		EventTypeRegistry.registerEventType(HOME_PAGE_EVENT);
		EventTypeRegistry.registerEventType(ABOUT_US_EVENT);
		EventTypeRegistry.registerEventType(GO_TO_MARTYRS_HOMEPAGE_EVENT);
		EventTypeRegistry.registerEventType(GO_TO_INJURIES_HOMEPAGE_EVENT);
		EventTypeRegistry.registerEventType(CONTACT_US_EVENT);
		EventTypeRegistry.registerEventType(SHOW_VICTIM_DETAILS_EVENT);
		EventTypeRegistry.registerEventType(SEARCH_EVENT);
		EventTypeRegistry.registerEventType(GO_TO_ADVANCED_SEARCH_EVENT);

	}

}
