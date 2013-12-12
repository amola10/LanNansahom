package eg.net.lanNansahom.services.requests;

import eg.net.lanNansahom.services.beans.Announcement;
import eg.net.services.ServiceRequest;

public class AddAnnouncementRequest extends ServiceRequest {

	private Announcement announcement;

	/**
	 * @return the announcement
	 */
	public Announcement getAnnouncement() {
		return announcement;
	}

	/**
	 * @param announcement
	 *            the announcement to set
	 */
	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

}
