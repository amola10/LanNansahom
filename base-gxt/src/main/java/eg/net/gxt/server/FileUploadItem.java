package eg.net.gxt.server;

import java.io.Serializable;

public class FileUploadItem implements Serializable {

	private static final long serialVersionUID = -5265253647057875553L;
	private String name;
	private String finalName;
	private String state;
	private String message;

	public FileUploadItem() {

	}

	public FileUploadItem(String name, String state, String message) {
		this.name = name;
		this.state = state;
		this.message = message;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	/**
	 * @return the finalName
	 */
	public String getFinalName() {
		return finalName;
	}

	/**
	 * @param finalName
	 *            the finalName to set
	 */
	public void setFinalName(String finalName) {
		this.finalName = finalName;
	}

	@Override
	public String toString() {
		return "{name:'" + name + "', finalName:'" + finalName + "', state:'" + state + "', message:'" + message + "'}";
	}
}