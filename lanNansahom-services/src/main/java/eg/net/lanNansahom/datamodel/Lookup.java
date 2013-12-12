package eg.net.lanNansahom.datamodel;

public class Lookup implements java.io.Serializable {

	private static final long serialVersionUID = -4636935037897516500L;
	private int id;
	private String name;
	private String description;

	public Lookup() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
