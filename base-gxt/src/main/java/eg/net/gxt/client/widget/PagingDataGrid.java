package eg.net.gxt.client.widget;

import java.util.List;

import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;

public abstract class PagingDataGrid<T extends ModelData> extends DataGrid<T> {

	/** The page size. */
	private final int pageSize;

	/** The loader. */
	private PagingLoader<PagingLoadResult<ModelData>> loader;

	/** The tool bar. */
	protected PagingToolBar toolBar;

	/**
	 * Instantiates a new data grid.
	 * 
	 * @param title
	 *            the title
	 * @param pageSize
	 *            the page size
	 */
	public PagingDataGrid(String title, int pageSize) {
		super(title);
		this.pageSize = pageSize;
		this.toolBar = new PagingToolBar(this.pageSize);
	}

	public PagingDataGrid(String title, List<T> data, int pageSize) {
		super(title, data);
		this.pageSize = pageSize;
		this.toolBar = new PagingToolBar(this.pageSize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.gxt.client.widget.DataGrid#prepareStore(java.util.List)
	 */
	@Override
	protected ListStore<T> prepareStore(List<T> data) {
		PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(data);
		loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);
		loader.setRemoteSort(true);
		ListStore<T> result = new ListStore<T>(loader);

		if (this.panel.getBottomComponent() == null) {
			panel.setBottomComponent(toolBar);
		}

		this.toolBar.bind(loader);

		loader.load(0, this.pageSize);
		return result;
	}

}
