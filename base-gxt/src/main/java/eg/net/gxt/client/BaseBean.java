package eg.net.gxt.client;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;

public class BaseBean extends BaseModel {

	private static final long serialVersionUID = -946778070392684709L;
	private static final String DATE_PREFIX = "_STRING_FORMATE";

	public BaseBean() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.extjs.gxt.ui.client.data.BaseModel#set(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public <X> X set(String name, X value) {
		X result = super.set(name, value);
		if (value instanceof Date && GWT.isClient()) {
			DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("dd.MM.yyyy");
			set(name + DATE_PREFIX, dateTimeFormat.format((Date) value));
		}
		return result;
	}

	public String getDateInStringFormate(String property) {
		return get(property + DATE_PREFIX);
	}
}
