package eg.net.lanNansahom.client.widget.application;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.user.client.Window;

public class HomePage extends ContentPanel {

	public HomePage() {
		super();
		addText("Hello Adminstrator, <br/><br/>		Welcome to Lan-Nansahom application");
		Button button = new Button("Generate Published Records In Json");
		button.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Window.alert("Json file will be generated with published records of Martyrs , Injured and Announcement. Please save with name 'json.js' and upload to cloud.");
				UrlBuilder builder = Window.Location.createUrlBuilder();
				builder.setHash("");
				builder.setPath(Window.Location.getPath() + "generate");
				builder.setParameter("formate", "json");
				Window.open(builder.buildString(), "", "");
			}
		});
		addButton(button);

		button = new Button("Generate RSS Feeds");
		button.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Window.alert("RSS file will be generated. Please save with name 'rss.xml' and upload to cloud.");
				UrlBuilder builder = Window.Location.createUrlBuilder();
				builder.setHash("");
				builder.setPath(Window.Location.getPath() + "generate");
				builder.setParameter("formate", "rss");
				Window.open(builder.buildString(), "", "");

			}
		});
		addButton(button);

		button = new Button("Generate Site Map");
		button.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Window.alert("Site Map file will be generated. Please save with name 'sitemap.xml' and upload to cloud.");
				UrlBuilder builder = Window.Location.createUrlBuilder();
				builder.setHash("");
				builder.setPath(Window.Location.getPath() + "generate");
				builder.setParameter("formate", "xml");
				Window.open(builder.buildString(), "", "");

			}
		});
		addButton(button);

	}

}
