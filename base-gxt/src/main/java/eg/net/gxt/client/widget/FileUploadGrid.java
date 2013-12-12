package eg.net.gxt.client.widget;

import gxt.multiupload.MultiUploadPresenter;
import gxt.multiupload.MultiUploadView;
import gxt.multiupload.model.FileUploadModel;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.Model;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;

public class FileUploadGrid extends LayoutContainer implements SubmitCompleteHandler {

	private static final String NAME = "Name";
	private static final String STATE = "State";
	private FileUploadListener listener = null;

	public FileUploadGrid() {

	}

	public FileUploadGrid(FileUploadListener listener) {
		this.listener = listener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.extjs.gxt.ui.client.widget.LayoutContainer#onRender(com.google.gwt
	 * .user.client.Element, int)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void show() {
		EditorGrid<Model> grid = new EditorGrid<Model>(new ListStore<FileUploadModel>(), createColumnsModel());
		grid.getView().setForceFit(true);
		grid.getView().setAutoFill(true);
		grid.getView().setShowDirtyCells(false);
		grid.setBorders(false);
		grid.getStore().setMonitorChanges(true);
		Grid g = grid;
		MultiUploadView view = new MultiUploadView(g);
		view.getFormPanel().setAction(getUploadAction());
		view.getFormPanel().addSubmitCompleteHandler(this);
		MultiUploadPresenter presenter = new MultiUploadPresenter(view);
		presenter.go();

	}

	public static ColumnModel createColumnsModel() {
		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		columns.add(new ColumnConfig(FileUploadModel.NAME, NAME, 250));
		columns.add(new ColumnConfig(FileUploadModel.MESSAGE, STATE, 100));
		ColumnModel columnsModel = new ColumnModel(columns);
		return columnsModel;
	}

	public void onSubmitComplete(SubmitCompleteEvent event) {
		if (listener != null && event.getResults() != null && JSONParser.parseLenient(event.getResults()) != null) {
			JSONObject jsonObject = (JSONObject) JSONParser.parseLenient(event.getResults());
			JSONString state = (JSONString) jsonObject.get(FileUploadModel.STATE);
			if (state != null && "OK".equals(state.stringValue())) {
				String originalName = ((JSONString) jsonObject.get("name")).stringValue();
				String finalName = ((JSONString) jsonObject.get("finalName")).stringValue();
				listener.onSuccessUpload(originalName, finalName);
			}

		}

	}

	protected String getUploadAction() {
		return "upload";
	}

}
