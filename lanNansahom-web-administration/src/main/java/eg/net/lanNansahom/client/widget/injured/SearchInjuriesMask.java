package eg.net.lanNansahom.client.widget.injured;

import com.extjs.gxt.ui.client.event.EventType;
import com.google.gwt.core.client.GWT;

import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.widget.victims.SearchVictimsMask;

public class SearchInjuriesMask extends SearchVictimsMask {

	public SearchInjuriesMask() {
		super(constructTitle(), false);
	}

	/**
	 * Constuct title.
	 * 
	 * @return the string
	 */
	private static String constructTitle() {
		Messages messages = GWT.create(Messages.class);
		return messages.injuries() + "-> " + messages.search();
	}

	@Override
	protected EventType getSearchEvent() {
		return AppEvents.SEARCH_INJURIES;
	}

}
