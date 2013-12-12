package eg.net.lanNansahom.server;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.appengine.api.users.UserServiceFactory;

import eg.net.EmailUtility;
import eg.net.gxt.client.ClientException;
import eg.net.gxt.server.BaseRemoteServiceServlet;
import eg.net.lanNansahom.client.AdministrationRemoteService;
import eg.net.lanNansahom.services.MaterialsAdministrationService;
import eg.net.lanNansahom.services.VictimsAdministrationService;
import eg.net.lanNansahom.services.beans.Announcement;
import eg.net.lanNansahom.services.beans.Article;
import eg.net.lanNansahom.services.beans.Image;
import eg.net.lanNansahom.services.beans.Lookup;
import eg.net.lanNansahom.services.beans.Relative;
import eg.net.lanNansahom.services.beans.Victim;
import eg.net.lanNansahom.services.beans.Video;
import eg.net.lanNansahom.services.requests.AddAnnouncementRequest;
import eg.net.lanNansahom.services.requests.AddLookupRequest;
import eg.net.lanNansahom.services.requests.AddVictimRequest;
import eg.net.lanNansahom.services.requests.DeleteVictimsRequest;
import eg.net.lanNansahom.services.requests.RetrieveAnnouncementsRequest;
import eg.net.lanNansahom.services.requests.SearchLookupsRequest;
import eg.net.lanNansahom.services.requests.SearchVictimsRequest;
import eg.net.lanNansahom.services.requests.UpdateAnnouncementRequest;
import eg.net.lanNansahom.services.requests.UpdateLookupRequest;
import eg.net.lanNansahom.services.requests.UpdateVictimsRequest;
import eg.net.lanNansahom.services.responses.SearchVictimsResponse;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.lanNansahom.shared.beans.AnnouncementBean;
import eg.net.lanNansahom.shared.beans.ArticleBean;
import eg.net.lanNansahom.shared.beans.EmailBean;
import eg.net.lanNansahom.shared.beans.ImageBean;
import eg.net.lanNansahom.shared.beans.InjuredBean;
import eg.net.lanNansahom.shared.beans.LookupBean;
import eg.net.lanNansahom.shared.beans.MartyrBean;
import eg.net.lanNansahom.shared.beans.RelativeBean;
import eg.net.lanNansahom.shared.beans.SearchVictimsBean;
import eg.net.lanNansahom.shared.beans.VictimBean;
import eg.net.lanNansahom.shared.beans.VideoBean;
import eg.net.services.BeansMapper;
import eg.net.services.ServiceException;

/**
 * The Class AdministrationRemoteServiceImpl.
 */
public class AdministrationRemoteServiceImpl extends BaseRemoteServiceServlet implements AdministrationRemoteService {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6923147595272535272L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.client.AdministrationRemoteService#addAnnouncement
	 * (eg.net.lanNansahom.shared.beans.AnnouncementBean)
	 */
	public void addAnnouncement(AnnouncementBean announcementBean) throws ClientException {
		try {
			MaterialsAdministrationService service = ServiceLocator.getInstance().getService(
					MaterialsAdministrationService.class);
			AddAnnouncementRequest request = new AddAnnouncementRequest();
			request.setPartnerId(1);
			Announcement announcement = BeansMapper.map(announcementBean, Announcement.class);
			setAnnouncmentDates(announcement, announcementBean);
			request.setAnnouncement(announcement);
			service.addAnnouncement(request);

		} catch (ServiceException exception) {
			throw translatException(exception.getCode(), exception.getMessage(), exception);
		} catch (ParseException exception) {
			throw translatException("", exception.getMessage(), exception);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.client.AdministrationRemoteService#updateAnnouncement
	 * (eg.net.lanNansahom.shared.beans.AnnouncementBean)
	 */
	public void updateAnnouncement(AnnouncementBean announcementBean) throws ClientException {
		try {
			MaterialsAdministrationService service = ServiceLocator.getInstance().getService(
					MaterialsAdministrationService.class);
			UpdateAnnouncementRequest request = new UpdateAnnouncementRequest();
			request.setPartnerId(1);
			Announcement announcement = BeansMapper.map(announcementBean, Announcement.class);
			setAnnouncmentDates(announcement, announcementBean);
			request.setAnnouncement(announcement);
			service.updateAnnouncement(request);

		} catch (ServiceException exception) {
			throw translatException(exception.getCode(), exception.getMessage(), exception);
		} catch (ParseException exception) {
			throw translatException("", exception.getMessage(), exception);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.client.AdministrationRemoteService#getAllAnnouncement
	 * ()
	 */
	public List<AnnouncementBean> getAllAnnouncement() throws ClientException {
		try {
			MaterialsAdministrationService service = ServiceLocator.getInstance().getService(
					MaterialsAdministrationService.class);
			RetrieveAnnouncementsRequest request = new RetrieveAnnouncementsRequest();
			request.setPartnerId(1);

			List<Announcement> announcements = service.retrieveAnnouncements(request).getAnnouncements();
			return BeansMapper.map(announcements, AnnouncementBean.class);

		} catch (ServiceException exception) {
			throw translatException(exception.getCode(), exception.getMessage(), exception);
		}
	}

	public void addVictim(VictimBean victimBean) throws ClientException {
		try {
			VictimsAdministrationService service = ServiceLocator.getInstance().getService(
					VictimsAdministrationService.class);
			AddVictimRequest request = new AddVictimRequest();
			request.setPartnerId(1);
			Victim victim = BeansMapper.map(victimBean, Victim.class);
			victim.setRelatives(BeansMapper.map(victimBean.getRelatives(), Relative.class));
			victim.setImages(BeansMapper.map(victimBean.getImages(), Image.class));
			victim.setVideos(BeansMapper.map(victimBean.getVideos(), Video.class));
			victim.setArticles(BeansMapper.map(victimBean.getArticles(), Article.class));
			setVictimDates(victim, victimBean);
			request.setVictim(victim);
			service.addVictim(request);

		} catch (ServiceException exception) {
			throw translatException(exception.getCode(), exception.getMessage(), exception);
		} catch (ParseException exception) {
			throw translatException("", exception.getMessage(), exception);
		}

	}

	public void updateVictim(VictimBean victimBean) throws ClientException {
		try {
			VictimsAdministrationService service = ServiceLocator.getInstance().getService(
					VictimsAdministrationService.class);
			UpdateVictimsRequest request = new UpdateVictimsRequest();
			request.setPartnerId(1);
			Victim victim = BeansMapper.map(victimBean, Victim.class);
			victim.setRelatives(BeansMapper.map(victimBean.getRelatives(), Relative.class));
			victim.setImages(BeansMapper.map(victimBean.getImages(), Image.class));
			victim.setVideos(BeansMapper.map(victimBean.getVideos(), Video.class));
			victim.setArticles(BeansMapper.map(victimBean.getArticles(), Article.class));
			request.setVictim(victim);
			setVictimDates(victim, victimBean);
			service.updateVictim(request);

		} catch (ServiceException exception) {
			throw translatException(exception.getCode(), exception.getMessage(), exception);
		} catch (ParseException exception) {
			throw translatException("", exception.getMessage(), exception);
		}

	}

	public void deleteVictim(VictimBean victimBean) throws ClientException {
		try {
			VictimsAdministrationService service = ServiceLocator.getInstance().getService(
					VictimsAdministrationService.class);
			DeleteVictimsRequest request = new DeleteVictimsRequest();
			request.setPartnerId(1);
			Victim victim = BeansMapper.map(victimBean, Victim.class);
			victim.setRelatives(BeansMapper.map(victimBean.getRelatives(), Relative.class));
			victim.setImages(BeansMapper.map(victimBean.getImages(), Image.class));
			victim.setVideos(BeansMapper.map(victimBean.getVideos(), Video.class));
			victim.setArticles(BeansMapper.map(victimBean.getArticles(), Article.class));
			request.setVictim(victim);
			service.deleteVictim(request);

		} catch (ServiceException exception) {
			throw translatException(exception.getCode(), exception.getMessage(), exception);
		}

	}

	public List<? extends VictimBean> searchVictims(SearchVictimsBean searchVictimsBean) throws ClientException {
		try {
			List<? extends VictimBean> result = new ArrayList<VictimBean>();
			VictimsAdministrationService service = ServiceLocator.getInstance().getService(
					VictimsAdministrationService.class);
			SearchVictimsRequest request = new SearchVictimsRequest();
			request.setPartnerId(1);
			request.setMartyr(searchVictimsBean.isMartyr());
			request.setName(searchVictimsBean.getName());
			if (searchVictimsBean.getAge() != null) {
				request.setAge(searchVictimsBean.getAge());
			}
			if (searchVictimsBean.getEducation() != null) {
				request.setEducationId(searchVictimsBean.getEducation().getId());
			}
			if (searchVictimsBean.getJob() != null) {
				request.setJobId(searchVictimsBean.getJob().getId());
			}

			if (searchVictimsBean.getArea() != null) {
				request.setAreaId(searchVictimsBean.getArea().getId());
			}

			if (searchVictimsBean.getDate() != null) {
				request.setDate(dateTimeFormat.parse(searchVictimsBean
						.getDateInStringFormate(SearchVictimsBean.BINDING_DATE)));
			}

			if (searchVictimsBean.getPublished() != null
					&& !"All".equalsIgnoreCase(searchVictimsBean.getPublished().getName())) {
				request.setIsPublished("Only Published".equalsIgnoreCase(searchVictimsBean.getPublished().getName()) ? true
						: false);
			}

			if (searchVictimsBean.getId() != null) {
				request.setId(searchVictimsBean.getId());
			}

			if (searchVictimsBean.getRecordStatus() != null) {
				request.setRecordStatusId(searchVictimsBean.getRecordStatus().getId());
			}
			SearchVictimsResponse response = service.searchVictims(request);
			if (searchVictimsBean.isMartyr()) {
				result = BeansMapper.map(response.getVictims(), MartyrBean.class);
			} else {
				result = BeansMapper.map(response.getVictims(), InjuredBean.class);
			}
			for (int i = 0; i < response.getVictims().size(); i++) {
				result.get(i).setRelatives(
						BeansMapper.map(response.getVictims().get(i).getRelatives(), RelativeBean.class));
				result.get(i).setImages(BeansMapper.map(response.getVictims().get(i).getImages(), ImageBean.class));
				result.get(i).setVideos(BeansMapper.map(response.getVictims().get(i).getVideos(), VideoBean.class));
				result.get(i).setArticles(
						BeansMapper.map(response.getVictims().get(i).getArticles(), ArticleBean.class));
			}

			return result;
		} catch (ServiceException exception) {
			throw translatException(exception.getCode(), exception.getMessage(), exception);
		} catch (ParseException exception) {
			throw translatException("", exception.getMessage(), exception);
		}
	}

	public void addLookup(LookupType type, LookupBean lookupBean) throws ClientException {
		try {
			MaterialsAdministrationService service = ServiceLocator.getInstance().getService(
					MaterialsAdministrationService.class);
			AddLookupRequest request = new AddLookupRequest();
			request.setPartnerId(1);
			request.setLookupType(type);
			request.setLookup(BeansMapper.map(lookupBean, Lookup.class));

			service.addLookup(request);
		} catch (ServiceException exception) {
			throw translatException(exception.getCode(), exception.getMessage(), exception);
		}
	}

	public void updateLookup(LookupType type, LookupBean lookupBean) throws ClientException {
		try {
			MaterialsAdministrationService service = ServiceLocator.getInstance().getService(
					MaterialsAdministrationService.class);
			UpdateLookupRequest request = new UpdateLookupRequest();
			request.setPartnerId(1);
			request.setLookupType(type);
			request.setLookup(BeansMapper.map(lookupBean, Lookup.class));

			service.updateLookup(request);
		} catch (ServiceException exception) {
			throw translatException(exception.getCode(), exception.getMessage(), exception);
		}
	}

	public List<LookupBean> getLookupByType(LookupType type) throws ClientException {
		try {
			MaterialsAdministrationService service = ServiceLocator.getInstance().getService(
					MaterialsAdministrationService.class);
			SearchLookupsRequest request = new SearchLookupsRequest();
			request.setPartnerId(1);
			request.setLookupType(type);

			List<Lookup> lookups = service.searchLookups(request).getLookups();
			return BeansMapper.map(lookups, LookupBean.class);

		} catch (ServiceException exception) {
			throw translatException(exception.getCode(), exception.getMessage(), exception);
		}
	}

	private void setAnnouncmentDates(Announcement announcement, AnnouncementBean announcementBean)
			throws ParseException {
		if (announcementBean.getDateInStringFormate(AnnouncementBean.BINDING_DATE) != null) {
			announcement.setDate(dateTimeFormat.parse(announcementBean
					.getDateInStringFormate(AnnouncementBean.BINDING_DATE)));
		}
	}

	private void setVictimDates(Victim victim, VictimBean victimBean) throws ParseException {
		if (victimBean.getDateInStringFormate(victimBean.BINDING_BIRTHDATE) != null) {
			victim.setBirthDate(dateTimeFormat.parse(victimBean.getDateInStringFormate(VictimBean.BINDING_BIRTHDATE)));
		}

		if (victimBean.getDateInStringFormate(victimBean.BINDING_INJURY_DATE) != null) {
			victim.setInjuryDate(dateTimeFormat.parse(victimBean.getDateInStringFormate(VictimBean.BINDING_INJURY_DATE)));
		}

		if (victimBean instanceof MartyrBean) {
			MartyrBean martyrBean = (MartyrBean) victimBean;
			if (martyrBean.getDateInStringFormate(martyrBean.BINDING_DEATH_DATE) != null) {
				victim.setDeathDate(dateTimeFormat.parse(martyrBean
						.getDateInStringFormate(MartyrBean.BINDING_DEATH_DATE)));
			}

			if (martyrBean.getDateInStringFormate(martyrBean.BINDING_CORPSE_DISCOVERY_DATE) != null) {
				victim.setCorpseDiscoveryDate(dateTimeFormat.parse(martyrBean
						.getDateInStringFormate(MartyrBean.BINDING_CORPSE_DISCOVERY_DATE)));
			}
		}

	}

	public void sendEmail(EmailBean pEmailBean) throws ClientException {
		EmailUtility utility = new EmailUtility(UserServiceFactory.getUserService().getCurrentUser().getEmail(), null);
		utility.sendEmail(pEmailBean.getTo(), pEmailBean.getSubject(), pEmailBean.getMessage());

	}

}
