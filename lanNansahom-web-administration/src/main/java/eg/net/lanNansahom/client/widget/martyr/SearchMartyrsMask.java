package eg.net.lanNansahom.client.widget.martyr;

import com.extjs.gxt.ui.client.event.EventType;
import com.google.gwt.core.client.GWT;

import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.widget.victims.SearchVictimsMask;

public class SearchMartyrsMask extends SearchVictimsMask {

	public SearchMartyrsMask() {
		super(constructTitle(), true);
	}

	/**
	 * Constuct title.
	 * 
	 * @return the string
	 */
	private static String constructTitle() {
		Messages messages = GWT.create(Messages.class);
		return messages.martyrs() + "-> " + messages.search();
	}

	@Override
	protected EventType getSearchEvent() {
		return AppEvents.SEARCH_MARTYRS;
	}

}
