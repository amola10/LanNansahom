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
import com.extjs.gxt.ui.client.util.Format;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

import eg.net.lanNansahom.client.Resources;
import eg.net.lanNansahom.shared.URLUtility;
import eg.net.lanNansahom.shared.beans.ImageBean;

public class VictimImagesGrid extends LayoutContainer {

	private final ListStore<ImageBean> store = new ListStore<ImageBean>();

	private ImageBean selectedImage;
	private Button editButton;
	private Button removeButton;

	public VictimImagesGrid(List<ImageBean> images) {
		setLayout(new FitLayout());
		store.add(images);
	}

	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);
		final ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.setHeight(560);
		panel.setBodyBorder(false);
		panel.setTopComponent(createToolbar());

		final ListView<ImageBean> view = new ListView<ImageBean>() {
			@Override
			protected ImageBean prepareData(ImageBean model) {
				model.set("shortName", Format.ellipse(model.getDescription(), 15));
				model.set("path", URLUtility.getImagesBaseURL() + model.getUrl());
				return model;
			}

		};

		view.setTemplate(getTemplate());
		view.setStore(store);
		view.setItemSelector("div.thumb-wrap");

		view.getSelectionModel().addListener(Events.SelectionChange, new Listener<SelectionChangedEvent<ImageBean>>() {

			public void handleEvent(SelectionChangedEvent<ImageBean> be) {
				selectedImage = be.getSelectedItem();
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
				showImageDetailsBox(new ImageBean());
			}

		});
		toolBar.add(addButton);

		editButton = new Button();
		editButton.setEnabled(false);
		editButton.setIcon(AbstractImagePrototype.create(resources.edit()));
		editButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if (selectedImage != null) {
					showImageDetailsBox(selectedImage);
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
				store.remove(selectedImage);
			}

		});
		toolBar.add(removeButton);

		return toolBar;
	}

	private native String getTemplate() /*-{
		return [
				'<tpl for=".">',
				'<div class="thumb-wrap" id="{description}">',
				'<div class="thumb"><img src="{path}" title="{description}"></div>',
				'</div>', '</tpl>', '<div class="x-clear"></div>' ].join("");

	}-*/;

	private void showImageDetailsBox(final ImageBean imageBean) {

		ImageDetailsMask imageDetailsMask = new ImageDetailsMask(imageBean);
		Dialog dialog = new Dialog();
		dialog.setSize(300, 200);
		dialog.setHideOnButtonClick(true);
		dialog.setLayout(new BorderLayout());
		// center
		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.add(imageDetailsMask);
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
		dialog.add(panel, data);
		dialog.addListener(Events.Hide, new Listener<BaseEvent>() {

			public void handleEvent(BaseEvent be) {
				if (store.indexOf(imageBean) == -1 && imageBean.getUrl() != null && !"".equals(imageBean.getUrl())) {
					imageBean.setDescription(imageBean.getUrl());
					store.add(imageBean);
				}

			}
		});
		dialog.show();

	}

	public List<ImageBean> getImages() {
		return this.store.getModels();
	}
}
