package eg.net.gxt.server;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.fileupload.FileItemStream;

public class GoogleStorageUploadServlet extends UploadServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3997296029566362639L;

	private static final String BUCKET = "lanansahom";
	private static final String FOLDER = "upload";
	private static final String ACL = "public-read";

	@Override
	protected void storeFile(FileItemStream item, String fileName) throws IOException {
		InputStream inputStream = item.openStream();
		try {
			GoogleStorageUtility.writeFileToBucket(BUCKET, FOLDER + "//" + fileName, ACL, inputStream);
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();

			} catch (IOException e1) {
				// Do Nothing
			}
		}
	}
}
