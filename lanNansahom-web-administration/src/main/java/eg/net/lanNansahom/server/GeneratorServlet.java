package eg.net.lanNansahom.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eg.net.lanNansahom.services.MaterialsAdministrationService;
import eg.net.lanNansahom.services.VictimsAdministrationService;
import eg.net.lanNansahom.services.beans.Announcement;
import eg.net.lanNansahom.services.requests.RetrieveAnnouncementsRequest;
import eg.net.lanNansahom.services.requests.SearchVictimsRequest;
import eg.net.lanNansahom.services.responses.SearchVictimsResponse;
import eg.net.services.ServiceException;

public class GeneratorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7502331550676040171L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		process(arg0, arg1);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String type = request.getParameter("formate");
			if ("json".equals(type)) {
				generateJson(response);
			} else if ("rss".equals(type)) {
				generateRSS(response);
			} else if ("xml".equals(type)) {
				generateSiteMap(response);
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void generateJson(HttpServletResponse httpServletResponse) throws ServiceException {
		String json = "";
		JSONGenerator generator = new JSONGenerator();
		VictimsAdministrationService service = ServiceLocator.getInstance().getService(
				VictimsAdministrationService.class);
		SearchVictimsRequest request = new SearchVictimsRequest();
		request.setPartnerId(1);
		request.setIsPublished(true);

		// martyrs
		request.setMartyr(true);
		SearchVictimsResponse response = service.searchVictims(request);
		json += generator.generateVictims("martyrs", response.getVictims());

		// injured
		request.setMartyr(false);
		response = service.searchVictims(request);
		json += generator.generateVictims("injuries", response.getVictims());

		// announcement
		List<Announcement> announcements = getPublishAnnouncement();
		json += generator.generateAnnouncements("announcments", announcements);

		// images
		json += "var images = '[]';";

		// videos
		json += "var videos ='[{\"BINDING_URL\":\"mgW2XlC1I_g\"},{\"BINDING_URL\":\"OMf9U9uy7Yw\"},{\"BINDING_URL\":\"Pxa1emV82vA\"}]';";
		// write data
		try {
			String fileName = "json.js";
			httpServletResponse.setCharacterEncoding("UTF-8");
			httpServletResponse.setContentType("application/octet-stream");
			httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			httpServletResponse.getWriter().write(json);
			httpServletResponse.getWriter().flush();
		} catch (IOException e) {
			throw new ServiceException(e);
		}
	}

	private void generateRSS(HttpServletResponse httpServletResponse) throws ServiceException {
		List<Announcement> announcements = getPublishAnnouncement();
		String xml = RSSFeedsGenerator.generateRSS(announcements);

		try {
			String fileName = "rss.xml";
			httpServletResponse.setCharacterEncoding("UTF-8");
			httpServletResponse.setContentType("application/octet-stream");
			httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			httpServletResponse.getWriter().write(xml);
			httpServletResponse.getWriter().flush();
		} catch (IOException e) {
			throw new ServiceException(e);
		}
	}

	private void generateSiteMap(HttpServletResponse httpServletResponse) throws ServiceException {
		VictimsAdministrationService service = ServiceLocator.getInstance().getService(
				VictimsAdministrationService.class);
		SearchVictimsRequest request = new SearchVictimsRequest();
		request.setPartnerId(1);
		request.setIsPublished(true);
		request.setMartyr(true);
		SearchVictimsResponse response = service.searchVictims(request);
		String xml = SiteMapGenerator.generate(response.getVictims());
		try {
			String fileName = "sitmap.xml";
			httpServletResponse.setCharacterEncoding("UTF-8");
			httpServletResponse.setContentType("application/octet-stream");
			httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			httpServletResponse.getWriter().write(xml);
			httpServletResponse.getWriter().flush();
		} catch (IOException e) {
			throw new ServiceException(e);
		}
	}

	private List<Announcement> getPublishAnnouncement() throws ServiceException {
		MaterialsAdministrationService service = ServiceLocator.getInstance().getService(
				MaterialsAdministrationService.class);

		RetrieveAnnouncementsRequest request = new RetrieveAnnouncementsRequest();
		request.setPartnerId(1);
		request.setOnlyPublished(true);
		return service.retrieveAnnouncements(request).getAnnouncements();

	}

}
