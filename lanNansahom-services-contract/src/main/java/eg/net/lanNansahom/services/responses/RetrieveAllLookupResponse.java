package eg.net.lanNansahom.services.responses;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

import eg.net.lanNansahom.services.beans.LookupList;
import eg.net.services.ServiceResponse;

@XmlRootElement(name = "RetrieveAllLookupResponse")
public class RetrieveAllLookupResponse extends ServiceResponse {

	private HashMap<String, LookupList> lookups = new HashMap<String, LookupList>();

	public RetrieveAllLookupResponse() {
		super();
	}

	/**
	 * @return the lookups
	 */
	public HashMap<String, LookupList> getLookups() {
		return lookups;
	}

	/**
	 * @param lookups
	 *            the lookups to set
	 */
	public void setLookups(HashMap<String, LookupList> lookups) {
		this.lookups = lookups;
	}

}
