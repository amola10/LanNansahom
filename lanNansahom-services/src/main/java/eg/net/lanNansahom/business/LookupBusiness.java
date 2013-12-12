package eg.net.lanNansahom.business;

import java.util.HashMap;
import java.util.List;

import eg.net.lanNansahom.services.beans.Lookup;
import eg.net.lanNansahom.services.beans.LookupList;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.services.ServiceException;

/**
 * The Interface LookupBusiness.
 */
public interface LookupBusiness {

	/**
	 * Retrieve all lookup.
	 * 
	 * @return the hash map
	 * @throws ServiceException
	 *             the service exception
	 */
	public HashMap<String, LookupList> retrieveAllLookup() throws ServiceException;

	public void addLookup(LookupType lookupType, Lookup lookup);

	public void updateLookup(LookupType lookupType, Lookup lookup);

	public List<Lookup> searchLookup(LookupType lookupType);
}
