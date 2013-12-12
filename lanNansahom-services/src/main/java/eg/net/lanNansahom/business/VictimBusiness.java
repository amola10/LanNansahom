package eg.net.lanNansahom.business;

import java.util.List;

import eg.net.lanNansahom.datamodel.SearchVictimsCriteria;
import eg.net.lanNansahom.services.beans.Victim;
import eg.net.lanNansahom.services.beans.VictimInfo;
import eg.net.services.ServiceException;

/**
 * The Interface VictimBusiness.
 */
public interface VictimBusiness {

	/**
	 * Adds the victim.
	 * 
	 * @param victim
	 *            the victim
	 * @throws ServiceException
	 *             the service exception
	 */
	public void addVictim(Victim victim) throws ServiceException;

	/**
	 * Update victim.
	 * 
	 * @param victim
	 *            the victim
	 * @throws ServiceException
	 *             the service exception
	 */
	public void updateVictim(Victim victim) throws ServiceException;

	/**
	 * Search victim.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return the list
	 * @throws ServiceException
	 *             the service exception
	 */
	public List<Victim> searchVictim(SearchVictimsCriteria criteria) throws ServiceException;

	/**
	 * Search victim info.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return the list
	 * @throws ServiceException
	 *             the service exception
	 */
	public List<VictimInfo> searchVictimInfo(SearchVictimsCriteria criteria) throws ServiceException;

	/**
	 * Delete victims.
	 * 
	 * @param victim
	 *            the victim
	 * @throws ServiceException
	 *             the service exception
	 */
	public void deleteVictims(Victim victim) throws ServiceException;

	/**
	 * Gets the victim by id.
	 * 
	 * @param pId
	 *            the id
	 * @return the victim by id
	 * @throws ServiceException
	 *             the service exception
	 */
	public Victim getVictimById(int pId) throws ServiceException;
}
