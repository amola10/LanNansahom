package eg.net.lanNansahom.client.widget.victims;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;

import eg.net.gxt.client.widget.BaseFormPanel;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.shared.beans.VictimBean;

public abstract class VictimMask<T extends VictimBean> extends BaseFormPanel<T> {

	private HtmlEditor descrionControl;

	private HtmlEditor medicalDescrionControl;

	private VictimRelativesGrid victimRelativesPanel;

	private VictimImagesGrid victimImagesGrid;

	private VictimVideosGrid victimVideosGrid;

	private VictimArticlesGrid victimArticlesGrid;

	public VictimMask(T bean, String title, boolean martyrs) {
		super(bean, title + (bean.getId() != 0 ? " record " + bean.getId() : ""));
	}

	@Override
	protected void attachFormControls(FormPanel panel) {
		panel.setLayout(new FitLayout());
		panel.setLabelAlign(LabelAlign.TOP);

		final TabPanel tabs = new TabPanel();

		tabs.add(preparePersonalTab());
		tabs.add(prepareInjuryTab());
		addAdditionalTab(tabs);
		tabs.add(prepareRelativesTab());
		tabs.add(prepareVictimImagesTab());
		tabs.add(prepareVictimVideoTab());
		tabs.add(prepareVictimArticlesTab());
		panel.add(tabs);

	}

	protected TabItem createTab(String title, int padding) {
		TabItem result = new TabItem();
		result.setStyleAttribute("padding", padding + "px");
		result.setText(title);
		FormLayout layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		result.setLayout(layout);
		return result;
	}

	private TabItem preparePersonalTab() {
		Messages messages = GWT.create(Messages.class);
		TabItem result = createTab(messages.personal(), 10);
		result.add(new VictimPersonalDataPanel());

		descrionControl = new HtmlEditor();
		descrionControl.setName(VictimBean.BINDING_DESCRIPTION);
		descrionControl.setFieldLabel(messages.description());
		descrionControl.setHeight(355);
		result.add(descrionControl, new FormData("100%"));

		return result;
	}

	private TabItem prepareInjuryTab() {
		Messages messages = GWT.create(Messages.class);
		TabItem result = createTab(messages.injuryInformation(), 10);
		result.add(new VictimInjuryDataPanel());

		medicalDescrionControl = new HtmlEditor();
		medicalDescrionControl.setName(VictimBean.BINDING_MEDICAL_DESCRIPTION);
		medicalDescrionControl.setFieldLabel(messages.medicalDescription());
		medicalDescrionControl.setHeight(445);
		result.add(medicalDescrionControl, new FormData("100%"));
		return result;
	}

	private TabItem prepareRelativesTab() {
		Messages messages = GWT.create(Messages.class);
		TabItem result = createTab(messages.relatives(), 0);
		this.victimRelativesPanel = new VictimRelativesGrid(getBean().getRelatives());
		result.add(this.victimRelativesPanel);
		return result;
	}

	private TabItem prepareVictimImagesTab() {
		Messages messages = GWT.create(Messages.class);
		TabItem result = createTab(messages.images(), 0);
		this.victimImagesGrid = new VictimImagesGrid(getBean().getImages());
		result.add(victimImagesGrid);
		return result;
	}

	private TabItem prepareVictimVideoTab() {
		Messages messages = GWT.create(Messages.class);
		TabItem result = createTab(messages.videos(), 0);
		this.victimVideosGrid = new VictimVideosGrid(getBean().getVideos());
		result.add(victimVideosGrid);
		return result;
	}

	private TabItem prepareVictimArticlesTab() {
		Messages messages = GWT.create(Messages.class);
		TabItem result = createTab(messages.articles(), 0);
		this.victimArticlesGrid = new VictimArticlesGrid(getBean().getArticles());
		result.add(victimArticlesGrid);
		return result;
	}

	@Override
	protected void attachFormButtons(FormPanel panel) {
		Messages messages = GWT.create(Messages.class);
		Button button = new Button(messages.save());
		panel.addButton(button);
		button.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				T bean = getBean();
				bean.setDescription(descrionControl.getValue());
				bean.set(VictimBean.BINDING_MEDICAL_DESCRIPTION, medicalDescrionControl.getValue());
				bean.setRelatives(victimRelativesPanel.getRelatives());
				bean.setImages(victimImagesGrid.getImages());
				bean.setVideos(victimVideosGrid.getVideos());
				bean.setArticles(victimArticlesGrid.getArticles());
				if (bean.getId() != 0) {
					Dispatcher.forwardEvent(getUpdateEvent(), bean);
				} else {
					Dispatcher.forwardEvent(getAddEvent(), bean);
				}

			}
		});

	}

	protected abstract EventType getAddEvent();

	protected abstract EventType getUpdateEvent();

	protected void addAdditionalTab(TabPanel tabsPanel) {

	}

}
