package eg.net.gxt.client.widget.layout.border;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.google.gwt.user.client.ui.Widget;

/**
 * The Class WestAreaWidget.
 */
public class WestAreaWidget extends BorderRegionWidget {

	/**
	 * Instantiates a new west area widget.
	 * 
	 * @param widget
	 *            the widget
	 * @param width
	 *            the width
	 */
	public WestAreaWidget(Widget widget, int size) {
		super(widget, LayoutRegion.WEST, size);
		this.layoutData.setMargins(new Margins(0, 5, 0, 0));
	}

}
