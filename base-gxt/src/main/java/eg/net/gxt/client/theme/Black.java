package eg.net.gxt.client.theme;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.util.Theme;
import com.google.gwt.core.client.GWT;

public class Black extends Theme {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7286723420287201318L;
	public static Theme BLACK = new Black();

	public Black() {
		super("black", "black", "gxt/themes/black/css/xtheme-black.css");
	}

	public Black(String name) {
		super("black", name, "gxt/themes/black/css/xtheme-black.css");
	}

	@Override
	public void init() {
		super.init();
		GXT.IMAGES = GWT.create(BlackImages.class);
	}

}
