package eg.net.lanNansahom.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import eg.net.gxt.client.ClientException;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.AnnouncementBean;
import eg.net.lanNansahom.shared.beans.EmailBean;
import eg.net.lanNansahom.shared.beans.LookupBean;
import eg.net.lanNansahom.shared.beans.SearchVictimsBean;
import eg.net.lanNansahom.shared.beans.VictimBean;

@RemoteServiceRelativePath("administration")
public interface AdministrationRemoteService extends RemoteService {

	public void addAnnouncement(AnnouncementBean announcementBean) throws ClientException;

	public void updateAnnouncement(AnnouncementBean announcementBean) throws ClientException;

	public List<AnnouncementBean> getAllAnnouncement() throws ClientException;

	public void addVictim(VictimBean victimBean) throws ClientException;

	public void updateVictim(VictimBean victimBean) throws ClientException;

	public void deleteVictim(VictimBean victimBean) throws ClientException;

	public void generateVictims(boolean isMartyr) throws ClientException;

	public void generatePublishAnnouncement() throws ClientException;

	public List<? extends VictimBean> searchVictims(SearchVictimsBean searchVictimsBean) throws ClientException;

	public void addLookup(LookupType type, LookupBean lookupBean) throws ClientException;

	public void updateLookup(LookupType type, LookupBean lookupBean) throws ClientException;

	public List<LookupBean> getLookupByType(LookupType type) throws ClientException;

	public void sendEmail(EmailBean pEmailBean) throws ClientException;

}
