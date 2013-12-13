package eg.net.lanNansahom.server;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RSSFeedsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2550547602318238933L;

	private String baseDirectory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		baseDirectory = config.getServletContext().getRealPath("/");
		File servletDrectory = new File(config.getServletContext().getRealPath("/"));
		try {
			baseDirectory = servletDrectory.getParentFile().getCanonicalPath() + File.separator + "data";
			File directory = new File(baseDirectory);
			if (!directory.exists()) {
				directory.mkdir();
			}

		} catch (IOException e) {
			throw new ServletException(e);
		}

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

	public void readRss(HttpServletResponse resp) {
		DataInputStream inputStream = null;
		try {
			inputStream = new DataInputStream(new FileInputStream(baseDirectory + "/rss.xml"));
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
