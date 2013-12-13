package eg.net.lanNansahom.server;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.List;

import org.apache.abdera.Abdera;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import org.apache.abdera.writer.WriterOptions;

import eg.net.lanNansahom.services.beans.Announcement;

public class RSSFeedsGenerator {

	public static void generateRSS(String pTargetPath, List<Announcement> pAnnouncements) {
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
		sotreFeed(pTargetPath, feed);

	}

	/**
	 * Sotre file.
	 * 
	 * @param pTargetPath
	 *            the target path
	 * @param fileContent
	 *            the file content
	 */
	private static void sotreFeed(String pTargetPath, Feed pFeed) {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pTargetPath), "UTF8"));
			WriterOptions writerOptions = pFeed.getDefaultWriterOptions();
			writerOptions.setCharset("UTF8");
			pFeed.writeTo(bufferedWriter, writerOptions);
			bufferedWriter.flush();
		} catch (Exception e) {
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e1) {
				}
			}

		}
	}
}
