package eg.net.lanNansahom.server;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class CrawlFilter implements Filter {

	private String context;

	public void init(FilterConfig filterConfig) throws ServletException {
		context = filterConfig.getServletContext().getContextPath();
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest pRequest, ServletResponse pResponse, FilterChain pFilterChain)
			throws IOException, ServletException {
		if (pRequest.getParameter("_escaped_fragment_") != null) {
			String url = "http://" + pRequest.getServerName() + ":" + pRequest.getServerPort() + context + "/#!"
					+ pRequest.getParameter("_escaped_fragment_");
			final WebClient webClient = new WebClient();
			HtmlPage page = webClient.getPage(url);
			webClient.waitForBackgroundJavaScript(4000);
			pResponse.setCharacterEncoding("UTF-8");
			pResponse.getWriter().println(page.asXml());

		} else {
			pFilterChain.doFilter(pRequest, pResponse);
		}

	}
}
