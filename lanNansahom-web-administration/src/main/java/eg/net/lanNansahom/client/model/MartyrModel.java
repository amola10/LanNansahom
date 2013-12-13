package eg.net.lanNansahom.client.model;

import com.extjs.gxt.ui.client.event.EventType;

import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.shared.beans.MartyrBean;
import eg.net.lanNansahom.shared.beans.SearchVictimsBean;

public class MartyrModel extends VictimModel {

	private static final long serialVersionUID = -268322299914915857L;

	public MartyrModel() {
		this.searchStatus.setMartyr(true);
	}

	public void addMartyr(MartyrBean data) {
		this.addVictim(data);

	}

	public void updateMartyr(MartyrBean data) {
		this.updateVictim(data);
	}

	public void searchMartyrs(SearchVictimsBean searchVictimsBean) {
		this.searchVictims(searchVictimsBean);

	}

	public void deleteMartyr(MartyrBean martyrBean) {
		this.deleteVictim(martyrBean);
	}

	public void generatePublishedMartyrs() {
		this.generateVictims(true);
	}

	@Override
	protected EventType getSearchEvent() {
		return AppEvents.SEARCH_MARTYRS;
	}

	@Override
	protected EventType getRefreshSearchResultEvent() {
		return AppEvents.REFRESH_MARTYRS;
	}

	@Override
	protected EventType getGoToSearchEvent() {
		return AppEvents.GO_TO_SEARCH_MARTYRS;
	}

}
