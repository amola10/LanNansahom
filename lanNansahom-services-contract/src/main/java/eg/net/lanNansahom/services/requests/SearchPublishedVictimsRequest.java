package eg.net.lanNansahom.services.requests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@XmlRootElement(name = "SearchPublishedVictimsRequest")
public class SearchPublishedVictimsRequest extends SearchVictimsRequest {

	private static SimpleDateFormat format = new SimpleDateFormat();

	/** Deserializes an Object of class MyClass from its JSON representation */
	public static SearchPublishedVictimsRequest fromString(String jsonRepresentation) {
		SearchPublishedVictimsRequest result = new SearchPublishedVictimsRequest();
		try {
			JSONObject object = new JSONObject(jsonRepresentation);
			if (!object.isNull("partnerId"))
				result.setPartnerId(object.getInt("partnerId"));
			if (!object.isNull("age"))
				result.setAge(object.getInt("age"));
			if (!object.isNull("date"))
				result.setDate(format.parse(object.getString("date")));
			if (!object.isNull("educationId"))
				result.setEducationId(object.getInt("educationId"));
			if (!object.isNull("jobId"))
				result.setJobId(object.getInt("jobId"));
			if (!object.isNull("areaId"))
				result.setAreaId(object.getInt("areaId"));
			if (!object.isNull("name"))
				result.setName(object.getString("name"));
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		JSONObject object = new JSONObject();
		try {
			object.put("partnerId", getPartnerId());
			object.put("age", getAge());
			if (getDate() != null)
				object.put("date", format.format(getDate()));
			object.put("educationId", getEducationId());
			object.put("jobId", getJobId());
			object.put("areaId", getAreaId());
			object.put("name", getName());

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}
}
