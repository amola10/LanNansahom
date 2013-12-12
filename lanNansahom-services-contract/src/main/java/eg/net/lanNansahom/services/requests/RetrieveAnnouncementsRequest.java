package eg.net.lanNansahom.services.requests;

import eg.net.services.ServiceRequest;

public class RetrieveAnnouncementsRequest extends ServiceRequest {

	private boolean onlyPublished = false;

	/**
	 * @return the onlyPublished
	 */
	public boolean isOnlyPublished() {
		return onlyPublished;
	}

	/**
	 * @param onlyPublished
	 *            the onlyPublished to set
	 */
	public void setOnlyPublished(boolean onlyPublished) {
		this.onlyPublished = onlyPublished;
	}

}
