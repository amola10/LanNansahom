package eg.net.lanNansahom.shared.beans;

public enum ImageCategry {

	Normal(1), Profile(2), Banner(3), Thumbnail(4);
	private int id;

	private ImageCategry(int pId) {
		id = pId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
