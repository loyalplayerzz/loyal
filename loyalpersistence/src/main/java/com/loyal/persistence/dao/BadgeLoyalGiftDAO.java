package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.BaseHibernateDAO;
import com.loyal.persistence.dto.BadgeLoyalGiftDTO;

/**
 * A data access object (DAO) providing persistence and search support for
 * BadgeLoyalGift entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.BadgeLoyalGiftDTO.hibernate.BadgeLoyalGift
 * @author MyEclipse Persistence Tools
 */
public class BadgeLoyalGiftDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BadgeLoyalGiftDAO.class);
	// property constants
	public static final String BADGE_ID = "badgeId";
	public static final String LOYAL_GIFT_ID = "loyalGiftId";

	public void save(BadgeLoyalGiftDTO transientInstance) {
		log.debug("saving BadgeLoyalGift instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BadgeLoyalGiftDTO persistentInstance) {
		log.debug("deleting BadgeLoyalGift instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BadgeLoyalGiftDTO findById(java.lang.Integer id) {
		log.debug("getting BadgeLoyalGift instance with id: " + id);
		try {
			BadgeLoyalGiftDTO instance = (BadgeLoyalGiftDTO) getSession().get(
					"com.test.hibernate.BadgeLoyalGift", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BadgeLoyalGiftDTO> findByExample(BadgeLoyalGiftDTO instance) {
		log.debug("finding BadgeLoyalGift instance by example");
		try {
			List<BadgeLoyalGiftDTO> results = (List<BadgeLoyalGiftDTO>) getSession()
					.createCriteria("com.test.hibernate.BadgeLoyalGift")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BadgeLoyalGift instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BadgeLoyalGift as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BadgeLoyalGiftDTO> findByBadgeId(Object badgeId) {
		return findByProperty(BADGE_ID, badgeId);
	}

	public List<BadgeLoyalGiftDTO> findByLoyalGiftId(Object loyalGiftId) {
		return findByProperty(LOYAL_GIFT_ID, loyalGiftId);
	}

	public List findAll() {
		log.debug("finding all BadgeLoyalGift instances");
		try {
			String queryString = "from BadgeLoyalGift";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BadgeLoyalGiftDTO merge(BadgeLoyalGiftDTO detachedInstance) {
		log.debug("merging BadgeLoyalGift instance");
		try {
			BadgeLoyalGiftDTO result = (BadgeLoyalGiftDTO) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BadgeLoyalGiftDTO instance) {
		log.debug("attaching dirty BadgeLoyalGift instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BadgeLoyalGiftDTO instance) {
		log.debug("attaching clean BadgeLoyalGift instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}