package eg.net.lanNansahom.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {

	@Source("add.png")
	ImageResource add();

	@Source("delete.png")
	ImageResource remove();

	@Source("edit.png")
	ImageResource edit();

	@Source("excel.png")
	ImageResource excel();

	@Source("email.png")
	ImageResource email();

}
