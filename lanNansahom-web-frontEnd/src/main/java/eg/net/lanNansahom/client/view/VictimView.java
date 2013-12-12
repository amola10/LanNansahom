package eg.net.lanNansahom.client.view;

import java.util.List;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.reveregroup.gwt.imagepreloader.ImageLoadEvent;
import com.reveregroup.gwt.imagepreloader.ImageLoadHandler;
import com.reveregroup.gwt.imagepreloader.ImagePreloader;

import eg.net.gxt.client.Event;
import eg.net.gxt.client.EventType;
import eg.net.gxt.client.view.BaseView;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.widget.victims.VictimProfile;
import eg.net.lanNansahom.client.widget.victims.VictimsLightBox;
import eg.net.lanNansahom.shared.URLUtility;
import eg.net.lanNansahom.shared.beans.ImageBean;
import eg.net.lanNansahom.shared.beans.ImageCategry;
import eg.net.lanNansahom.shared.beans.VictimBean;

public class VictimView extends BaseView {

	public VictimView(Controller controller) {
		super(controller);
	}

	@Override
	protected void handleEvent(final AppEvent event) {
		switch (event.getType().getEventCode()) {
		case AppEvents.SHOW_VICTIM_DETAILS_EVENT_CODE:
			if (event.getData() instanceof VictimBean) {
				final VictimBean victimBean = (VictimBean) event.getData();
				downloadProfilePicture(victimBean, new DownloadListener() {
					public void imageDownloaded() {
						showContentInCenterArea(new VictimProfile(victimBean), new Event((EventType) event.getType(),
								victimBean.getId()));

					}
				});

			} else {
				Dispatcher.forwardEvent(AppEvents.GO_TO_VICTIM_DETAILS_EVENT, event.getData());
			}

			break;
		case AppEvents.SHOW_VICTIM_DETAILS_IN_LIGHT_BOX_EVENT_CODE:
			final VictimBean victimBean = (VictimBean) event.getData();
			downloadProfilePicture(victimBean, new DownloadListener() {
				public void imageDownloaded() {
					if (RootPanel.get("victimProfile") != null && RootPanel.get("victimProfile").getWidgetCount() > 0) {
						RootPanel.get("victimProfile").remove(0);
					} else {
						ApplicationView.createPanelLightBox("<div id=\"victimProfile\"></div>");
					}
					VictimsLightBox panel = new VictimsLightBox(victimBean);
					RootPanel.get("victimProfile").add(panel);
					ApplicationView.initVictimLightBox();
				}
			});
			break;
		default:
			break;
		}

	}

	private void downloadProfilePicture(VictimBean victimBean, final DownloadListener listener) {
		List<ImageBean> profileImages = victimBean.getImagesByType(ImageCategry.Profile);
		if (profileImages.size() > 0) {
			final String url = URLUtility.getImagesBaseURL() + profileImages.get(0).getUrl();
			ImagePreloader.load(url, new ImageLoadHandler() {
				public void imageLoaded(ImageLoadEvent pEvent) {
					Image.prefetch(url);
					listener.imageDownloaded();
				}
			});
		} else {
			listener.imageDownloaded();
		}
	}

	public interface DownloadListener {
		void imageDownloaded();
	}

}
