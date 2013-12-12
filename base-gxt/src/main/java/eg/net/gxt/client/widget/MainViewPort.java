package eg.net.gxt.client.widget;

import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.google.gwt.user.client.Element;

import eg.net.gxt.client.widget.layout.border.CenterAreaWidget;
import eg.net.gxt.client.widget.layout.border.EastAreaWidget;
import eg.net.gxt.client.widget.layout.border.NorthAreaWidget;
import eg.net.gxt.client.widget.layout.border.SouthAreaWidget;
import eg.net.gxt.client.widget.layout.border.WestAreaWidget;

/**
 * The Class MainViewPort.
 */
public class MainViewPort extends Viewport {

	/** The north widget. */
	private final NorthAreaWidget northWidget;

	/** The easth widget. */
	private final EastAreaWidget eastWidget;

	/** The westh widget. */
	private final WestAreaWidget westWidget;

	/** The center widget. */
	private final CenterAreaWidget centerWidget;

	/** The south widget. */
	private final SouthAreaWidget southWidget;

	private final Integer width;

	/**
	 * Instantiates a new main view port.
	 * 
	 * @param northWidget
	 *            the north widget
	 * @param eastWidget
	 *            the east widget
	 * @param westWidget
	 *            the west widget
	 * @param centerWidget
	 *            the center widget
	 * @param southWidget
	 *            the south widget
	 */
	public MainViewPort(NorthAreaWidget northWidget, EastAreaWidget eastWidget, WestAreaWidget westWidget,
			CenterAreaWidget centerWidget, SouthAreaWidget southWidget, Integer pWidth) {
		super();
		this.northWidget = northWidget;
		this.eastWidget = eastWidget;
		this.westWidget = westWidget;
		this.centerWidget = centerWidget;
		this.southWidget = southWidget;
		this.width = pWidth;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.extjs.gxt.ui.client.widget.Viewport#onWindowResize(int, int)
	 */
	@Override
	protected void onWindowResize(int width, int height) {
		int finalWidth = width;
		if (this.width != null) {
			finalWidth = this.width;
		}
		super.onWindowResize(finalWidth, height);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.extjs.gxt.ui.client.widget.Viewport#onRender(com.google.gwt.user.
	 * client.Element, int)
	 */
	@Override
	protected void onRender(Element target, int index) {
		super.onRender(target, index);
		final BorderLayout layout = new BorderLayout();
		setLayout(layout);
		if (this.width != null) {
			setWidth(this.width);
		}

		if (northWidget != null) {
			add(northWidget.getWidget(), northWidget.getBorderLayoutData());
		}
		if (westWidget != null) {
			add(westWidget.getWidget(), westWidget.getBorderLayoutData());
		}
		if (eastWidget != null) {
			add(eastWidget.getWidget(), eastWidget.getBorderLayoutData());
		}
		if (centerWidget != null) {
			add(centerWidget.getWidget(), centerWidget.getBorderLayoutData());
		}
		if (southWidget != null) {
			add(southWidget.getWidget(), southWidget.getBorderLayoutData());
		}
	}

	/**
	 * Gets the north widget.
	 * 
	 * @return the north widget
	 */
	public NorthAreaWidget getNorthWidget() {
		return northWidget;
	}

	/**
	 * Gets the east widget.
	 * 
	 * @return the east widget
	 */
	public EastAreaWidget getEastWidget() {
		return eastWidget;
	}

	/**
	 * Gets the west widget.
	 * 
	 * @return the west widget
	 */
	public WestAreaWidget getWestWidget() {
		return westWidget;
	}

	/**
	 * Gets the center widget.
	 * 
	 * @return the center widget
	 */
	public CenterAreaWidget getCenterWidget() {
		return centerWidget;
	}

	/**
	 * Gets the south widget.
	 * 
	 * @return the south widget
	 */
	public SouthAreaWidget getSouthWidget() {
		return southWidget;
	}

}
