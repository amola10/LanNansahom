package eg.net.lanNansahom.client;

import com.google.gwt.user.client.ui.RootPanel;

import eg.net.gxt.client.GXTUtil;

public class CustomGXTUtil extends GXTUtil {

	public static void showLoading() {
		showHideLoading(true);
	}

	public static void hideLoading() {
		showHideLoading(false);
	}

	private static void showHideLoading(boolean pVisible) {
		RootPanel panel = RootPanel.get("fancybox-loading");
		if (panel != null) {
			panel.getElement().getStyle().setProperty("display", pVisible ? "" : "none");
		}
	}

}
