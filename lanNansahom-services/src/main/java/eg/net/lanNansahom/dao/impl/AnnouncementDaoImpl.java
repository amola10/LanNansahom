package eg.net.lanNansahom.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import eg.net.lanNansahom.dao.AnnouncementDao;
import eg.net.lanNansahom.datamodel.Announcement;

public class AnnouncementDaoImpl extends BaseHibernateDao implements AnnouncementDao {

	public void addAnnouncement(Announcement announcement) {
		getHibernateTemplate().save(announcement);

	}

	public void updteAnnouncement(Announcement announcement) {
		getHibernateTemplate().update(announcement);
	}

	@SuppressWarnings("unchecked")
	public List<Announcement> getAllAnnouncement() {
		return getHibernateTemplate().loadAll(Announcement.class);
	}

	@SuppressWarnings("unchecked")
	public List<Announcement> getPublishedAnnouncement() {
		Criteria criteria = this.getSession().createCriteria(Announcement.class);
		criteria.add(Restrictions.eq("published", true));
		criteria.addOrder(Order.desc("date"));
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.lanNansahom.dao.AnnouncementDao#getAnnouncementById(int)
	 */
	public Announcement getAnnouncementById(int id) {
		return getHibernateTemplate().get(Announcement.class, id);
	}

}
