package eg.net.lanNansahom.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;

import eg.net.lanNansahom.client.view.ApplicationView;
import eg.net.lanNansahom.shared.beans.AnnouncementBean;
import eg.net.lanNansahom.shared.beans.ImageBean;
import eg.net.lanNansahom.shared.beans.LookupBean;
import eg.net.lanNansahom.shared.beans.VictimInfoBean;
import eg.net.lanNansahom.shared.beans.VideoBean;

/**
 * The Class JSONDataReader.
 */
public class JSONDataReader {

	/**
	 * Load victim images.
	 * 
	 * @param numberOfRecords
	 *            the number of records
	 * @return the list
	 */
	public static List<ImageBean> loadVictimImages(int numberOfRecords) {
		List<ImageBean> result = new ArrayList<ImageBean>();
		List<VictimInfoBean> martyrs = loadMartyrs();
		int counter = 0;
		for (VictimInfoBean martyr : martyrs) {
			if (martyr.getProfileThumbnail() != null) {
				result.add(martyr.getProfileThumbnail());
				counter++;
			}

			if (counter == numberOfRecords) {
				break;
			}
		}
		return result;
	}

	/**
	 * Load martyrs.
	 * 
	 * @return the list
	 */
	public static List<VictimInfoBean> loadMartyrs() {
		return loadVictims(getCashedMartyrs());
	}

	/**
	 * Load injuries.
	 * 
	 * @return the list
	 */
	public static List<VictimInfoBean> loadInjuries() {
		return loadVictims(getCashedInjuries());
	}

	/**
	 * Load announcements.
	 * 
	 * @return the list
	 */
	public static List<AnnouncementBean> loadAnnouncements() {
		List<AnnouncementBean> result = new ArrayList<AnnouncementBean>();
		JSONArray announcements = (JSONArray) JSONParser.parseLenient(getCashedAnnouncments());
		for (int i = 0; announcements != null && i < announcements.size(); i++) {
			JSONObject announcement = (JSONObject) announcements.get(i);
			AnnouncementBean announcementBean = new AnnouncementBean();
			announcementBean.setTitle(URL.decodeQueryString(((JSONString) announcement
					.get(AnnouncementBean.BINDING_TITLE)).stringValue()));
			announcementBean.setText(URL.decodeQueryString(((JSONString) announcement
					.get(AnnouncementBean.BINDING_TEXT)).stringValue()));

			result.add(announcementBean);
		}
		return result;
	}

	/**
	 * Load victims.
	 * 
	 * @param pJson
	 *            the json
	 * @return the list
	 */
	private static List<VictimInfoBean> loadVictims(String pJson) {
		List<VictimInfoBean> result = new ArrayList<VictimInfoBean>();
		JSONArray victims = (JSONArray) JSONParser.parseLenient(pJson);
		for (int i = 0; i < victims.size(); i++) {
			JSONObject victim = (JSONObject) victims.get(i);
			VictimInfoBean victimInfoBean = new VictimInfoBean();
			victimInfoBean.setId(new Integer((int) ((JSONNumber) victim.get(VictimInfoBean.BINDING_ID)).doubleValue()));
			victimInfoBean.setName(((JSONString) victim.get(VictimInfoBean.BINDING_NAME)).stringValue());
			if (victim.get(VictimInfoBean.BINDING_DEATH_AREA) != null) {
				victimInfoBean.setDeathArea(new LookupBean(0, ((JSONString) victim
						.get(VictimInfoBean.BINDING_DEATH_AREA)).stringValue()));
			}
			if (victim.get(VictimInfoBean.BINDING_DEATH_DATE) != null) {
				victimInfoBean.setDeathDate(ApplicationView.parseDate(((JSONString) victim
						.get(VictimInfoBean.BINDING_DEATH_DATE)).stringValue()));
			}
			if (victim.get(VictimInfoBean.BINDING_IMAGE) != null) {
				victimInfoBean.setProfileThumbnail(mapImageBean((JSONObject) victim.get(VictimInfoBean.BINDING_IMAGE),
						victimInfoBean));
			}
			result.add(victimInfoBean);
		}
		return result;
	}

	/**
	 * Map image bean.
	 * 
	 * @param object
	 *            the object
	 * @return the image bean
	 */
	private static ImageBean mapImageBean(JSONObject object, VictimInfoBean victimInfoBean) {
		ImageBean imageBean = new ImageBean();
		imageBean.setUrl(((JSONString) object.get(ImageBean.BINDING_URL)).stringValue());
		imageBean.set(ImageBean.BINDING_VICTIM_ID, victimInfoBean.getId());
		String description = "<b>" + victimInfoBean.getName() + "</b><br/>";
		if (victimInfoBean.getDeathArea() != null) {
			description += victimInfoBean.getDeathArea().getName() + "<br/>";
		}
		if (victimInfoBean.getDeathDate() != null) {
			description += ApplicationView.formateDate(victimInfoBean.getDeathDate()) + "<br/>";
		}
		imageBean.setDescription(description);

		return imageBean;
	}

	/**
	 * Load images.
	 * 
	 * @return the list
	 */
	public static List<ImageBean> loadImages() {
		List<ImageBean> result = new ArrayList<ImageBean>();
		JSONArray images = (JSONArray) JSONParser.parseLenient(getCashedImages());
		for (int i = 0; i < images.size(); i++) {
			JSONObject image = (JSONObject) images.get(i);
			ImageBean imageBean = new ImageBean();
			imageBean.setUrl(((JSONString) image.get(ImageBean.BINDING_URL)).stringValue());
			result.add(imageBean);
		}
		return result;
	}

	/**
	 * Load videos.
	 * 
	 * @return the list
	 */
	public static List<VideoBean> loadVideos() {
		List<VideoBean> result = new ArrayList<VideoBean>();
		JSONArray videos = (JSONArray) JSONParser.parseLenient(getCashedVideos());
		for (int i = 0; i < videos.size(); i++) {
			JSONObject video = (JSONObject) videos.get(i);
			VideoBean videoBean = new VideoBean();
			videoBean.setUrl(((JSONString) video.get(VideoBean.BINDING_URL)).stringValue());

			result.add(videoBean);
		}
		return result;
	}

	/**
	 * Gets the cashed martyrs.
	 * 
	 * @return the cashed martyrs
	 */
	private static native String getCashedMartyrs() /*-{
													return  $wnd.martyrs;
													}-*/;

	/**
	 * Gets the cashed injuries.
	 * 
	 * @return the cashed injuries
	 */
	private static native String getCashedInjuries() /*-{
														return  $wnd.injuries;
														}-*/;

	/**
	 * Gets the cashed announcments.
	 * 
	 * @return the cashed announcments
	 */
	private static native String getCashedAnnouncments() /*-{
															return  $wnd.announcments;
															}-*/;

	/**
	 * Gets the cashed images.
	 * 
	 * @return the cashed images
	 */
	private static native String getCashedImages() /*-{
													return  $wnd.images;
													}-*/;

	/**
	 * Gets the cashed videos.
	 * 
	 * @return the cashed videos
	 */
	private static native String getCashedVideos() /*-{
													return  $wnd.videos;
													}-*/;

}
