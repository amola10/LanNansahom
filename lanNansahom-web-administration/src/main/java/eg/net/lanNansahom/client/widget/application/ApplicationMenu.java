package eg.net.lanNansahom.client.widget.application;

import com.google.gwt.core.client.GWT;

import eg.net.gxt.client.Event;
import eg.net.gxt.client.widget.MainMenu;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;

public class ApplicationMenu extends MainMenu {

	public ApplicationMenu() {
		super();
	}

	public void init() {
		Messages messages = GWT.create(Messages.class);

		addMenuGroup("Home");
		addMenuItem("Generation", new Event(AppEvents.HOME_PAGE, "back"));

		addMenuGroup(messages.martyrs());
		addMenuItem(messages.search(), new Event(AppEvents.GO_TO_SEARCH_MARTYRS));
		addMenuItem(messages.add(), new Event(AppEvents.GO_TO_ADD_MARTYR));

		addMenuGroup(messages.injuries());
		addMenuItem(messages.search(), new Event(AppEvents.GO_TO_SEARCH_INJURIES));
		addMenuItem(messages.add(), new Event(AppEvents.GO_TO_ADD_INJURED));

		addMenuGroup(messages.announcements());
		addMenuItem(messages.listAll(), new Event(AppEvents.GO_TO_LIST_ANNOUNCEMENTS));
		addMenuItem(messages.add(), new Event(AppEvents.GO_TO_ADD_ANNOUNCEMENT));

		addMenuGroup(messages.lookup());
		addMenuItem(messages.listAll(), new Event(AppEvents.GO_TO_LIST_LOOKUPS));
		addMenuItem(messages.add(), new Event(AppEvents.GO_TO_ADD_LOOKUP));

		addMenuGroup(messages.newsletter());
		addMenuItem(messages.send(), null);

	}
}
