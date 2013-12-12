package eg.net.lanNansahom.business;

import java.util.List;

import eg.net.lanNansahom.services.beans.Announcement;
import eg.net.services.ServiceException;

/**
 * The Interface AnnouncementBusiness.
 */
public interface AnnouncementBusiness {

	/**
	 * Adds the announcement.
	 * 
	 * @param announcement
	 *            the announcement
	 */
	public void addAnnouncement(Announcement announcement) throws ServiceException;

	/**
	 * Updte announcement.
	 * 
	 * @param announcement
	 *            the announcement
	 */
	public void updteAnnouncement(Announcement announcement) throws ServiceException;

	/**
	 * Gets the all announcement.
	 * 
	 * @return the all announcement
	 */
	public List<Announcement> getAllAnnouncement() throws ServiceException;

	/**
	 * Gets the published announcement.
	 * 
	 * @return the published announcement
	 */
	public List<Announcement> getPublishedAnnouncement() throws ServiceException;
}
