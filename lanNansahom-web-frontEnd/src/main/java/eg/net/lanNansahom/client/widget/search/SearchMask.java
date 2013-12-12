package eg.net.lanNansahom.client.widget.search;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;

import eg.net.gxt.client.widget.BaseFormPanel;
import eg.net.gxt.client.widget.ImageLink;
import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.CustomGXTUtil;
import eg.net.lanNansahom.client.LookupsManager;
import eg.net.lanNansahom.client.Resources;
import eg.net.lanNansahom.shared.beans.SearchVictimsBean;

public class SearchMask extends BaseFormPanel<SearchVictimsBean> {

	private TextField<String> keywordControl;

	public SearchMask() {
		super(new SearchVictimsBean(), null);
	}

	@Override
	protected void attachFormControls(FormPanel panel) {
		panel.setLayout(new RowLayout(Orientation.HORIZONTAL));
		panel.setBodyBorder(false);
		panel.setBodyStyleName("headerBackground");
		Resources resources = (Resources) GWT.create(Resources.class);

		keywordControl = new TextField<String>();
		keywordControl.setName(SearchVictimsBean.BINDING_NAME);
		keywordControl.setHideLabel(true);
		keywordControl.setBorders(false);
		keywordControl.addKeyListener(new KeyListener() {

			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					Dispatcher.forwardEvent(AppEvents.SEARCH_EVENT, keywordControl.getValue());
				}
			}

		});
		panel.add(keywordControl, new RowData(280, 20, new Margins(50, 0, 0, 0)));

		ImageLink search = new ImageLink(resources.search());
		search.setStyleName("searchButton");
		search.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Dispatcher.forwardEvent(AppEvents.SEARCH_EVENT, keywordControl.getValue());
			}
		});

		panel.add(search, new RowData(30, Style.DEFAULT, new Margins(50, 0, 0, 0)));

		ImageLink advancedSearch = new ImageLink(resources.advancedSearch());
		advancedSearch.setStyleName("advancedSearchButton");
		advancedSearch.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				CustomGXTUtil.showLoading();
				LookupsManager.intializeLookups(AppEvents.GO_TO_ADVANCED_SEARCH_EVENT);
			}
		});

		panel.add(advancedSearch, new RowData(90, Style.DEFAULT, new Margins(50, 0, 0, 0)));

	}

	@Override
	protected void attachFormButtons(FormPanel panel) {

	}

}
