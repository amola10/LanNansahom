package eg.net.lanNansahom.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import eg.net.lanNansahom.dao.MartyrDao;
import eg.net.lanNansahom.datamodel.Martyr;
import eg.net.lanNansahom.datamodel.SearchVictimsCriteria;
import eg.net.utilties.ValidationBean;

public class MartyrDaoImpl extends VictimDao implements MartyrDao {

	public void addMartyr(Martyr martyr) {
		getHibernateTemplate().save(martyr);
	}

	public void updateMartyr(Martyr martyr) {
		getHibernateTemplate().saveOrUpdate(martyr);
	}

	public Martyr getMartyrById(int id) {
		return getHibernateTemplate().get(Martyr.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.dao.MartyrDao#deleteMartyr(eg.net.lanNansahom.datamodel
	 * .Martyr)
	 */
	public void deleteMartyr(Martyr martyr) {
		getHibernateTemplate().delete(martyr);
	}

	@SuppressWarnings("unchecked")
	public List<Martyr> searchMartyr(final SearchVictimsCriteria pCriteria) {
		return (List<Martyr>) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				ValidationBean bean = new ValidationBean();
				Criteria criteria = session.createCriteria(Martyr.class);
				List<Criterion> restrictions = new ArrayList<Criterion>();
				if (bean.isEmpty("", pCriteria.getId()) == false) {
					restrictions.add(Restrictions.eq("id", pCriteria.getId()));
				}
				if (bean.isEmpty("", pCriteria.getName()) == false) {
					for (String keyword : extractKeyWords(pCriteria.getName())) {
						restrictions.add(Restrictions.sqlRestriction("this_2_.name rlike '" + keyword + "'"));
					}
				}
				if (bean.isEmpty("", pCriteria.getAreaId()) == false) {
					restrictions.add(Restrictions.eq("deathArea.id", pCriteria.getAreaId()));
				}

				if (bean.isEmpty("", pCriteria.getAge()) == false) {
					restrictions.add(Restrictions.eq("age", pCriteria.getAge()));
				}

				if (bean.isEmpty("", pCriteria.getEducationId()) == false) {
					restrictions.add(Restrictions.eq("education.id", pCriteria.getEducationId()));
				}

				if (bean.isEmpty("", pCriteria.getJobId()) == false) {
					restrictions.add(Restrictions.eq("job.id", pCriteria.getJobId()));
				}

				if (bean.isEmpty("", pCriteria.getRecordStatusId()) == false) {
					restrictions.add(Restrictions.eq("recordStatus.id", pCriteria.getRecordStatusId()));
				}
				if (bean.isEmpty("", pCriteria.getDate()) == false) {
					restrictions.add(Restrictions.eq("deathDate", pCriteria.getDate()));
				}

				if (bean.isEmpty("", pCriteria.isPublished()) == false) {
					restrictions.add(Restrictions.eq("published", pCriteria.isPublished().booleanValue()));
				}

				if (restrictions.size() > 0) {
					Criterion finalCondition = restrictions.get(0);
					for (int i = 1; i < restrictions.size(); i++) {
						finalCondition = Restrictions.and(finalCondition, restrictions.get(i));

					}
					criteria.add(finalCondition);
				}

				criteria.addOrder(Order.asc("name"));
				return criteria.list();
			}

		});
	}

}
