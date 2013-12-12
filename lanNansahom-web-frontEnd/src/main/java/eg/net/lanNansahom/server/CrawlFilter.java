package eg.net.lanNansahom.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.LogFactory;

import eg.net.lanNansahom.services.VictimsService;
import eg.net.lanNansahom.services.beans.Image;
import eg.net.lanNansahom.services.beans.ImageCategry;
import eg.net.lanNansahom.services.beans.Victim;
import eg.net.lanNansahom.services.requests.RetrieveVictimRequest;
import eg.net.lanNansahom.services.responses.RetrieveVictimResponse;
import eg.net.lanNansahom.shared.URLUtility;
import eg.net.services.ServiceException;

public class CrawlFilter implements Filter {

	private String url;

	static {
		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log",
				"org.apache.commons.logging.impl.NoOpLog");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		url = filterConfig.getInitParameter("applicationURL");
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest pRequest, ServletResponse pResponse, FilterChain pFilterChain)
			throws IOException, ServletException {
		if (pRequest.getParameter("_escaped_fragment_") != null) {
			String token = pRequest.getParameter("_escaped_fragment_");
			String respone = "<!doctype html>";
			respone += "<html xmlns=\"http://www.w3.org/1999/xhtml\"  xmlns:fb=\"http://www.facebook.com/2008/fbml\" >";
			respone += "<head>";
			respone += "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">";

			String title = "\u0644\u0646 \u0646\u0646\u0633\u0627\u0647\u0645";
			String image = "shortcut.gif";
			String description = "";
			if (token.startsWith("martyr;")) {
				Victim victim = getVictim(token);
				if (victim != null) {
					title = victim.getName();
					List<Image> images = victim.getImagesByType(ImageCategry.Thumbnail);
					if (images.size() > 0) {
						image = images.get(0).getUrl();
					}
					description = victim.getDescription();
				}
			}
			respone += "<meta property=\"og:title\" 		content=\"" + title + "\"  id=\"title\"/>";
			respone += "<meta property=\"og:description\" content=\"\u0627\u0644\u0645\u0628\u0627\u062F\u0631\u0629 \u0627\u0644\u0634\u0639\u0628\u064A\u0629 \u0644\u062A\u0643\u0631\u064A\u0645 \u0634\u0647\u062F\u0627\u0621 \u0648\u0645\u0635\u0627\u0628\u0649 \u0627\u0644\u062B\u0648\u0631\u0629\" />";
			respone += "<meta property=\"og:image\" 		content=\" " + URLUtility.getImagesBaseURL() + image
					+ "\" id=\"shortcutImage\" />";

			respone += "</head>";
			respone += "<body dir=\"rtl\">";
			respone += "<div>" + description + "</div>";
			respone += "</body>";
			respone += "</html>";

			pResponse.setCharacterEncoding("UTF-8");
			pResponse.getWriter().println(respone);

		} else {
			pFilterChain.doFilter(pRequest, pResponse);
		}

	}

	private Victim getVictim(String token) {
		Victim result = null;
		try {
			int id = Integer.parseInt(token.substring(token.indexOf(";") + 1, token.length()));
			VictimsService service = ServiceLocator.getInstance().getService(VictimsService.class);
			RetrieveVictimRequest request = new RetrieveVictimRequest();
			request.setPartnerId(1);
			request.setId(id);
			RetrieveVictimResponse victimResponse = service.retrieveVictimById(request);
			result = victimResponse.getVictim();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return result;
	}

}
