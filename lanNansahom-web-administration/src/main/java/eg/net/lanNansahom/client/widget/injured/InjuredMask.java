package eg.net.lanNansahom.client.widget.injured;

import com.extjs.gxt.ui.client.event.EventType;
import com.google.gwt.core.client.GWT;

import eg.net.lanNansahom.client.AppEvents;
import eg.net.lanNansahom.client.Messages;
import eg.net.lanNansahom.client.widget.victims.VictimMask;
import eg.net.lanNansahom.shared.beans.InjuredBean;

public class InjuredMask extends VictimMask<InjuredBean> {

	public InjuredMask(InjuredBean bean) {
		super(bean, constructTitle(false), false);
	}

	public InjuredMask() {
		super(new InjuredBean(), constructTitle(true), false);
	}

	/**
	 * Constuct title.
	 * 
	 * @return the string
	 */
	private static String constructTitle(boolean isNew) {
		Messages messages = GWT.create(Messages.class);
		String result = messages.injuries() + "-> ";
		if (isNew) {
			result += messages.add();
		} else {
			result += messages.update();
		}
		return result;
	}

	@Override
	protected EventType getAddEvent() {
		return AppEvents.ADD_INJURED;
	}

	@Override
	protected EventType getUpdateEvent() {
		return AppEvents.UPDATE_INJURED;
	}

}
