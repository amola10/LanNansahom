package eg.net.gxt.client.widget.layout.border;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.google.gwt.user.client.ui.Widget;

/**
 * The Class NorthAreaWidget.
 */
public class NorthAreaWidget extends BorderRegionWidget {

	/**
	 * Instantiates a new north area widget.
	 * 
	 * @param widget
	 *            the widget
	 * @param width
	 *            the width
	 */
	public NorthAreaWidget(Widget widget, int size) {
		this(widget);
		this.layoutData.setSize(size);
	}

	/**
	 * Instantiates a new north area widget.
	 * 
	 * @param widget
	 *            the widget
	 * @param width
	 *            the width
	 */
	public NorthAreaWidget(Widget widget) {
		super(widget, LayoutRegion.NORTH);
		this.layoutData.setMargins(new Margins(0, 0, 5, 0));
		this.layoutData.setFloatable(true);
		this.layoutData.setHideCollapseTool(true);
	}

}
