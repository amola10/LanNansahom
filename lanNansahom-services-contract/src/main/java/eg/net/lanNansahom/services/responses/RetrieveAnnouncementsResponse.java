package eg.net.lanNansahom.services.responses;

import java.util.List;

import eg.net.lanNansahom.services.beans.Announcement;
import eg.net.services.ServiceResponse;

public class RetrieveAnnouncementsResponse extends ServiceResponse {

	private List<Announcement> announcements;

	/**
	 * @return the announcements
	 */
	public List<Announcement> getAnnouncements() {
		return announcements;
	}

	/**
	 * @param announcements
	 *            the announcements to set
	 */
	public void setAnnouncements(List<Announcement> announcements) {
		this.announcements = announcements;
	}

}
