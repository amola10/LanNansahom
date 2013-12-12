package eg.net.lanNansahom.dao;

import java.util.List;

import eg.net.lanNansahom.datamodel.Martyr;
import eg.net.lanNansahom.datamodel.SearchVictimsCriteria;

/**
 * The Interface MartyrDao.
 */
public interface MartyrDao {

	/**
	 * Adds the martyr.
	 * 
	 * @param martyr
	 *            the martyr
	 */
	public void addMartyr(Martyr martyr);

	/**
	 * Updte martyr.
	 * 
	 * @param martyr
	 *            the martyr
	 */
	public void updateMartyr(Martyr martyr);

	/**
	 * Delete martyr.
	 * 
	 * @param martyr
	 *            the martyr
	 */
	public void deleteMartyr(Martyr martyr);

	/**
	 * Gets the martyr by id.
	 * 
	 * @param id
	 *            the id
	 * @return the martyr by id
	 */
	public Martyr getMartyrById(int id);

	/**
	 * Search martyr.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return the list
	 */
	public List<Martyr> searchMartyr(SearchVictimsCriteria criteria);

}
