package eg.net.gxt.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = -1605169938935437112L;

	private static final String ENCODING = "utf-8";

	private static final long MAX_FILE_SIZE = 1024 * 1024;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		request.setCharacterEncoding(ENCODING);
		response.setCharacterEncoding(ENCODING);
		response.setContentType("text/html");

		FileUploadItem model = new FileUploadItem();
		try {
			ServletFileUpload upload = new ServletFileUpload();
			FileItemIterator iterator = upload.getItemIterator(request);
			while (iterator.hasNext()) {
				FileItemStream item = iterator.next();
				processFileItem(request, model, item);
			}
		} catch (Exception e) {
			model.setState("ERROR");
			model.setMessage("Error" + e.getMessage());
			throw new ServletException(e);
		} finally {
			try {
				response.getWriter().write(model.toString());
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
	}

	private void processFileItem(HttpServletRequest request, FileUploadItem model, FileItemStream item)
			throws IOException {
		if (!item.isFormField()) {
			if (request.getContentLength() > MAX_FILE_SIZE) {
				model.setState("ERROR");
				model.setMessage("Maximum size exceeded");
				model.setName(item.getName());
				model.setFinalName(item.getName());
			} else {
				String fileName = getFileName(item.getName());
				storeFile(item, fileName);
				model.setState("OK");
				model.setMessage("OK");
				model.setName(item.getName());
				model.setFinalName(fileName);
			}
		}
	}

	private void storeFile(FileItemStream item, String fileName) throws IOException {
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

	private String getFileName(String name) {
		String fileExtension = name.substring(name.indexOf("."));
		String fileName = name.substring(0, name.indexOf("."));
		return fileName + "_" + System.currentTimeMillis() + fileExtension;
	}
}