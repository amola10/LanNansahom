package eg.net.lanNansahom.client.widget.martyr;

import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.google.gwt.core.client.GWT;

import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.widget.victims.VictimMask;
import eg.net.lanNansahom.shared.beans.MartyrBean;

public class MartyrMask extends VictimMask<MartyrBean> {

	public MartyrMask(MartyrBean bean) {
		super(bean, constructTitle(false), false);
	}

	public MartyrMask() {
		super(new MartyrBean(), constructTitle(true), false);
	}

	/**
	 * Constuct title.
	 * 
	 * @return the string
	 */
	private static String constructTitle(boolean isNew) {
		Messages messages = GWT.create(Messages.class);
		String result = messages.martyrs() + "-> ";
		if (isNew) {
			result += messages.add();
		} else {
			result += messages.update();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.client.widget.victims.VictimMask#addAdditionalTab(
	 * com.extjs.gxt.ui.client.widget.TabPanel)
	 */
	@Override
	protected void addAdditionalTab(TabPanel tabsPanel) {
		Messages messages = GWT.create(Messages.class);
		TabItem item = createTab(messages.deathInformation(), 10);
		item.add(new MartyrDethDataPanel());
		tabsPanel.add(item);
	}

	@Override
	protected EventType getAddEvent() {
		return AppEvents.ADD_MARTYR;
	}

	@Override
	protected EventType getUpdateEvent() {
		return AppEvents.UPDATE_MARTYR;
	}

}
