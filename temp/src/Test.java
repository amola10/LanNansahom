import java.io.File;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File folder = new File(
				"C:\\My Stuff\\Projects\\Personal\\Lan_Nansahom\\code\\workspace\\default\\documents\\data\\processedImages\\final\\images\\profiles");
		// int counter = 1;
		for (File file : folder.listFiles()) {
			/*
			 * String extention =
			 * file.getPath().substring(file.getPath().lastIndexOf(".") + 1,
			 * file.getPath().length()); if ("JPG".equals(extention)) { String
			 * newName = file.getPath().substring(0,
			 * file.getPath().lastIndexOf(".")) + ".jpg";
			 * System.out.println(newName); file.renameTo(new File(newName)); }
			 */
			System.out.println(file.getName());
			// counter++;
		}

	}

}
