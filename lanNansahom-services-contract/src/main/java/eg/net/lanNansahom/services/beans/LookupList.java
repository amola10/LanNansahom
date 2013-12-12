package eg.net.lanNansahom.services.beans;

import java.util.List;

/**
 * The Class LookupList.
 */
public class LookupList {

	/** The items. */
	private List<Lookup> items;

	public LookupList() {
		super();
	}

	public LookupList(List<Lookup> items) {
		super();
		this.items = items;
	}

	/**
	 * Gets the items.
	 * 
	 * @return the items
	 */
	public List<Lookup> getItems() {
		return items;
	}

	/**
	 * Sets the items.
	 * 
	 * @param items
	 *            the items to set
	 */
	public void setItems(List<Lookup> items) {
		this.items = items;
	}

}
