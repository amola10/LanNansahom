package eg.net.lanNansahom.services.requests;

import eg.net.lanNansahom.services.beans.Victim;
import eg.net.services.ServiceRequest;

/**
 * The Class AddMartyrRequest.
 */
public class AddVictimRequest extends ServiceRequest {

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
