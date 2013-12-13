package eg.net.lanNansahom.server;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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

/**
 * The Class JSONDataWriter.
 */
public class JSONDataWriter {

	/**
	 * Write victims.
	 * 
	 * @param pTargetPath
	 *            the target path
	 * @param javascriptVarName
	 *            the javascript var name
	 * @param pVictims
	 *            the victims
	 */
	public void writeVictims(String pTargetPath, String javascriptVarName, List<Victim> pVictims) {
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
			String fileContent = "var " + javascriptVarName + " ='" + array.toString() + "';";
			sotreFile(pTargetPath, fileContent);
		} catch (JSONException e) {
			e.printStackTrace();
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
	 */
	public void writeAnnouncements(String pTargetPath, String javascriptVarName, List<Announcement> pAnnouncements) {
		try {
			JSONArray array = new JSONArray();
			for (Announcement announcement : pAnnouncements) {
				JSONObject object = new JSONObject();
				object.put(AnnouncementBean.BINDING_TITLE, URLEncoder.encode(announcement.getTitle(), "UTF-8"));
				object.put(AnnouncementBean.BINDING_TEXT, URLEncoder.encode(announcement.getText(), "UTF-8"));
				array.put(object);
			}
			String fileContent = "var " + javascriptVarName + " ='" + array.toString() + "';";
			sotreFile(pTargetPath, fileContent);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
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

	/**
	 * Sotre file.
	 * 
	 * @param pTargetPath
	 *            the target path
	 * @param fileContent
	 *            the file content
	 */
	private static void sotreFile(String pTargetPath, String fileContent) {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pTargetPath), "UTF8"));
			bufferedWriter.write(fileContent);
			bufferedWriter.flush();
		} catch (Exception e) {
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e1) {
				}
			}

		}
	}

}
