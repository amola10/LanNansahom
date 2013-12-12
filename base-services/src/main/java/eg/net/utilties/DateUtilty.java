package eg.net.utilties;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author nayera.mohamed
 */
public final class DateUtilty {

	/**
	 * Private Constructor.
	 */
	private DateUtilty() {
	}

	/**
	 * Method to convert java.util.Date instance to String.
	 * 
	 * @param date
	 *            java.util.Date instance to be converted to string
	 * @param pattern
	 *            The date Pattern.
	 * @return String representation of the given date instance
	 */
	public static String dateToString(final Date date, final String pattern) {
		final SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}

	/**
	 * Method to convert java.util.Date instance to String.
	 * 
	 * @param date
	 *            java.util.Date instance to be converted to string
	 * @param datePattern
	 *            The date Pattern.
	 * @param timeZoneFormate
	 *            The timeZoneFormate.
	 * @return String representation of the given date instance
	 */
	public static String dateToString(final Date date, final String datePattern, final String timeZoneFormate) {
		final SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
		final TimeZone timeZone = TimeZone.getTimeZone(timeZoneFormate);
		formatter.setTimeZone(timeZone);
		return formatter.format(date);
	}

	/**
	 * Method to parse String representation of date.
	 * 
	 * @param dateString
	 *            The string representation of the date object
	 * @param datePattern
	 *            The date Pattern.
	 * @return java.util.Date object
	 * @throws ParseException
	 *             if the pattern has invalid formate.
	 */
	public static Date dateFromString(final String dateString, final String datePattern) throws ParseException {
		final SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
		return formatter.parse(dateString);
	}

}
