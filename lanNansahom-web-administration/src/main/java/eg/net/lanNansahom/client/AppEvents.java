package eg.net.lanNansahom.client;

import eg.net.gxt.client.EventType;

public interface AppEvents {

	public static final int HOME_PAGE_EVENT_CODE = 1;

	public static final int GO_TO_ADD_ANNOUNCEMENT_CODE = 2;
	public static final int ADD_ANNOUNCEMENT_CODE = 3;
	public static final int GO_TO_LIST_ANNOUNCEMENTS_CODE = 4;
	public static final int LIST_ANNOUNCEMENTS_CODE = 5;
	public static final int REFRESH_ANNOUNCEMENTS_CODE = 6;
	public static final int GO_TO_UPDATE_ANNOUNCEMENT_CODE = 7;
	public static final int UPDATE_ANNOUNCEMENT_CODE = 8;

	public static final int GO_TO_ADD_MARTYR_CODE = 9;
	public static final int ADD_MARTYR_CODE = 10;
	public static final int GO_TO_SEARCH_MARTYRS_CODE = 11;
	public static final int SEARCH_MARTYRS_CODE = 12;
	public static final int REFRESH_MARTYRS_CODE = 13;
	public static final int GO_TO_UPDATE_MARTYR_CODE = 14;
	public static final int UPDATE_MARTYR_CODE = 15;
	public static final int DELETE_MARTYR_CODE = 16;

	public static final int GO_TO_ADD_INJURED_CODE = 17;
	public static final int ADD_INJURED_CODE = 18;
	public static final int GO_TO_SEARCH_INJURIES_CODE = 19;
	public static final int SEARCH_INJURIES_CODE = 20;
	public static final int REFRESH_INJURIES_CODE = 21;
	public static final int GO_TO_UPDATE_INJURED_CODE = 22;
	public static final int UPDATE_INJURED_CODE = 23;
	public static final int DELETE_INJURED_CODE = 24;
	public static final int GENERATE_INJURED_CODE = 25;
	public static final int GENERATE_MARTYRS_CODE = 26;
	public static final int GENERATE_ANNOUNCEMENT_CODE = 27;

	public static final int GO_TO_ADD_LOOKUP_CODE = 28;
	public static final int ADD_LOOKUP_CODE = 29;
	public static final int GO_TO_LIST_LOOKUPS_CODE = 30;
	public static final int LIST_LOOKUPS_CODE = 31;
	public static final int REFRESH_LOOKUPS_CODE = 32;
	public static final int GO_TO_UPDATE_LOOKUP_CODE = 33;
	public static final int UPDATE_LOOKUP_CODE = 34;
	public static final int SEND_EMAIL_CODE = 35;

	public static final EventType HOME_PAGE = new EventType(HOME_PAGE_EVENT_CODE, "homepage");

	public static final EventType GO_TO_ADD_ANNOUNCEMENT = new EventType(GO_TO_ADD_ANNOUNCEMENT_CODE, "addAnnouncment");
	public static final EventType ADD_ANNOUNCEMENT = new EventType(ADD_ANNOUNCEMENT_CODE);
	public static final EventType GO_TO_LIST_ANNOUNCEMENTS = new EventType(GO_TO_LIST_ANNOUNCEMENTS_CODE,
			"listAnnouncment");
	public static final EventType LIST_ANNOUNCEMENTS = new EventType(LIST_ANNOUNCEMENTS_CODE);
	public static final EventType REFRESH_ANNOUNCEMENTS = new EventType(REFRESH_ANNOUNCEMENTS_CODE);
	public static final EventType GO_TO_UPDATE_ANNOUNCEMENT = new EventType(GO_TO_UPDATE_ANNOUNCEMENT_CODE,
			"updateAnnouncment");
	public static final EventType UPDATE_ANNOUNCEMENT = new EventType(UPDATE_ANNOUNCEMENT_CODE);

	public static final EventType GO_TO_ADD_MARTYR = new EventType(GO_TO_ADD_MARTYR_CODE, "addMartyr");
	public static final EventType ADD_MARTYR = new EventType(ADD_MARTYR_CODE);
	public static final EventType GO_TO_SEARCH_MARTYRS = new EventType(GO_TO_SEARCH_MARTYRS_CODE, "searchMartyr");
	public static final EventType SEARCH_MARTYRS = new EventType(SEARCH_MARTYRS_CODE);
	public static final EventType REFRESH_MARTYRS = new EventType(REFRESH_MARTYRS_CODE);
	public static final EventType GO_TO_UPDATE_MARTYR = new EventType(GO_TO_UPDATE_MARTYR_CODE, "updateMartyr");
	public static final EventType UPDATE_MARTYR = new EventType(UPDATE_MARTYR_CODE);
	public static final EventType DELETE_MARTYR = new EventType(DELETE_MARTYR_CODE);

	public static final EventType GO_TO_ADD_INJURED = new EventType(GO_TO_ADD_INJURED_CODE, "addInjured");
	public static final EventType ADD_INJURED = new EventType(ADD_INJURED_CODE);
	public static final EventType GO_TO_SEARCH_INJURIES = new EventType(GO_TO_SEARCH_INJURIES_CODE, "searchInjured");
	public static final EventType SEARCH_INJURIES = new EventType(SEARCH_INJURIES_CODE);
	public static final EventType REFRESH_INJURIES = new EventType(REFRESH_INJURIES_CODE);
	public static final EventType GO_TO_UPDATE_INJURED = new EventType(GO_TO_UPDATE_INJURED_CODE, "updateInjured");
	public static final EventType UPDATE_INJURED = new EventType(UPDATE_INJURED_CODE);
	public static final EventType DELETE_INJURED = new EventType(DELETE_INJURED_CODE);

	public static final EventType GENERATE_INJURED = new EventType(GENERATE_INJURED_CODE);
	public static final EventType GENERATE_MARTYRS = new EventType(GENERATE_MARTYRS_CODE);
	public static final EventType GENERATE_ANNOUNCEMENT = new EventType(GENERATE_ANNOUNCEMENT_CODE);

	public static final EventType GO_TO_ADD_LOOKUP = new EventType(GO_TO_ADD_LOOKUP_CODE, "addLookup");
	public static final EventType ADD_LOOKUP = new EventType(ADD_LOOKUP_CODE);
	public static final EventType GO_TO_LIST_LOOKUPS = new EventType(GO_TO_LIST_LOOKUPS_CODE, "listLookup");
	public static final EventType LIST_LOOKUPS = new EventType(LIST_LOOKUPS_CODE);
	public static final EventType REFRESH_LOOKUPS = new EventType(REFRESH_LOOKUPS_CODE);
	public static final EventType GO_TO_UPDATE_LOOKUP = new EventType(GO_TO_UPDATE_LOOKUP_CODE, "updateLookup");
	public static final EventType UPDATE_LOOKUP = new EventType(UPDATE_LOOKUP_CODE);

	public static final EventType SEND_EMAIL = new EventType(SEND_EMAIL_CODE);
}
