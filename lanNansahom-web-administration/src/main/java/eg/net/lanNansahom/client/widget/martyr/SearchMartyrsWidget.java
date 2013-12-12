package eg.net.lanNansahom.client.widget.martyr;

import eg.net.lanNansahom.client.widget.victims.SearchVictimsWidget;

public class SearchMartyrsWidget extends SearchVictimsWidget<SearchMartyrsMask, SearchMartyrsGrid> {

	public SearchMartyrsWidget() {
		super(new SearchMartyrsMask(), new SearchMartyrsGrid());
	}

}
