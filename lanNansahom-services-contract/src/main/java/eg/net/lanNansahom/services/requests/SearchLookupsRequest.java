package eg.net.lanNansahom.services.requests;

import eg.net.lanNansahom.shared.LookupType;
import eg.net.services.ServiceRequest;

public class SearchLookupsRequest extends ServiceRequest {

	private LookupType lookupType;

	/**
	 * @return the lookupType
	 */
	public LookupType getLookupType() {
		return lookupType;
	}

	/**
	 * @param lookupType
	 *            the lookupType to set
	 */
	public void setLookupType(LookupType lookupType) {
		this.lookupType = lookupType;
	}

}
