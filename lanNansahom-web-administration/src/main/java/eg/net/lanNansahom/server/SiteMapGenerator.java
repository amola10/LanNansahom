package eg.net.lanNansahom.server;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import eg.net.lanNansahom.services.beans.Victim;

public class SiteMapGenerator {

	/**
	 * Write victims.
	 * 
	 * @param pTargetPath
	 *            the target path
	 * @param javascriptVarName
	 *            the javascript var name
	 * @param pVictims
	 *            the victims
	 */
	public static void generate(String pTargetPath, List<Victim> pVictims) {
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
		sotreFile(pTargetPath, map.toString());

	}

	/**
	 * Sotre file.
	 * 
	 * @param pTargetPath
	 *            the target path
	 * @param fileContent
	 *            the file content
	 */
	private static void sotreFile(String pTargetPath, String fileContent) {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pTargetPath), "UTF8"));
			bufferedWriter.write(fileContent);
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
