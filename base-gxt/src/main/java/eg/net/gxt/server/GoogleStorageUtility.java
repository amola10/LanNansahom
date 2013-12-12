package eg.net.gxt.server;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.apache.log4j.Logger;

import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.files.FileWriteChannel;
import com.google.appengine.api.files.GSFileOptions.GSFileOptionsBuilder;

public class GoogleStorageUtility {

	/**
	 * Class Logger Used for logging.
	 */
	private static final Logger LOGGER = Logger.getLogger(GoogleStorageUtility.class);

	public static void writeFileToBucket(String bucket, String fileName, String acl, InputStream inputStream)
			throws IllegalStateException, IOException {

		FileWriteChannel writeChannel = null;

		try {
			FileService fileService = FileServiceFactory.getFileService();
			GSFileOptionsBuilder optionsBuilder = new GSFileOptionsBuilder().setBucket(bucket).setKey(fileName)
					.setAcl(acl);
			AppEngineFile writableFile = fileService.createNewGSFile(optionsBuilder.build());
			// Open a channel to write to it
			boolean lock = true;
			writeChannel = fileService.openWriteChannel(writableFile, lock);
			// This time we write to the channel directly
			writeContent(inputStream, writeChannel);
		} finally {
			if (writeChannel != null) {
				// Now finalize
				writeChannel.closeFinally();
			}
		}

	}

	private static void writeContent(InputStream inputStream, FileWriteChannel writeChannel) throws IOException {

		int bytesRead;
		byte[] buffer = new byte[1024];
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			writeChannel.write(ByteBuffer.wrap(buffer, 0, bytesRead));
		}

	}

}