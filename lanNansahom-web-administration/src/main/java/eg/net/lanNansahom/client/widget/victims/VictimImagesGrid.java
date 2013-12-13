package eg.net.lanNansahom.client.widget.victims;

import java.util.Date;
import java.util.List;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

import eg.net.gxt.client.widget.FileUploadGrid;
import eg.net.gxt.client.widget.FileUploadListener;
import eg.net.lanNansahom.client.Resources;
import eg.net.lanNansahom.shared.beans.ImageBean;

public class VictimImagesGrid extends LayoutContainer implements FileUploadListener {

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
				model.set("path", "http://" + Window.Location.getHost() + "/images/" + model.getUrl());
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
				FileUploadGrid fileUploadGrid = new FileUploadGrid(VictimImagesGrid.this);
				fileUploadGrid.show();
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
					ImageDetailsMask imageDetailsMask = new ImageDetailsMask(selectedImage);
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
					dialog.show();
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
										return [ '<tpl for=".">', 
										'<div class="thumb-wrap" id="{description}">',
											'<div class="thumb"><img src="{path}" title="{description}"></div>',
										'</div>', '</tpl>',
										'<div class="x-clear"></div>' ].join("");

										}-*/;

	public void onSuccessUpload(String originalName, String finalName) {
		ImageBean imageBean = new ImageBean();
		imageBean.setUrl(finalName);
		imageBean.setDescription(originalName);
		imageBean.setDate(new Date());
		this.store.add(imageBean);

	}

	public List<ImageBean> getImages() {
		return this.store.getModels();
	}
}
