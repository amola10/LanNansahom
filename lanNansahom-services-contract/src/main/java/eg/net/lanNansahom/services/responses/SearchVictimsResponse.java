package eg.net.lanNansahom.services.responses;

import java.util.List;

import eg.net.lanNansahom.services.beans.Victim;
import eg.net.services.ServiceResponse;

public class SearchVictimsResponse extends ServiceResponse {

	List<Victim> victims;

	/**
	 * @return the victims
	 */
	public List<Victim> getVictims() {
		return victims;
	}

	/**
	 * @param victims
	 *            the victims to set
	 */
	public void setVictims(List<Victim> victims) {
		this.victims = victims;
	}

}
