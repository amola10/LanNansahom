package eg.net.lanNansahom.services.requests;

import javax.xml.bind.annotation.XmlRootElement;

import eg.net.services.ServiceRequest;

@XmlRootElement(name = "RetrieveVictimRequest")
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
