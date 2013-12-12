package eg.net.lanNansahom.services.responses;

import java.util.List;

import eg.net.lanNansahom.services.beans.VictimInfo;
import eg.net.services.ServiceResponse;

public class SearchPublishedVictimsResponse extends ServiceResponse {

	List<VictimInfo> victims;

	/**
	 * @return the victims
	 */
	public List<VictimInfo> getVictims() {
		return victims;
	}

	/**
	 * @param victims
	 *            the victims to set
	 */
	public void setVictims(List<VictimInfo> victims) {
		this.victims = victims;
	}

}
