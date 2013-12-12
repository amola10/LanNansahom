package eg.net.gxt.client.widget;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;

/**
 * The Class DataGrid.
 * 
 * @param <T>
 *            the generic type
 */
public abstract class DataGrid<T extends ModelData> extends LayoutContainer {

	/** The title. */
	private final String title;

	/** The grid. */
	private Grid<T> grid;

	/** The panel. */
	protected ContentPanel panel;

	/** The intial data. */
	protected List<T> intialData = new ArrayList<T>();

	/**
	 * Instantiates a new data grid.
	 * 
	 * @param title
	 *            the title
	 */
	public DataGrid(String title) {
		super();
		this.title = title;
		this.panel = new ContentPanel();
		this.panel.setBodyBorder(true);
		if (this.title != null) {
			panel.setHeading(this.title);
		} else {
			panel.setHeaderVisible(false);
		}
		panel.setButtonAlign(HorizontalAlignment.RIGHT);
		panel.setLayout(new FitLayout());
		setLayout(new FitLayout());
	}

	/**
	 * Instantiates a new data grid.
	 * 
	 * @param title
	 *            the title
	 * @param data
	 *            the data
	 */
	public DataGrid(String title, List<T> data) {
		this(title);
		this.intialData = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.extjs.gxt.ui.client.widget.LayoutContainer#onRender(com.google.gwt
	 * .user.client.Element, int)
	 */
	@Override
	protected void onRender(Element target, int index) {
		super.onRender(target, index);
		init();
	}

	/**
	 * Creates the column config.
	 * 
	 * @param coulmnId
	 *            the coulmn id
	 * @param coulmnTitle
	 *            the coulmn title
	 * @param width
	 *            the width
	 * @return the column config
	 */
	protected ColumnConfig createColumnConfig(String coulmnId, String coulmnTitle, int width) {
		ColumnConfig result = new ColumnConfig();
		result.setId(coulmnId);
		result.setHeader(coulmnTitle);
		result.setWidth(width);
		result.setRowHeader(true);
		return result;
	}

	/**
	 * Creates the column config.
	 * 
	 * @param coulmnId
	 *            the coulmn id
	 * @param coulmnTitle
	 *            the coulmn title
	 * @param width
	 *            the width
	 * @param alignment
	 *            the alignment
	 * @return the column config
	 */
	protected ColumnConfig createColumnConfig(String coulmnId, String coulmnTitle, int width,
			HorizontalAlignment alignment) {
		ColumnConfig result = createColumnConfig(coulmnId, coulmnTitle, width);
		result.setAlignment(alignment);
		return result;
	}

	/**
	 * Creates the column config.
	 * 
	 * @param coulmnId
	 *            the coulmn id
	 * @param coulmnTitle
	 *            the coulmn title
	 * @param width
	 *            the width
	 * @param editor
	 *            the editor
	 * @return the column config
	 */
	protected ColumnConfig createColumnConfig(String coulmnId, String coulmnTitle, int width, CellEditor editor) {
		ColumnConfig result = createColumnConfig(coulmnId, coulmnTitle, width);
		result.setEditor(editor);
		return result;
	}

	/**
	 * Creates the column config.
	 * 
	 * @param coulmnId
	 *            the coulmn id
	 * @param coulmnTitle
	 *            the coulmn title
	 * @param width
	 *            the width
	 * @param renderer
	 *            the renderer
	 * @return the column config
	 */
	protected ColumnConfig createColumnConfig(String coulmnId, String coulmnTitle, int width,
			GridCellRenderer<ModelData> renderer) {
		ColumnConfig result = createColumnConfig(coulmnId, coulmnTitle, width);
		result.setRenderer(renderer);
		return result;
	}

	/**
	 * Creates the column config.
	 * 
	 * @param coulmnId
	 *            the coulmn id
	 * @param coulmnTitle
	 *            the coulmn title
	 * @param width
	 *            the width
	 * @param renderer
	 *            the renderer
	 * @param alignment
	 *            the alignment
	 * @return the column config
	 */
	protected ColumnConfig createColumnConfig(String coulmnId, String coulmnTitle, int width,
			GridCellRenderer<ModelData> renderer, HorizontalAlignment alignment) {
		ColumnConfig result = createColumnConfig(coulmnId, coulmnTitle, width);
		result.setRenderer(renderer);
		result.setAlignment(alignment);
		return result;
	}

	/**
	 * Creates the column config.
	 * 
	 * @param coulmnId
	 *            the coulmn id
	 * @param coulmnTitle
	 *            the coulmn title
	 * @param width
	 *            the width
	 * @param editor
	 *            the editor
	 * @param renderer
	 *            the renderer
	 * @return the column config
	 */
	protected ColumnConfig createColumnConfig(String coulmnId, String coulmnTitle, int width, CellEditor editor,
			GridCellRenderer<ModelData> renderer) {
		ColumnConfig result = createColumnConfig(coulmnId, coulmnTitle, width, renderer);
		result.setEditor(editor);
		return result;
	}

	/**
	 * Prepare store.
	 * 
	 * @param data
	 *            the data
	 * @return the list store
	 */
	protected ListStore<T> prepareStore(List<T> data) {
		ListStore<T> result = new ListStore<T>();
		result.add(data);
		return result;
	}

	/**
	 * Refresh store.
	 * 
	 * @param data
	 *            the data
	 */
	protected void refreshStore(List<T> data) {
		ListStore<T> store = prepareStore(data);
		this.grid.reconfigure(store, this.grid.getColumnModel());
		layout(true);

	}

	/**
	 * Inits the.
	 */
	private void init() {

		ColumnModel columnModel = new ColumnModel(getColumnConfigurationList());
		ListStore<T> store = prepareStore(this.intialData);
		this.grid = new Grid<T>(store, columnModel);
		this.grid.setBorders(false);
		this.grid.setStripeRows(true);
		this.grid.setColumnLines(true);
		this.grid.setColumnReordering(true);
		attachGridListeners(grid);
		panel.add(this.grid);
		attachButtons(panel);
		add(panel);
	}

	/**
	 * Gets the store.
	 * 
	 * @return the store
	 */
	protected List<T> getModels() {
		return this.grid != null ? this.grid.getStore().getModels() : this.intialData;
	}

	/**
	 * Adds the to store.
	 * 
	 * @param t
	 *            the t
	 */
	protected void addToStore(T t) {
		this.grid.getStore().add(t);
	}

	/**
	 * Removes the from store.
	 * 
	 * @param t
	 *            the t
	 */
	protected void removeFromStore(T t) {
		this.grid.getStore().remove(t);
	}

	/**
	 * Gets the column configuration list.
	 * 
	 * @return the column configuration list
	 */
	protected abstract List<ColumnConfig> getColumnConfigurationList();

	/**
	 * Attach buttons.
	 * 
	 * @param panel
	 *            the panel
	 */
	protected abstract void attachButtons(ContentPanel panel);

	/**
	 * Attach grid listeners.
	 * 
	 * @param grid
	 *            the grid
	 */
	protected abstract void attachGridListeners(Grid<T> grid);

}
