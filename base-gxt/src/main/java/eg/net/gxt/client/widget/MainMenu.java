package eg.net.gxt.client.widget;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;

import eg.net.gxt.client.Event;

public class MainMenu extends ContentPanel {

	private ContentPanel activeMenuGroup;

	public MainMenu() {
		super();
		setLayout(new AccordionLayout());
	}

	public void addMenuGroup(String title) {
		activeMenuGroup = new ContentPanel();
		VBoxLayout layout = new VBoxLayout();
		layout.setVBoxLayoutAlign(VBoxLayoutAlign.STRETCH);
		activeMenuGroup.setLayout(layout);
		activeMenuGroup.setHeading(title);
		activeMenuGroup.setHeaderVisible(true);
		activeMenuGroup.setBodyBorder(false);
		activeMenuGroup.setCollapsible(true);
		activeMenuGroup.setAnimCollapse(false);
		activeMenuGroup.setScrollMode(Scroll.AUTO);
		add(activeMenuGroup);

	}

	public void addMenuItem(String title, final Event appEvent) {
		if (activeMenuGroup == null) {
			addMenuGroup("");
		}
		String token = "#";
		if (appEvent != null) {
			token += appEvent.getToken();
		}
		Anchor anchor = new Anchor(title, true, token);
		anchor.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Dispatcher.forwardEvent(appEvent);

			}
		});
		activeMenuGroup.add(anchor);
	}
}
