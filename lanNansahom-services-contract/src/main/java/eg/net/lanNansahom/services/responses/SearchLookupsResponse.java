package eg.net.lanNansahom.services.responses;

import java.util.List;

import eg.net.lanNansahom.services.beans.Lookup;
import eg.net.services.ServiceResponse;

public class SearchLookupsResponse extends ServiceResponse {

	private List<Lookup> lookups;

	/**
	 * @return the lookups
	 */
	public List<Lookup> getLookups() {
		return lookups;
	}

	/**
	 * @param lookups
	 *            the lookups to set
	 */
	public void setLookups(List<Lookup> lookups) {
		this.lookups = lookups;
	}

}
