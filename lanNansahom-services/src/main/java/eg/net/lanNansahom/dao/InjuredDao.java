package eg.net.lanNansahom.dao;

import java.util.List;

import eg.net.lanNansahom.datamodel.Injured;
import eg.net.lanNansahom.datamodel.SearchVictimsCriteria;

/**
 * The Interface InjuredDao.
 */
public interface InjuredDao {

	/**
	 * Adds the injured.
	 * 
	 * @param Injured
	 *            the injured
	 */
	public void addInjured(Injured injured);

	/**
	 * Update injured.
	 * 
	 * @param Injured
	 *            the injured
	 */
	public void updateInjured(Injured injured);

	/**
	 * Delete injured.
	 * 
	 * @param injured
	 *            the injured
	 */
	public void deleteInjured(Injured injured);

	/**
	 * Gets the injured by id.
	 * 
	 * @param id
	 *            the id
	 * @return the injured by id
	 */
	public Injured getInjuredById(int id);

	/**
	 * Search injured.
	 * 
	 * @param name
	 *            the name
	 * @param areaId
	 *            the area id
	 * @param age
	 *            the age
	 * @return the list
	 */
	public List<Injured> searchInjured(SearchVictimsCriteria criteria);
}
