package eg.net.lanNansahom.dao;

import java.util.List;

import eg.net.lanNansahom.datamodel.Announcement;

public interface AnnouncementDao {

	public void addAnnouncement(Announcement announcement);

	public void updteAnnouncement(Announcement announcement);

	public Announcement getAnnouncementById(int id);

	public List<Announcement> getAllAnnouncement();

	public List<Announcement> getPublishedAnnouncement();
}
