package eg.net.gxt.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.commons.fileupload.FileItemStream;

public class LocalUploadServlet extends UploadServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6316702241706662057L;
	private String baseDirectory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		prepareBaseDirectory(config);

	}

	private void prepareBaseDirectory(ServletConfig config) throws ServletException {
		baseDirectory = config.getServletContext().getRealPath("/");
		File servletDrectory = new File(config.getServletContext().getRealPath("/"));
		try {
			baseDirectory = servletDrectory.getParentFile().getCanonicalPath() + File.separator + "images";
			File directory = new File(baseDirectory);
			if (!directory.exists()) {
				directory.mkdir();
			}

		} catch (IOException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void storeFile(FileItemStream item, String fileName) throws IOException {
		OutputStream outputStream = null;
		InputStream inputStream = null;
		int bytesRead;
		try {
			inputStream = item.openStream();
			outputStream = new FileOutputStream(getFilePAth(fileName));
			byte[] buffer = new byte[1024];
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			outputStream.flush();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
				if (outputStream != null)
					outputStream.close();
			} catch (IOException e1) {
				// Do Nothing
			}
		}

	}

	private String getFilePAth(String name) {
		return baseDirectory + File.separator + name;
	}

}
