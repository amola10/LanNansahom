package eg.net.lanNansahom.client.widget.victims;

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Image;

import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.Resources;

public class StatisticsPanel extends LayoutContainer {

	public StatisticsPanel() {
		super();
		setLayout(new FitLayout());
		setBorders(false);
	}

	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);
		ContentPanel panel = new ContentPanel();
		panel.setBodyBorder(false);
		panel.setBorders(false);
		panel.setHeaderVisible(false);
		panel.setBodyStyleName("scrollPane");

		Messages messages = GWT.create(Messages.class);
		Text text = new Text(messages.statisticsRemark());
		text.setStyleName("remark");
		panel.add(text);

		Resources resources = GWT.create(Resources.class);
		final Image image = new Image(resources.charts());
		panel.add(image);
		add(panel);
	}

}
