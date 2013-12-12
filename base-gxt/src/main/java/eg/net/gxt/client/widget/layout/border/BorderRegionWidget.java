package eg.net.gxt.client.widget.layout.border;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.user.client.ui.Widget;

/**
 * The Class BorderRegionWidget.
 */
public class BorderRegionWidget {

	/** The widget. */
	protected Widget widget;

	/** The layout data. */
	protected final BorderLayoutData layoutData;

	/**
	 * Instantiates a new border region widget.
	 * 
	 * @param widget
	 *            the widget
	 * @param region
	 *            the region
	 */
	public BorderRegionWidget(Widget widget, LayoutRegion region) {
		super();
		this.widget = widget;
		this.layoutData = new BorderLayoutData(region);
		this.layoutData.setSplit(true);
		this.layoutData.setCollapsible(true);
	}

	/**
	 * Instantiates a new border region widget.
	 * 
	 * @param widget
	 *            the widget
	 * @param region
	 *            the region
	 * @param width
	 *            the width
	 */
	public BorderRegionWidget(Widget widget, LayoutRegion region, int size) {
		this(widget, region);
		this.layoutData.setSize(size);
	}

	/**
	 * Gets the widget.
	 * 
	 * @return the widget
	 */
	public Widget getWidget() {
		return widget;
	}

	/**
	 * Gets the border layout data.
	 * 
	 * @return the border layout data
	 */
	public BorderLayoutData getBorderLayoutData() {
		return layoutData;
	}

}
