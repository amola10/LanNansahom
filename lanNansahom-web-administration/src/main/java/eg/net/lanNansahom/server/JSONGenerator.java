package eg.net.lanNansahom.server;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import eg.net.lanNansahom.services.beans.Announcement;
import eg.net.lanNansahom.services.beans.Image;
import eg.net.lanNansahom.services.beans.ImageCategry;
import eg.net.lanNansahom.services.beans.Victim;
import eg.net.lanNansahom.shared.beans.AnnouncementBean;
import eg.net.lanNansahom.shared.beans.ImageBean;
import eg.net.lanNansahom.shared.beans.VictimInfoBean;
import eg.net.services.ServiceException;

/**
 * The Class JSONDataWriter.
 */
public class JSONGenerator {

	/**
	 * Write victims.
	 * 
	 * @param javascriptVarName
	 *            the javascript var name
	 * @param pVictims
	 *            the victims
	 * @return the string
	 * @throws ServiceException
	 *             the service exception
	 */
	public String generateVictims(String javascriptVarName, List<Victim> pVictims) throws ServiceException {
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
			JSONArray array = new JSONArray();
			for (Victim victim : pVictims) {
				JSONObject object = new JSONObject();

				object.put(VictimInfoBean.BINDING_ID, victim.getId());
				object.put(VictimInfoBean.BINDING_NAME, victim.getName());
				if (victim.getDeathArea() != null) {
					object.put(VictimInfoBean.BINDING_DEATH_AREA, victim.getDeathArea().getName());
				}
				if (victim.getDeathDate() != null) {
					object.put(VictimInfoBean.BINDING_DEATH_DATE, format.format(victim.getDeathDate()));
				}
				Image image = getThumbnailImage(victim);
				if (image != null) {
					JSONObject imageObject = new JSONObject();
					imageObject.put(ImageBean.BINDING_ID, image.getId());
					imageObject.put(ImageBean.BINDING_VICTIM_ID, victim.getId());
					imageObject.put(ImageBean.BINDING_URL, image.getUrl());
					object.put(VictimInfoBean.BINDING_IMAGE, imageObject);

				}

				array.put(object);
			}
			String result = "var " + javascriptVarName + " ='" + array.toString() + "';";
			return result;
		} catch (JSONException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Write announcements.
	 * 
	 * @param pTargetPath
	 *            the target path
	 * @param javascriptVarName
	 *            the javascript var name
	 * @param pAnnouncements
	 *            the announcements
	 * @throws ServiceException
	 */
	public String generateAnnouncements(String javascriptVarName, List<Announcement> pAnnouncements)
			throws ServiceException {
		try {
			JSONArray array = new JSONArray();
			for (Announcement announcement : pAnnouncements) {
				JSONObject object = new JSONObject();
				object.put(AnnouncementBean.BINDING_TITLE, URLEncoder.encode(announcement.getTitle(), "UTF-8"));
				object.put(AnnouncementBean.BINDING_TEXT, URLEncoder.encode(announcement.getText(), "UTF-8"));
				array.put(object);
			}
			String result = "var " + javascriptVarName + " ='" + array.toString() + "';";
			return result;
		} catch (JSONException e) {
			throw new ServiceException(e);
		} catch (UnsupportedEncodingException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Gets the thumbnail image.
	 * 
	 * @param victim
	 *            the victim
	 * @return the thumbnail image
	 */
	private Image getThumbnailImage(Victim victim) {
		Image result = null;
		for (Image image : victim.getImages()) {
			if (ImageCategry.Thumbnail.getId() == image.getCategory().getId()) {
				result = image;
				break;
			}
		}
		return result;
	}

}
