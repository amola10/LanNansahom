package eg.net.lanNansahom.client;

import com.extjs.gxt.ui.client.util.Theme;
import com.google.gwt.user.client.Window;

import eg.net.gxt.client.BaseEntryBoint;
import eg.net.gxt.client.Event;
import eg.net.gxt.client.EventType;
import eg.net.gxt.client.theme.Black;
import eg.net.lanNansahom.client.controller.ApplicationController;
import eg.net.lanNansahom.client.controller.InjuriesController;
import eg.net.lanNansahom.client.controller.MartyrsController;
import eg.net.lanNansahom.client.controller.SearchController;
import eg.net.lanNansahom.client.controller.VictimController;

/**
 * The FrontEnd EntryBoint.
 */
public class FrontEnd extends BaseEntryBoint {

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.gxt.client.BaseEntryBoint#init()
	 */
	@Override
	public void init() {
		registerController(new ApplicationController());
		registerController(new MartyrsController());
		registerController(new InjuriesController());
		registerController(new VictimController());
		registerController(new SearchController());
		AppEvents.registerEventType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.gxt.client.BaseEntryBoint#start()
	 */
	@Override
	public void start() {
		String hash = Window.Location.getHash();
		EventType eventType = hash.indexOf("!") != -1 ? Event.parseType(hash.substring(2)) : Event.parseType(hash
				.substring(1));
		if (!"".equals(hash) && eventType != null && !eventType.equals(AppEvents.HOME_PAGE_EVENT)) {
			String token = hash.indexOf("!") != -1 ? hash.substring(2) : hash.substring(1);
			Event event = new Event(Event.parseType(token), Event.parseData(token));
			this.fireEvent(AppEvents.INITIALIZE_EVENT, event);
		} else {
			this.fireEvent(AppEvents.HOME_PAGE_EVENT);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.gxt.client.BaseEntryBoint#getActiveTheme()
	 */
	@Override
	public Theme getActiveTheme() {
		return Black.BLACK;
	}

}
