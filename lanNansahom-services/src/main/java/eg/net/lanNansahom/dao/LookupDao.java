package eg.net.lanNansahom.dao;

import java.util.List;

import eg.net.lanNansahom.datamodel.Lookup;

/**
 * The Interface LookupDao.
 */
public interface LookupDao {

	/**
	 * Gets the all.
	 * 
	 * @param lookupClazz
	 *            the lookup clazz
	 * @return the all
	 */
	public List<? extends Lookup> getAll(Class<? extends Lookup> lookupClazz);

	public Lookup getLookupById(Class<? extends Lookup> clazz, int id);

	public void addLookup(Lookup lookup);

	public void updateLookup(Lookup lookup);

}
