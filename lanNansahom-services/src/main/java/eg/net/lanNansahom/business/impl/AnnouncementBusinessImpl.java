package eg.net.lanNansahom.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.lanNansahom.business.AnnouncementBusiness;
import eg.net.lanNansahom.dao.AnnouncementDao;
import eg.net.lanNansahom.services.beans.Announcement;
import eg.net.services.BeansMapper;
import eg.net.services.ServiceException;

/**
 * The Class AnnouncementBusinessImpl.
 */
public class AnnouncementBusinessImpl implements AnnouncementBusiness {

	/** The announcement dao. */
	@Autowired
	private AnnouncementDao announcementDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.business.AnnouncementBusiness#addAnnouncement(eg.net
	 * .lanNansahom.services.beans.Announcement)
	 */
	public void addAnnouncement(Announcement announcement) throws ServiceException {
		announcementDao.addAnnouncement(BeansMapper.map(announcement, eg.net.lanNansahom.datamodel.Announcement.class));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.business.AnnouncementBusiness#updteAnnouncement(eg
	 * .net.lanNansahom.services.beans.Announcement)
	 */
	public void updteAnnouncement(Announcement announcement) throws ServiceException {
		eg.net.lanNansahom.datamodel.Announcement originalAnnouncement = announcementDao
				.getAnnouncementById(announcement.getId());
		announcementDao.updteAnnouncement(BeansMapper.map(announcement, originalAnnouncement,
				eg.net.lanNansahom.datamodel.Announcement.class));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.business.AnnouncementBusiness#getAllAnnouncement()
	 */
	public List<Announcement> getAllAnnouncement() throws ServiceException {
		List<eg.net.lanNansahom.datamodel.Announcement> announcements = announcementDao.getAllAnnouncement();
		return BeansMapper.map(announcements, eg.net.lanNansahom.services.beans.Announcement.class);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.business.AnnouncementBusiness#getPublishedAnnouncement
	 * ()
	 */
	public List<Announcement> getPublishedAnnouncement() throws ServiceException {
		List<eg.net.lanNansahom.datamodel.Announcement> announcements = announcementDao.getPublishedAnnouncement();
		return BeansMapper.map(announcements, eg.net.lanNansahom.services.beans.Announcement.class);
	}

}
