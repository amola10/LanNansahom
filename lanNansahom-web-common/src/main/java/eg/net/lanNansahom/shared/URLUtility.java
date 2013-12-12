package eg.net.lanNansahom.shared;

import com.google.gwt.user.client.Window;

public class URLUtility {

	private static final boolean cloudMode = true;

	public static String getImagesBaseURL() {
		String result = null;
		if (cloudMode)
			result = getCloudStoreURL();
		else
			result = getStandaloneBaseURL();
		return result + "images/";
	}

	public static String getJsonDataBaseURL() {
		String result = null;
		if (cloudMode)
			result = getCloudStoreURL();
		else
			result = getStandaloneBaseURL();
		return result + "data/";
	}

	private static String getStandaloneBaseURL() {
		return "http://" + Window.Location.getHost();
	}

	private static String getCloudStoreURL() {
		return "http://commondatastorage.googleapis.com/lannansahom/";
	}
}
