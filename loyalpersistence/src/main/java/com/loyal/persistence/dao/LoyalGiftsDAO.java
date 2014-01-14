package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.BaseHibernateDAO;
import com.loyal.persistence.dto.LoyalGiftsDTO;


/**
 * A data access object (DAO) providing persistence and search support for
 * LoyalGifts entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.LoyalGiftsDTO.hibernate.LoyalGifts
 * @author MyEclipse Persistence Tools
 */
public class LoyalGiftsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(LoyalGiftsDAO.class);
	// property constants
	public static final String GIFT_TYPE = "giftType";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String POINTS = "points";
	public static final String IMAGE = "image";

	public void save(LoyalGiftsDTO transientInstance) {
		log.debug("saving LoyalGifts instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LoyalGiftsDTO persistentInstance) {
		log.debug("deleting LoyalGifts instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LoyalGiftsDTO findById(java.lang.Integer id) {
		log.debug("getting LoyalGifts instance with id: " + id);
		try {
			LoyalGiftsDTO instance = (LoyalGiftsDTO) getSession().get(
					"com.test.hibernate.LoyalGifts", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<LoyalGiftsDTO> findByExample(LoyalGiftsDTO instance) {
		log.debug("finding LoyalGifts instance by example");
		try {
			List<LoyalGiftsDTO> results = (List<LoyalGiftsDTO>) getSession()
					.createCriteria("com.test.hibernate.LoyalGifts")
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
		log.debug("finding LoyalGifts instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from LoyalGifts as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<LoyalGiftsDTO> findByGiftType(Object giftType) {
		return findByProperty(GIFT_TYPE, giftType);
	}

	public List<LoyalGiftsDTO> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<LoyalGiftsDTO> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List<LoyalGiftsDTO> findByPoints(Object points) {
		return findByProperty(POINTS, points);
	}

	public List<LoyalGiftsDTO> findByImage(Object image) {
		return findByProperty(IMAGE, image);
	}

	public List<LoyalGiftsDTO> findAll() {
		log.debug("finding all LoyalGifts instances");
		try {
			String queryString = "from LoyalGifts";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LoyalGiftsDTO merge(LoyalGiftsDTO detachedInstance) {
		log.debug("merging LoyalGifts instance");
		try {
			LoyalGiftsDTO result = (LoyalGiftsDTO) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LoyalGiftsDTO instance) {
		log.debug("attaching dirty LoyalGifts instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LoyalGiftsDTO instance) {
		log.debug("attaching clean LoyalGifts instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}