package eg.net.gxt.client.widget.layout.border;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.google.gwt.user.client.ui.Widget;

/**
 * The Class EastAreaWidget.
 */
public class EastAreaWidget extends BorderRegionWidget {

	/**
	 * Instantiates a new east area widget.
	 * 
	 * @param widget
	 *            the widget
	 * @param width
	 *            the width
	 */
	public EastAreaWidget(Widget widget, int size) {
		super(widget, LayoutRegion.EAST, size);
		this.layoutData.setMargins(new Margins(0, 0, 0, 5));
	}

}
