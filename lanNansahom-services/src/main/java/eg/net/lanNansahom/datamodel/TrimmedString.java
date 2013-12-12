package eg.net.lanNansahom.datamodel;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

/**
 * @author Colin Hawkett
 */
public class TrimmedString implements UserType {

	public TrimmedString() {
		super();
	}

	public int[] sqlTypes() {
		return new int[] { Types.CHAR };
	}

	public Class returnedClass() {
		return String.class;
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		return (x == y) || (x != null && y != null && (x.equals(y)));
	}

	public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
		String val = rs.getString(names[0]);
		if (val != null)
			return val.trim();
		else
			return val;
	}

	public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
		st.setString(index, (String) value);
	}

	public Object deepCopy(Object value) throws HibernateException {
		if (value == null)
			return null;
		return new String((String) value);
	}

	public boolean isMutable() {
		return false;
	}

	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}
}