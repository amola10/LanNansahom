package eg.net.lanNansahom.client;

import com.extjs.gxt.themes.client.Slate;
import com.extjs.gxt.ui.client.util.Theme;

import eg.net.gxt.client.BaseEntryBoint;
import eg.net.lanNansahom.client.controller.AnnouncementController;
import eg.net.lanNansahom.client.controller.ApplicationController;
import eg.net.lanNansahom.client.controller.InjuredController;
import eg.net.lanNansahom.client.controller.LookupController;
import eg.net.lanNansahom.client.controller.MartyrController;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BackEnd extends BaseEntryBoint {

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.gxt.client.BaseEntryBoint#init()
	 */
	@Override
	public void init() {
		registerController(new ApplicationController());
		registerController(new MartyrController());
		registerController(new InjuredController());
		registerController(new AnnouncementController());
		registerController(new LookupController());
		LookupsManager.intializeLookups(AppEvents.HOME_PAGE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.gxt.client.BaseEntryBoint#start()
	 */
	@Override
	public void start() {
		// Do Nothing. Wait for LookupsManager to fire event after finish
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.gxt.client.BaseEntryBoint#getActiveTheme()
	 */
	@Override
	public Theme getActiveTheme() {
		return Slate.BLUE;
	}

}
