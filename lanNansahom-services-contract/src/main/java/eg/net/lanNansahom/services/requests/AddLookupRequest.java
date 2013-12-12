package eg.net.lanNansahom.services.requests;

import eg.net.lanNansahom.services.beans.Lookup;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.services.ServiceRequest;

public class AddLookupRequest extends ServiceRequest {

	private Lookup lookup;

	private LookupType lookupType;

	/**
	 * @return the lookup
	 */
	public Lookup getLookup() {
		return lookup;
	}

	/**
	 * @param lookup
	 *            the lookup to set
	 */
	public void setLookup(Lookup lookup) {
		this.lookup = lookup;
	}

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
