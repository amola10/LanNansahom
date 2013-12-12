package eg.net.lanNansahom.client.model;

import com.extjs.gxt.ui.client.event.EventType;

import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.shared.beans.InjuredBean;
import eg.net.lanNansahom.shared.beans.SearchVictimsBean;

public class InjuredModel extends VictimModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5208692560952808937L;

	public InjuredModel() {
		this.searchStatus.setMartyr(false);
	}

	public void addInjured(InjuredBean data) {
		this.addVictim(data);

	}

	public void updateInjured(InjuredBean data) {
		this.updateVictim(data);

	}

	public void searchInjuries(SearchVictimsBean searchVictimsBean) {
		this.searchVictims(searchVictimsBean);
	}

	public void deleteInjured(InjuredBean injuredBean) {
		this.deleteVictim(injuredBean);
	}

	@Override
	protected EventType getSearchEvent() {
		return AppEvents.SEARCH_INJURIES;
	}

	@Override
	protected EventType getRefreshSearchResultEvent() {
		return AppEvents.REFRESH_INJURIES;
	}

	@Override
	protected EventType getGoToSearchEvent() {
		return AppEvents.GO_TO_SEARCH_INJURIES;
	}

}
