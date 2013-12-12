package eg.net.lanNansahom.server;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eg.net.lanNansahom.shared.URLUtility;

public class RSSFeedsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2550547602318238933L;

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
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		readRss(resp);
	}

	public void readRss(HttpServletResponse resp) throws IOException {
		DataInputStream inputStream = null;
		try {
			URL url = new URL(URLUtility.getJsonDataBaseURL() + "rss.xml");
			inputStream = new DataInputStream(url.openStream());
			byte data[] = new byte[inputStream.available()];
			inputStream.readFully(data);
			resp.getOutputStream().write(data);
			resp.getOutputStream().flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
