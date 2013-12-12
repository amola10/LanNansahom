package eg.net.lanNansahom.server;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import eg.net.lanNansahom.services.beans.Victim;

public class SiteMapGenerator {

	/**
	 * Write victims.
	 * 
	 * @param pVictims
	 *            the victims
	 * @return the string
	 */
	public static String generate(List<Victim> pVictims) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer map = new StringBuffer();
		map.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> ");
		map.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\"> ");
		for (Victim victim : pVictims) {
			map.append("<url> ");
			map.append("<loc>http://lan-nansahom.org/#!martyr;" + victim.getId() + "</loc> ");
			map.append("<lastmod>" + dateFormat.format(new Date()) + "</lastmod> ");
			map.append("</url>");
		}
		map.append("</urlset>");
		return map.toString();

	}

}
