package eg.net.lanNansahom.services.requests;

import eg.net.services.ServiceRequest;

public class RetrieveVictimRequest extends ServiceRequest {

	private int id;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
