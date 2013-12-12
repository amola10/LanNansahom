package eg.net.lanNansahom.server;

import java.text.ParseException;
import java.util.List;

import eg.net.gxt.client.ClientException;
import eg.net.gxt.server.BaseRemoteServiceServlet;
import eg.net.lanNansahom.client.VictimsRemoteService;
import eg.net.lanNansahom.services.VictimsService;
import eg.net.lanNansahom.services.requests.RetrieveAllInjuriesRequest;
import eg.net.lanNansahom.services.requests.RetrieveAllMartyrsRequest;
import eg.net.lanNansahom.services.requests.RetrieveVictimRequest;
import eg.net.lanNansahom.services.requests.SearchPublishedVictimsRequest;
import eg.net.lanNansahom.services.responses.RetrieveAllInjuriesResponse;
import eg.net.lanNansahom.services.responses.RetrieveAllMartyrsRespone;
import eg.net.lanNansahom.services.responses.RetrieveVictimResponse;
import eg.net.lanNansahom.services.responses.SearchPublishedVictimsResponse;
import eg.net.lanNansahom.shared.beans.ImageBean;
import eg.net.lanNansahom.shared.beans.InjuredBean;
import eg.net.lanNansahom.shared.beans.MartyrBean;
import eg.net.lanNansahom.shared.beans.SearchVictimsBean;
import eg.net.lanNansahom.shared.beans.VictimBean;
import eg.net.lanNansahom.shared.beans.VictimInfoBean;
import eg.net.lanNansahom.shared.beans.VideoBean;
import eg.net.services.BeansMapper;
import eg.net.services.ServiceException;

public class VictimsRemoteServiceImpl extends BaseRemoteServiceServlet implements VictimsRemoteService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6311545286647688686L;

	public VictimsRemoteServiceImpl() {
		super();
	}

	public List<VictimInfoBean> retrieveAllMartyrs() throws ClientException {
		try {
			VictimsService service = ServiceLocator.getInstance().getService(VictimsService.class);
			RetrieveAllMartyrsRequest request = new RetrieveAllMartyrsRequest();
			request.setPartnerId(1);
			RetrieveAllMartyrsRespone respone = service.retrieveAllMartyrs(request);
			return BeansMapper.map(respone.getVictims(), VictimInfoBean.class);

		} catch (ServiceException exception) {
			throw translatException(exception.getCode(), exception.getMessage(), exception);
		}

	}

	public List<VictimInfoBean> retrieveAllInjuries() throws ClientException {
		try {
			VictimsService service = ServiceLocator.getInstance().getService(VictimsService.class);
			RetrieveAllInjuriesRequest request = new RetrieveAllInjuriesRequest();
			request.setPartnerId(1);
			RetrieveAllInjuriesResponse respone = service.retrieveAllInjuries(request);
			return BeansMapper.map(respone.getVictims(), VictimInfoBean.class);

		} catch (ServiceException exception) {
			throw translatException(exception.getCode(), exception.getMessage(), exception);
		}

	}

	public VictimBean getVictimById(int pId) throws ClientException {
		try {
			VictimsService service = ServiceLocator.getInstance().getService(VictimsService.class);
			RetrieveVictimRequest request = new RetrieveVictimRequest();
			request.setPartnerId(1);
			request.setId(pId);
			RetrieveVictimResponse response = service.retrieveVictimById(request);
			VictimBean result = null;
			if (response.getVictim().isMartyr()) {
				result = BeansMapper.map(response.getVictim(), MartyrBean.class);
			} else {
				result = BeansMapper.map(response.getVictim(), InjuredBean.class);
			}

			result.setImages(BeansMapper.map(response.getVictim().getImages(), ImageBean.class));
			result.setVideos(BeansMapper.map(response.getVictim().getVideos(), VideoBean.class));
			return result;

		} catch (ServiceException exception) {
			throw translatException(exception.getCode(), exception.getMessage(), exception);
		}

	}

	public List<VictimInfoBean> searchVictims(SearchVictimsBean pSearchVictimsBean) throws ClientException {
		try {
			VictimsService service = ServiceLocator.getInstance().getService(VictimsService.class);
			SearchPublishedVictimsRequest request = new SearchPublishedVictimsRequest();
			request.setPartnerId(1);
			request.setAge(pSearchVictimsBean.getAge());
			if (pSearchVictimsBean.getArea() != null) {
				request.setAreaId(pSearchVictimsBean.getArea().getId());
			}
			if (pSearchVictimsBean.getDate() != null) {
				request.setDate(dateTimeFormat.parse(pSearchVictimsBean
						.getDateInStringFormate(SearchVictimsBean.BINDING_DATE)));
			}
			if (pSearchVictimsBean.getEducation() != null) {
				request.setEducationId(pSearchVictimsBean.getEducation().getId());
			}
			if (pSearchVictimsBean.getJob() != null) {
				request.setJobId(pSearchVictimsBean.getJob().getId());
			}
			request.setName(pSearchVictimsBean.getName());

			SearchPublishedVictimsResponse respone = service.searchPublishedVictims(request);
			return BeansMapper.map(respone.getVictims(), VictimInfoBean.class);

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
	 * eg.net.lanNansahom.client.VictimsRemoteService#searchVictims(java.lang
	 * .String)
	 */
	public List<VictimInfoBean> searchVictims(String pKeyword) throws ClientException {
		try {
			VictimsService service = ServiceLocator.getInstance().getService(VictimsService.class);
			SearchPublishedVictimsRequest request = new SearchPublishedVictimsRequest();
			request.setPartnerId(1);
			request.setName(pKeyword);
			SearchPublishedVictimsResponse respone = service.searchPublishedVictims(request);
			return BeansMapper.map(respone.getVictims(), VictimInfoBean.class);

		} catch (ServiceException exception) {
			throw translatException(exception.getCode(), exception.getMessage(), exception);
		}

	}

}
