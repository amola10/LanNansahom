package eg.net.lanNansahom.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import eg.net.lanNansahom.dao.LookupDao;
import eg.net.lanNansahom.datamodel.Lookup;

/**
 * The Class LookupDaoImpl.
 */
public class LookupDaoImpl extends BaseHibernateDao implements LookupDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.lanNansahom.dao.LookupDao#getAll(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public List<? extends Lookup> getAll(final Class<? extends Lookup> lookupClazz) {
		return (List<? extends Lookup>) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(lookupClazz);
				criteria.addOrder(Order.asc("name"));
				return criteria.list();
			}

		});

	}

	public void addLookup(Lookup lookup) {
		getHibernateTemplate().save(lookup);
	}

	public void updateLookup(Lookup lookup) {
		getHibernateTemplate().update(lookup);
	}

	public Lookup getLookupById(Class<? extends Lookup> clazz, int id) {
		return getHibernateTemplate().get(clazz, id);
	}

}
