package eg.net.lanNansahom.client.widget.common;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.user.client.Element;

import eg.net.lanNansahom.shared.URLUtility;
import eg.net.lanNansahom.shared.beans.ImageBean;

public abstract class AbstractImagesPanel extends LayoutContainer {

	protected final ListStore<ImageBean> store = new ListStore<ImageBean>();
	protected ListView<ImageBean> view;
	protected ContentPanel panel;

	public AbstractImagesPanel(List<ImageBean> pImages) {
		super();
		setLayout(new FitLayout());
		setBorders(false);
		store.add(pImages);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.extjs.gxt.ui.client.widget.LayoutContainer#onRender(com.google.gwt
	 * .user.client.Element, int)
	 */
	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);
		panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);
		panel.setLayout(new FlowLayout());
		view = new ListView<ImageBean>() {

			@Override
			protected List<ImageBean> collectData(List<ImageBean> models, int startIndex) {
				List<ImageBean> list = new ArrayList<ImageBean>();
				for (int i = 0, len = models.size(); i < len; i++) {
					list.add(prepareFinalData(models.get(i), i));
				}
				return list;
			}

		};

		view.setBorders(false);
		view.setTemplate(getTemplate(getBaseClass()));
		view.setStore(store);
		view.setItemSelector("div." + getBaseClass() + "-wrap");
		view.getSelectionModel().addListener(Events.SelectionChange, new Listener<SelectionChangedEvent<ImageBean>>() {

			public void handleEvent(SelectionChangedEvent<ImageBean> be) {
				imageSelected(be.getSelectedItem());
				try {
					view.getSelectionModel().deselect(be.getSelectedItem());
				} catch (RuntimeException e) {
				}
			}

		});

		panel.add(view);

		add(panel);
	}

	protected El getElById(String id) {
		El result = null;
		Element element = XDOM.getElementById(id);
		if (element != null) {
			result = new El(element);
		}
		return result;
	}

	protected native String getTemplate(String pBassClass) /*-{
		return [
				'<tpl for=".">',
				'<div class="' + pBassClass + '-wrap" id="{jsid}" >',
				'<div class="' + pBassClass
						+ '"><img src="{path}" title="{description}"></div>',
				'</div>', '</tpl>', '<div class="x-clear"></div>' ].join("");

	}-*/;

	protected String getBaseClass() {
		return "thumb";
	}

	protected ImageBean prepareFinalData(ImageBean model, int index) {
		if (model.get("path") == null) {
			model.set("path", URLUtility.getImagesBaseURL() + model.getUrl());
		}
		model.set("jsid", "image_" + index);
		model.set("description", model.getDescription());
		return model;
	}

	protected abstract void imageSelected(ImageBean imageBean);

}
