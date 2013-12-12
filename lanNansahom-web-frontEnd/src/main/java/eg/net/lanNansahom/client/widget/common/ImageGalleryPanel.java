package eg.net.lanNansahom.client.widget.common;

import java.util.List;

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Image;

import eg.net.lanNansahom.client.Resources;
import eg.net.lanNansahom.client.view.ApplicationView;
import eg.net.lanNansahom.shared.beans.ImageBean;

public class ImageGalleryPanel extends AbstractImagesPanel {

	protected final List<ImageBean> imageBeans;

	public ImageGalleryPanel(List<ImageBean> pImages) {
		super(pImages);
		imageBeans = pImages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.client.widget.common.AbstractImagesPanel#onRender(
	 * com.google.gwt.user.client.Element, int)
	 */
	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);
		panel.setBodyStyleName("grayPanel");
		view.setStyleName("grayPanel");
		panel.insert(createHeader(), 0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.extjs.gxt.ui.client.widget.ScrollContainer#afterRender()
	 */
	@Override
	protected void onLoad() {
		for (ImageBean bean : this.imageBeans) {
			ApplicationView.createImageLightBox((String) bean.get("hrefId"));
		}
	}

	protected ContentPanel createHeader() {
		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);
		panel.setBodyStyleName("grayPanel");
		panel.setStyleAttribute("padding-top", "10px");
		panel.setStyleAttribute("padding-right", "5px");
		Image image = new Image(getHeaderTitle());
		panel.add(image);

		return panel;
	}

	protected ImageResource getHeaderTitle() {
		Resources resources = (Resources) GWT.create(Resources.class);
		return resources.files();
	}

	@Override
	protected void imageSelected(ImageBean imageBean) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.client.widget.common.AbstractImagesPanel#getBaseClass
	 * ()
	 */
	@Override
	protected String getBaseClass() {
		return "thumbGallery";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.client.widget.common.AbstractImagesPanel#prepareFinalData
	 * (eg.net.lanNansahom.shared.beans.ImageBean)
	 */
	@Override
	protected ImageBean prepareFinalData(ImageBean model, int index) {
		ImageBean result = super.prepareFinalData(model, index);
		result.set("hrefId", "href_i" + index);
		return result;
	}

	@Override
	protected native String getTemplate(String pBassClass) /*-{
															return [ '<tpl for=".">', 
															'<div class="'+pBassClass+'-wrap" id="{jsid}" >',
															'<div class="'+pBassClass+'"><a id="{hrefId}" href="{path}"><img src="{path}" title="{description}"></a></div>',
															'</div>', '</tpl>',
															'<div class="x-clear"></div>' ].join("");

															}-*/;

}
