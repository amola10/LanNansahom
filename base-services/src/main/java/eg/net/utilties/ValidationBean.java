package eg.net.utilties;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

/**
 * This class is responsible for validating any inputs to the system.
 * 
 * @author Amal.Khalil
 */
public final class ValidationBean {

	/** The empty parameter. */
	private final ArrayList<String> emptyParameter = new ArrayList<String>();

	/** The invalid parameter. */
	private final ArrayList<String> invalidParameter = new ArrayList<String>();

	/**
	 * Private Class Constructor.
	 */
	public ValidationBean() {

	}

	/**
	 * Checks if is valid.
	 * 
	 * @return true, if is valid
	 */
	public boolean isValid() {
		return emptyParameter.size() == 0 && invalidParameter.size() == 0;
	}

	/**
	 * Gets the validation message.
	 * 
	 * @return the validation message
	 */
	public String getValidationMessage() {
		String result = "Request contains some ";
		if (emptyParameter.size() > 0) {
			result += "missing parameter(s): ";
			for (int i = 0; i < emptyParameter.size(); i++) {
				result += emptyParameter.get(i) + ", ";
			}
		}
		if (invalidParameter.size() > 0) {
			result += " invalid parameter(s): ";
			for (int i = 0; i < invalidParameter.size(); i++) {
				result += invalidParameter.get(i) + ", ";
			}
		}
		return result;
	}

	/**
	 * This method will be responsible of checking that a string is empty or
	 * not.
	 * 
	 * @param paramName
	 *            the param name
	 * @param value
	 *            The input value
	 * @return boolean
	 */
	public boolean isEmpty(final String paramName, final String value) {
		boolean result = false;
		if ((value == null) || "".equals(value.trim())) {
			result = true;
			emptyParameter.add(paramName);
		}
		return result;
	}

	/**
	 * This method will be responsible of checking that a long is empty or not.
	 * 
	 * @param paramName
	 *            the param name
	 * @param value
	 *            The input value
	 * @return boolean
	 */
	public boolean isEmpty(final String paramName, final long value) {
		boolean result = false;
		if (value == 0) {
			result = true;
			emptyParameter.add(paramName);
		}
		return result;
	}

	/**
	 * This method will be responsible of checking that a double is empty or
	 * not.
	 * 
	 * @param paramName
	 *            the param name
	 * @param value
	 *            The input value
	 * @return boolean
	 */
	public boolean isEmpty(final String paramName, final double value) {
		boolean result = false;
		if (value == 0) {
			result = true;
			emptyParameter.add(paramName);
		}
		return result;
	}

	/**
	 * This method will be responsible of checking that a date is empty or not.
	 * 
	 * @param paramName
	 *            the param name
	 * @param date
	 *            The input value
	 * @return boolean
	 */
	public boolean isEmpty(final String paramName, final Date date) {
		boolean result = false;
		if (date == null) {
			result = true;
			emptyParameter.add(paramName);
		}
		return result;

	}

	/**
	 * This method will be responsible of checking that an object is empty or
	 * not.
	 * 
	 * @param paramName
	 *            the param name
	 * @param value
	 *            The input value
	 * @return boolean
	 */
	public boolean isEmpty(final String paramName, final Object value) {
		boolean result = false;
		if (value instanceof String) {
			result = isEmpty(paramName, value);
		} else if (value == null) {
			result = true;
			emptyParameter.add(paramName);
		}
		return result;
	}

	/**
	 * This method will be responsible of checking that an properties is empty
	 * or not.
	 * 
	 * @param paramName
	 *            the param name
	 * @param properties
	 *            The input value
	 * @return boolean
	 */
	public boolean isEmpty(final String paramName, final Properties properties) {
		boolean result = false;
		if (!((properties != null) && (properties.size() > 0))) {
			result = true;
			emptyParameter.add(paramName);
		}
		return result;
	}

	/**
	 * This method will be responsible of checking that an list is empty or not.
	 * 
	 * @param paramName
	 *            the param name
	 * @param list
	 *            of The input value
	 * @return boolean
	 */
	public boolean isEmpty(final String paramName, @SuppressWarnings("rawtypes") final List list) {
		boolean result = false;
		if (!((list != null) && (list.size() > 0))) {
			result = true;
			emptyParameter.add(paramName);
		}
		return result;
	}

	/**
	 * This method will be responsible of checking that an hashtable is empty or
	 * not.
	 * 
	 * @param paramName
	 *            the param name
	 * @param hashtable
	 *            The input value
	 * @return boolean
	 */
	public boolean isEmpty(final String paramName, @SuppressWarnings("rawtypes") final Hashtable hashtable) {
		boolean result = false;
		if (!((hashtable != null) && (hashtable.size() > 0))) {
			result = true;
			emptyParameter.add(paramName);
		}
		return result;

	}

	/**
	 * This method will be responsible of checking that a string is in range.
	 * 
	 * @param paramName
	 *            the param name
	 * @param value
	 *            The input value
	 * @param range
	 *            The input range
	 * @return boolean
	 */
	public boolean inRange(final String paramName, final String value, final String[] range) {
		boolean inRange = false;
		for (int i = 0; (range != null) && (i < range.length); i++) {
			if ((range[i] != null) && range[i].equalsIgnoreCase(value)) {
				inRange = true;
				return inRange;

			}
		}
		invalidParameter.add(paramName);
		return inRange;
	}

	/**
	 * This method will be responsible of checking that an integer is in range.
	 * 
	 * @param paramName
	 *            the param name
	 * @param value
	 *            The input value
	 * @param range
	 *            The input range
	 * @return boolean
	 */
	public boolean inRange(final String paramName, final int value, final int[] range) {
		boolean inRange = false;
		for (int i = 0; (range != null) && (i < range.length); i++) {
			if (range[i] == value) {
				inRange = true;
				return inRange;

			}
		}
		invalidParameter.add(paramName);
		return inRange;
	}

	/**
	 * This method will be responsible of checking that a string doesn't contain
	 * invalid characters.
	 * 
	 * @param paramName
	 *            the param name
	 * @param value
	 *            value
	 * @return boolean validation result
	 */
	public boolean isAlphanumericAndNotEmpty(final String paramName, final String value) {
		boolean result = isEmpty(paramName, value);
		if (result == false) {
			if (value.matches("^[a-zA-Z0-9\u0600-\u06FF\\s.,_-]+$")) {
				result = true;
			} else {
				invalidParameter.add(paramName);
			}
		}
		return result;
	}

	/*
	 * This method will be responsible of checking that a string doesn't contain
	 * invalid characters.
	 * 
	 * @param paramName the param name
	 * 
	 * @param value value
	 * 
	 * @return boolean validation result
	 */
	public boolean isAlphanumeric(final String paramName, final String value) {
		boolean result = true;
		if (value != null && !value.matches("^[a-zA-Z0-9\u0600-\u06FF\\s.,_-]+$")) {
			result = false;
			invalidParameter.add(paramName);
		}
		return result;
	}

	/**
	 * This method will be responsible of checking that a string doesn't exceed
	 * its max length.
	 * 
	 * @param paramName
	 *            the param name
	 * @param value
	 *            value
	 * @param length
	 *            length
	 * @return boolean validation result
	 */
	public boolean isExceedMaxLength(final String paramName, final String value, final int length) {
		boolean result = false;
		if (value.length() > length) {
			result = true;
			invalidParameter.add(paramName);
		}
		return result;
	}

	/**
	 * checks that the given string is a number.
	 * 
	 * @param paramName
	 *            the param name
	 * @param strValue
	 *            the string to be checked
	 * @return true if string represents a number.
	 */
	public boolean isNumber(final String paramName, final String strValue) {
		boolean result = true;
		try {
			Integer.parseInt(strValue);
		} catch (NumberFormatException ex) {
			result = false;
			invalidParameter.add(paramName);
		}
		return result;
	}
}
