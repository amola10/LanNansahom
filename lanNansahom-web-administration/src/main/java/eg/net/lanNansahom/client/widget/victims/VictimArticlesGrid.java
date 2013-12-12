package eg.net.lanNansahom.client.widget.victims;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

import eg.net.gxt.client.widget.PagingDataGrid;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.Resources;
import eg.net.lanNansahom.shared.beans.ArticleBean;

public class VictimArticlesGrid extends PagingDataGrid<ArticleBean> implements GridCellRenderer<ModelData> {

	public VictimArticlesGrid(List<ArticleBean> articles) {
		super(null, articles, 13);

	}

	@Override
	protected List<ColumnConfig> getColumnConfigurationList() {
		Messages messages = GWT.create(Messages.class);
		List<ColumnConfig> result = new ArrayList<ColumnConfig>();
		result.add(createColumnConfig(ArticleBean.BINDING_TITLE, messages.title(), 250));
		result.add(createColumnConfig(ArticleBean.BINDING_REFERANCE, messages.referance(), 250));
		result.add(createColumnConfig(ArticleBean.BINDING_AUTHOR, messages.author(), 150));
		result.add(createColumnConfig(ArticleBean.BINDING_BODY, messages.body(), 300, this));
		result.add(createColumnConfig("Edit", messages.edit(), 50, this));
		result.add(createColumnConfig("Remove", messages.remove(), 50, this));
		return result;
	}

	@Override
	protected void attachButtons(ContentPanel panel) {
		Resources resources = GWT.create(Resources.class);
		ToolBar toolBar = new ToolBar();
		Button addButton = new Button();
		addButton.setIcon(AbstractImagePrototype.create(resources.add()));
		addButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				ArticleBean bean = new ArticleBean();
				showDetailsDialog(bean);
			}

		});
		toolBar.add(addButton);

		this.panel.setTopComponent(toolBar);
	}

	private void showDetailsDialog(final ArticleBean articleBean) {
		final ArticleDetailsMask articleDetailsMask = new ArticleDetailsMask(articleBean);
		Dialog dialog = new Dialog();
		dialog.setButtons(Dialog.OKCANCEL);
		dialog.setSize(500, 400);
		dialog.setHideOnButtonClick(true);
		dialog.setLayout(new BorderLayout());
		dialog.setModal(true);

		// center
		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.add(articleDetailsMask);
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
		dialog.add(panel, data);
		dialog.addListener(Events.Hide, new Listener<BaseEvent>() {

			public void handleEvent(BaseEvent be) {
				articleBean.setBody(articleDetailsMask.getBody());
				if (getModels().indexOf(articleBean) == -1) {
					addToStore(articleBean);
				} else {
					refreshStore(getModels());
				}

			}
		});
		dialog.show();
	}

	@Override
	protected void attachGridListeners(Grid<ArticleBean> grid) {
		setHeight(565);
	}

	public Object render(ModelData model, String property, ColumnData config, int rowIndex, int colIndex,
			ListStore<ModelData> store, Grid<ModelData> grid) {
		final ArticleBean articleBean = (ArticleBean) store.getAt(rowIndex);
		Resources resources = GWT.create(Resources.class);
		Button button = new Button();

		if ("Remove".equals(property)) {
			button.setIcon(AbstractImagePrototype.create(resources.remove()));
			button.addSelectionListener(new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					removeFromStore(articleBean);

				}
			});

		} else if ("Edit".equals(property)) {
			button.setIcon(AbstractImagePrototype.create(resources.edit()));
			button.addSelectionListener(new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					showDetailsDialog(articleBean);

				}
			});

		} else if (ArticleBean.BINDING_BODY.equals(property)) {
			String result = articleBean.getBody();
			if (articleBean.getBody() != null && articleBean.getBody().length() > 200) {
				result = articleBean.getBody().substring(0, 200);
			}
			return result;

		}
		return button;
	}

	public List<ArticleBean> getArticles() {
		return getModels();
	}

}
