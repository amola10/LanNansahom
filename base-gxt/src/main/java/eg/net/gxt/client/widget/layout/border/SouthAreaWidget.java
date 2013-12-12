package eg.net.gxt.client.widget.layout.border;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.google.gwt.user.client.ui.Widget;

/**
 * The Class SouthAreaWidget.
 */
public class SouthAreaWidget extends BorderRegionWidget {

	/**
	 * Instantiates a new south area widget.
	 * 
	 * @param widget
	 *            the widget
	 * @param width
	 *            the width
	 */
	public SouthAreaWidget(Widget widget, int size) {
		super(widget, LayoutRegion.SOUTH, size);
		this.layoutData.setFloatable(true);
		this.layoutData.setMargins(new Margins(5, 0, 0, 0));
	}

}
