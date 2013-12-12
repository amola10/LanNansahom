package eg.net.gxt.client;

import com.extjs.gxt.ui.client.Registry;

import eg.net.gxt.client.widget.MainViewPort;

public class GXTUtil {

	public static void showLoadingMessage() {
		if (getMainView() != null) {
			getMainView().mask("Loading ...");
		}
	}

	public static void showLoadingMessage(String message) {
		if (getMainView() != null) {
			getMainView().mask(message);
		}
	}

	public static void hideLoadingMessage() {
		if (getMainView() != null) {
			getMainView().unmask();
		}
	}

	private static MainViewPort getMainView() {
		return (MainViewPort) Registry.get("MAIN_VIEW");
	}
}
