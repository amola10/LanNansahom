package eg.net.lanNansahom.client.widget.announcement;

import java.util.List;

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Image;

import eg.net.lanNansahom.client.Resources;
import eg.net.lanNansahom.shared.beans.AnnouncementBean;

public class AnnouncementPanel extends LayoutContainer {

	private final List<AnnouncementBean> announcementBeans;

	public AnnouncementPanel(List<AnnouncementBean> pAnnouncementBeans) {
		super();
		setLayout(new FitLayout());
		setBorders(false);
		announcementBeans = pAnnouncementBeans;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.extjs.gxt.ui.client.widget.ContentPanel#onRender(com.google.gwt.user
	 * .client.Element, int)
	 */
	@Override
	protected void onRender(Element parent, int pos) {
		super.onRender(parent, pos);
		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);
		panel.add(createHeader());
		panel.setBodyStyleName("announcementList");

		for (AnnouncementBean announcement : announcementBeans) {
			Text text = new Text(announcement.getText());
			text.setStyleName("announcement");
			panel.add(text);
		}

		add(panel);

	}

	private ContentPanel createHeader() {
		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(false);
		panel.setBorders(false);
		panel.setBodyBorder(false);

		Resources resources = (Resources) GWT.create(Resources.class);
		panel.setHeight(resources.announcments().getHeight());
		panel.add(new Image(resources.announcments()));
		return panel;
	}

}
