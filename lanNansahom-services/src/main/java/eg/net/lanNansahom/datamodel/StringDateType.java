package eg.net.lanNansahom.datamodel;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

public class StringDateType implements UserType, ParameterizedType {

	protected Log log = LogFactory.getLog(this.getClass().getName());
	private String datePattern;
	private String defaultValue;

	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		if (x == y)
			return true;
		else if (x != null && x.equals(y))
			return true;
		else
			return false;
	}

	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	public boolean isMutable() {
		return false;
	}

	public Object nullSafeGet(ResultSet resultSet, String[] names, Object arg2) throws HibernateException, SQLException {
		SimpleDateFormat formatter = (SimpleDateFormat) SimpleDateFormat.getInstance();
		formatter.applyPattern(datePattern);

		Date result = null;

		String dateAsString = resultSet.getString(names[0]);

		if (!resultSet.wasNull()) {
			dateAsString = dateAsString.trim();
			try {
				result = null;
				if (dateAsString != null && !dateAsString.equals("") && !dateAsString.equals(defaultValue)) {
					result = formatter.parse(dateAsString);
				}
			} catch (ParseException e) {
				log.error("Unable to parse date", e);
				throw new HibernateException("Unable to parse date", e);
			}
		}

		return result;
	}

	public void nullSafeSet(PreparedStatement preparedStatement, Object target, int i) throws HibernateException,
			SQLException {
		String value = defaultValue;
		if (preparedStatement != null && target != null) {
			try {
				SimpleDateFormat formatter = (SimpleDateFormat) SimpleDateFormat.getInstance();
				formatter.applyPattern(datePattern);
				value = formatter.format(target);
			} catch (Exception e) {
				log.error("Unable to formate date", e);
				throw new HibernateException("Unable to formate date", e);
			}
		}
		preparedStatement.setString(i, value);
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

	public Class returnedClass() {
		return java.util.Date.class;
	}

	public int[] sqlTypes() {
		return new int[] { Types.VARCHAR };
	}

	public void setParameterValues(Properties arg0) {
		String pattern = arg0.getProperty("datePattern");
		if (pattern != null) {
			this.datePattern = pattern;
		}

		String defaultValue = arg0.getProperty("defaultValue");
		if (defaultValue != null) {
			this.defaultValue = defaultValue;
		}
	}
}
