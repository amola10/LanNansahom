package eg.net.lanNansahom.client.widget.victims;

import java.util.List;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

import eg.net.lanNansahom.client.Resources;
import eg.net.lanNansahom.shared.beans.VideoBean;

public class VictimVideosGrid extends LayoutContainer {

	private final ListStore<VideoBean> store = new ListStore<VideoBean>();
	private VideoBean selectedItem;
	private Button editButton;
	private Button removeButton;

	public VictimVideosGrid(List<VideoBean> videos) {
		setLayout(new FitLayout());
		store.add(videos);

	}

	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);
		final ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.setHeight(560);
		panel.setBodyBorder(false);
		panel.setLayout(new FlowLayout());
		panel.setTopComponent(createToolbar());

		final ListView<VideoBean> view = new ListView<VideoBean>() {
			@Override
			protected VideoBean prepareData(VideoBean model) {
				model.set("path", "http://www.youtube.com/v/" + model.getUrl()
						+ "&hl=en_US&feature=player_embedded&version=3");
				return model;
			}

		};

		view.setTemplate(getTemplate());
		view.setStore(store);
		view.setItemSelector("div.thumb-wrap");

		view.getSelectionModel().addListener(Events.SelectionChange, new Listener<SelectionChangedEvent<VideoBean>>() {

			public void handleEvent(SelectionChangedEvent<VideoBean> be) {
				selectedItem = be.getSelectedItem();
				editButton.setEnabled(true);
				removeButton.setEnabled(true);
			}

		});

		panel.add(view);
		add(panel);
	}

	private ToolBar createToolbar() {
		final Resources resources = GWT.create(Resources.class);

		ToolBar toolBar = new ToolBar();
		Button addButton = new Button();
		addButton.setIcon(AbstractImagePrototype.create(resources.add()));
		addButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				VideoBean videoBean = new VideoBean();
				showDetailsDialog(videoBean);
			}

		});
		toolBar.add(addButton);

		editButton = new Button();
		editButton.setEnabled(false);
		editButton.setIcon(AbstractImagePrototype.create(resources.edit()));
		editButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if (selectedItem != null) {
					showDetailsDialog(selectedItem);
				}

			}

		});
		toolBar.add(editButton);

		removeButton = new Button();
		removeButton.setEnabled(false);
		removeButton.setIcon(AbstractImagePrototype.create(resources.remove()));
		removeButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				store.remove(selectedItem);
			}

		});
		toolBar.add(removeButton);

		return toolBar;
	}

	private void showDetailsDialog(final VideoBean videoBean) {
		VideoDetailsMask videoDetailsMask = new VideoDetailsMask(videoBean);
		Dialog dialog = new Dialog();
		dialog.setButtons(Dialog.OKCANCEL);
		dialog.setSize(300, 200);
		dialog.setHideOnButtonClick(true);
		dialog.setLayout(new BorderLayout());
		dialog.setModal(true);

		// center
		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.add(videoDetailsMask);
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
		dialog.add(panel, data);
		dialog.addListener(Events.Hide, new Listener<BaseEvent>() {

			public void handleEvent(BaseEvent be) {
				if (store.indexOf(videoBean) == -1 && videoBean.getUrl() != null && !"".equals(videoBean.getUrl())) {
					store.add(videoBean);
				}

			}
		});
		dialog.show();
	}

	private native String getTemplate() /*-{
										return [ '<tpl for=".">',
										'<div class="thumb-wrap" id="{description}">', 
										'<div  class="thumb"><object>',
										'<param name="movie" value="{path}"></param>',
										'<param name="allowFullScreen" value="true"></param>',
										'<param name="wmode" value="opaque" ></param>',
										'<param name="allowScriptAccess" value="always"></param>',
										'<embed src="{path}" type="application/x-shockwave-flash" allowfullscreen="true" allowScriptAccess="always" wmode="opaque" ></embed>',
										'</object></div></div>',
										 '</tpl>',
										'<div class="x-clear"></div>' ].join("");

										}-*/;

	public List<VideoBean> getVideos() {
		return this.store.getModels();
	}
}