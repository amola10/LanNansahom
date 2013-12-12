package eg.net.lanNansahom.server;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

import org.apache.abdera.Abdera;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import eg.net.lanNansahom.services.beans.Announcement;
import eg.net.services.ServiceException;

public class RSSFeedsGenerator {

	public static String generateRSS(List<Announcement> pAnnouncements) throws ServiceException {
		Abdera abdera = new Abdera();
		Feed feed = abdera.newFeed();

		feed.setId("tag:lan-nansahom.org,2012");
		feed.setTitle("lan-nansahom");
		feed.setSubtitle("lan-nansahom");
		feed.setUpdated(new Date());
		feed.addLink("http://lan-nansahom.org");
		feed.addLink("http://lan-nansahom.org", "self");

		int i = 1;
		for (Announcement announcement : pAnnouncements) {
			Entry entry = feed.addEntry();
			entry.setId("tag:lan-nansahom.org,2012:/entries/" + i);
			entry.setTitle(announcement.getTitle());
			entry.setSummaryAsHtml(announcement.getText());
			entry.setUpdated(announcement.getDate());
			entry.setPublished(announcement.getDate());
			entry.addLink("http://lan-nansahom.org/#martyrs");
			i++;
		}

		StringWriter writer = new StringWriter();
		try {
			feed.writeTo(writer);
			return writer.getBuffer().toString();

		} catch (IOException e) {
			throw new ServiceException(e);
		}

	}
}
