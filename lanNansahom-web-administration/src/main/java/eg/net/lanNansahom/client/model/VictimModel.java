package eg.net.lanNansahom.client.model;

import java.util.List;

import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

import eg.net.gxt.client.BaseAsyncCallbackHandler;
import eg.net.gxt.client.BaseBean;
import eg.net.gxt.client.GXTUtil;
import eg.net.lanNansahom.client.AdministrationRemoteService;
import eg.net.lanNansahom.client.AdministrationRemoteServiceAsync;
import eg.net.lanNansahom.shared.beans.EmailBean;
import eg.net.lanNansahom.shared.beans.SearchVictimsBean;
import eg.net.lanNansahom.shared.beans.VictimBean;

public abstract class VictimModel extends BaseBean {

	private static final long serialVersionUID = 2418097924507905055L;
	/** The service. */
	private final AdministrationRemoteServiceAsync service;

	protected SearchVictimsBean searchStatus = new SearchVictimsBean();

	public VictimModel() {
		service = GWT.create(AdministrationRemoteService.class);
	}

	public void addVictim(VictimBean victimBean) {
		service.addVictim(victimBean, new BaseAsyncCallbackHandler<Void>() {
			public void onSuccess(Void a) {
				Dispatcher.forwardEvent(getGoToSearchEvent());
				Dispatcher.forwardEvent(getSearchEvent(), searchStatus);
			}
		});

	}

	public void updateVictim(VictimBean victimBean) {
		service.updateVictim(victimBean, new BaseAsyncCallbackHandler<Void>() {
			public void onSuccess(Void a) {
				Dispatcher.forwardEvent(getGoToSearchEvent());
				Dispatcher.forwardEvent(getSearchEvent(), searchStatus);
			}

		});

	}

	public void searchVictims(SearchVictimsBean searchVictimsBean) {
		GXTUtil.showLoadingMessage();
		searchStatus = searchVictimsBean;
		service.searchVictims(searchVictimsBean, new BaseAsyncCallbackHandler<List<? extends VictimBean>>() {

			public void onSuccess(List<? extends VictimBean> result) {
				GXTUtil.hideLoadingMessage();
				Dispatcher.forwardEvent(getRefreshSearchResultEvent(), result);

			}

		});

	}

	public void deleteVictim(VictimBean victimBean) {
		service.deleteVictim(victimBean, new BaseAsyncCallbackHandler<Void>() {
			public void onSuccess(Void a) {
				Dispatcher.forwardEvent(getGoToSearchEvent());
				Dispatcher.forwardEvent(getSearchEvent(), searchStatus);
			}

		});
	}

	public void generateVictims(boolean isMartyrs) {
		service.generateVictims(isMartyrs, new BaseAsyncCallbackHandler<Void>() {
			public void onSuccess(Void a) {
				Window.alert("Generate Successfully");
			}

		});
	}

	public void sendEmail(EmailBean pEmailBean) {
		service.sendEmail(pEmailBean, new BaseAsyncCallbackHandler<Void>() {
			public void onSuccess(Void a) {
				Window.alert("Email Send Successfully");
			}

		});
	}

	protected abstract EventType getSearchEvent();

	protected abstract EventType getRefreshSearchResultEvent();

	protected abstract EventType getGoToSearchEvent();
}
