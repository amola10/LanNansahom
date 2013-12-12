package eg.net.lanNansahom.client.widget.victims;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.El.VisMode;
import com.extjs.gxt.ui.client.fx.FxConfig;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.reveregroup.gwt.imagepreloader.ImageLoadEvent;
import com.reveregroup.gwt.imagepreloader.ImageLoadHandler;
import com.reveregroup.gwt.imagepreloader.ImagePreloader;

import eg.net.gxt.client.ClientExceptionHandler;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.CustomGXTUtil;
import eg.net.lanNansahom.client.JSONDataReader;
import eg.net.lanNansahom.shared.URLUtility;
import eg.net.lanNansahom.shared.beans.ImageBean;

public class FadingVictimImagesPanel extends VictimImagesPanel {

	private static final int NUMBER_OF_IMAGES = 91;
	private final List<String> downloadedImages = new ArrayList<String>();

	public FadingVictimImagesPanel() {
		super(JSONDataReader.loadVictimImages(NUMBER_OF_IMAGES), false);
		setScrollMode(Scroll.AUTO);
	}

	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);
		view.setStyleAttribute("overflow", "hidden");
		view.setVisible(false);
		view.setStyleName("scrollPane", false);
	}

	/**
	 * Fade image list.
	 * 
	 * @param view
	 *            the view
	 */
	public void fadeImageList(final FadingListener listener) {
		downloadImages(listener);
	}

	private void downloadImages(final FadingListener listener) {
		CustomGXTUtil.showLoading();
		for (int i = 0; i < store.getCount(); i++) {
			final ImageBean bean = store.getAt(i);
			ImagePreloader.load(URLUtility.getImagesBaseURL() + bean.getUrl(), new ImageLoadHandler() {
				public void imageLoaded(ImageLoadEvent event) {
					downloadedImages.add("done");
					if (downloadedImages.size() == NUMBER_OF_IMAGES) {
						CustomGXTUtil.hideLoading();
						GWT.runAsync(new RunAsyncCallback() {
							public void onSuccess() {
								initLibraries();

							}

							public void onFailure(Throwable reason) {
								ClientExceptionHandler handler = new ClientExceptionHandler();
								handler.handlerException(reason);
							}
						});
						startFadding(listener);
					}

				}
			});

		}

	}

	private static native void initLibraries() /*-{
		$wnd.initLibraries();
	}-*/;

	private void startFadding(final FadingListener listener) {
		Timer timer = new Timer() {

			private int counter = 0;

			@Override
			public void run() {
				if (counter == 0) {
					view.setVisible(true);
					// File List & Hide Images
					for (int i = 0; i < store.getCount(); i++) {
						El image = getElById("image_" + i);
						if (image != null) {
							image.setVisibilityMode(VisMode.VISIBILITY);
							image.setVisibility(false);
						}
					}
					counter++;
				} else if (counter == (NUMBER_OF_IMAGES - 10)) {
					for (int i = 0; i < store.getCount(); i++) {
						El image = getElById("image_" + i);
						image.setStyleAttribute("opacity", "1");
						if (image != null && image.isVisible() == false)
							image.setVisibility(true);
					}

					cancel();
					listener.faddingFinishd();
				} else {
					int number = Random.nextInt(store.getCount());
					El image = getElById("image_" + number);
					if (image != null && image.isVisible() == false) {
						image.setVisibility(true);
						image.fadeIn(FxConfig.NONE);
						counter++;
					}
				}

			}
		};
		timer.scheduleRepeating(30);

	}

	public interface FadingListener {
		void faddingFinishd();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.client.widget.victims.VictimImagesPanel#imageSelected
	 * (eg.net.lanNansahom.shared.beans.ImageBean)
	 */
	@Override
	protected void imageSelected(ImageBean imageBean) {
		super.imageSelected(imageBean);
		Dispatcher.forwardEvent(AppEvents.LEAVE_HOME_PAGE_EVENT);
	}

}
