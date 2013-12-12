import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// System.getProperties().put("org.apache.commons.logging.simplelog.defaultlog",
			// "error");
			final WebClient webClient = new WebClient();

			webClient.setCssEnabled(false);
			HtmlPage page = webClient.getPage("http://lan-nansahom.appspot.com/#!martyr;542");
			webClient.waitForBackgroundJavaScript(30000);
			System.out.println(page.asXml());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
