package eg.net.lanNansahom.services.responses;

import eg.net.lanNansahom.services.beans.Victim;
import eg.net.services.ServiceResponse;

public class RetrieveVictimResponse extends ServiceResponse {
	private Victim victim;

	/**
	 * @return the victim
	 */
	public Victim getVictim() {
		return victim;
	}

	/**
	 * @param victim
	 *            the victim to set
	 */
	public void setVictim(Victim victim) {
		this.victim = victim;
	}

}
