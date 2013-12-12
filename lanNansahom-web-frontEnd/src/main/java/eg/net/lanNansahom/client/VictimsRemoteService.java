package eg.net.lanNansahom.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import eg.net.gxt.client.ClientException;
import eg.net.lanNansahom.shared.beans.SearchVictimsBean;
import eg.net.lanNansahom.shared.beans.VictimBean;
import eg.net.lanNansahom.shared.beans.VictimInfoBean;

@RemoteServiceRelativePath("victims")
public interface VictimsRemoteService extends RemoteService {

	public List<VictimInfoBean> searchVictims(SearchVictimsBean pSearchVictimsBean) throws ClientException;

	public List<VictimInfoBean> searchVictims(String pKeyword) throws ClientException;

	public VictimBean getVictimById(int pId) throws ClientException;

}
