package eg.net.lanNansahom.client.widget.common;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;

import eg.net.lanNansahom.client.Resources;
import eg.net.lanNansahom.client.view.ApplicationView;
import eg.net.lanNansahom.shared.beans.ImageBean;
import eg.net.lanNansahom.shared.beans.VideoBean;

public class VideosGallery extends ImageGalleryPanel {

	private static final String VIDEO_THUMBNAILS_URL = "http://i1.ytimg.com/vi/VID/default.jpg";
	private static final String VIDEO_URL = "http://www.youtube.com/watch?v=VID&feature=player_embedded";

	public VideosGallery(List<VideoBean> videos) {
		super(prepareThumnails(videos));
	}

	private static List<ImageBean> prepareThumnails(List<VideoBean> videos) {
		List<ImageBean> result = new ArrayList<ImageBean>();
		for (VideoBean videoBean : videos) {
			ImageBean imageBean = new ImageBean();
			imageBean.setUrl(videoBean.getUrl());
			imageBean.set("path", VIDEO_THUMBNAILS_URL.replaceFirst("VID", videoBean.getUrl()));
			result.add(imageBean);
		}
		return result;
	}

	@Override
	protected ImageResource getHeaderTitle() {
		Resources resources = (Resources) GWT.create(Resources.class);
		return resources.videos();
	}

	@Override
	protected void onLoad() {
		for (ImageBean bean : this.imageBeans) {
			ApplicationView.createVideoLightBox((String) bean.get("hrefId"));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.client.widget.common.ImageGalleryPanel#getBaseClass()
	 */
	@Override
	protected String getBaseClass() {
		return "thumbVideo";
	}

	@Override
	protected ImageBean prepareFinalData(ImageBean model, int index) {
		ImageBean result = super.prepareFinalData(model, index);
		String url = VIDEO_URL.replaceFirst("VID", model.getUrl());
		result.set("videoPath", url);
		result.set("hrefId", "href_v" + index);
		return result;
	}

	@Override
	protected native String getTemplate(String pBassClass) /*-{
															return [ '<tpl for=".">', 
															'<div class="'+pBassClass+'-wrap" id="{jsid}" >',
															'<div class="'+pBassClass+'"><a id="{hrefId}" href="{videoPath}"><img src="{path}" title="{description}"></a></div>',
															'</div>', '</tpl>',
															'<div class="x-clear"></div>' ].join("");

															}-*/;

}
