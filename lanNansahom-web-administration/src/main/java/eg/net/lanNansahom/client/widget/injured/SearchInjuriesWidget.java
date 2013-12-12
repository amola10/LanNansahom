package eg.net.lanNansahom.client.widget.injured;

import eg.net.lanNansahom.client.widget.victims.SearchVictimsWidget;

public class SearchInjuriesWidget extends SearchVictimsWidget<SearchInjuriesMask, SearchInjuriesGrid> {

	public SearchInjuriesWidget() {
		super(new SearchInjuriesMask(), new SearchInjuriesGrid());
	}

}
