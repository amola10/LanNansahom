package eg.net.gxt.client.widget.layout.border;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.google.gwt.user.client.ui.Widget;

/**
 * The Class CenterAreaWidget.
 */
public class CenterAreaWidget extends BorderRegionWidget {

	/**
	 * Instantiates a new center area widget.
	 * 
	 * @param widget
	 *            the widget
	 */
	public CenterAreaWidget(Widget widget) {
		super(widget, LayoutRegion.CENTER);
		this.layoutData.setMargins(new Margins(0));
	}

	public void setWidget(Widget widget) {
		this.widget = widget;

	}

}
