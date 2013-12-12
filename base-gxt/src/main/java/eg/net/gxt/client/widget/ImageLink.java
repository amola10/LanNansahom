package eg.net.gxt.client.widget;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

public class ImageLink extends Image {

	public ImageLink() {
		super();
		setCursorStyle();
	}

	public ImageLink(ImageResource resource) {
		super(resource);
		setCursorStyle();
	}

	private void setCursorStyle() {
		setStyleName("imageLink");
	}
}
