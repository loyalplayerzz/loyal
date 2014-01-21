package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.dto.BadgeDetailsDTO;

/**
 * A data access object (DAO) providing persistence and search support for
 * BadgeDetails entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.BadgeDetailsDTO.hibernate.BadgeDetails
 * @author MyEclipse Persistence Tools
 */
public class BadgeDetailsDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BadgeDetailsDAO.class);
	// property constants
	public static final String BADGE_NAME = "badgeName";
	public static final String BADGE_DESCRIPTION = "badgeDescription";
	public static final String ALGO_TYPE = "algoType";
	public static final String ALGO_ID = "algoId";
	public static final String ACTIVE = "active";

	 private SessionFactory sessionFactory;

     public SessionFactory getSessionFactory() {
             return sessionFactory;
     }

     public void setSessionFactory(SessionFactory sessionFactory) {
             this.sessionFactory = sessionFactory;
     }

     private Session getSession() {
             return sessionFactory.getCurrentSession();
     }

	
	public void save(BadgeDetailsDTO transientInstance) {
		log.debug("saving BadgeDetails instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BadgeDetailsDTO persistentInstance) {
		log.debug("deleting BadgeDetails instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BadgeDetailsDTO findById(java.lang.Integer id) {
		log.debug("getting BadgeDetails instance with id: " + id);
		try {
			BadgeDetailsDTO instance = (BadgeDetailsDTO) getSession().get(
					"com.test.hibernate.BadgeDetails", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BadgeDetailsDTO> findByExample(BadgeDetailsDTO instance) {
		log.debug("finding BadgeDetails instance by example");
		try {
			List<BadgeDetailsDTO> results = (List<BadgeDetailsDTO>) getSession()
					.createCriteria("com.test.hibernate.BadgeDetails")
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
		log.debug("finding BadgeDetails instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BadgeDetails as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BadgeDetailsDTO> findByBadgeName(Object badgeName) {
		return findByProperty(BADGE_NAME, badgeName);
	}

	public List<BadgeDetailsDTO> findByBadgeDescription(Object badgeDescription) {
		return findByProperty(BADGE_DESCRIPTION, badgeDescription);
	}

	public List<BadgeDetailsDTO> findByAlgoType(Object algoType) {
		return findByProperty(ALGO_TYPE, algoType);
	}

	public List<BadgeDetailsDTO> findByAlgoId(Object algoId) {
		return findByProperty(ALGO_ID, algoId);
	}

	public List<BadgeDetailsDTO> findByActive(Object active) {
		return findByProperty(ACTIVE, active);
	}

	public List<BadgeDetailsDTO> findAll() {
		log.debug("finding all BadgeDetails instances");
		try {
			String queryString = "from BadgeDetails";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BadgeDetailsDTO merge(BadgeDetailsDTO detachedInstance) {
		log.debug("merging BadgeDetails instance");
		try {
			BadgeDetailsDTO result = (BadgeDetailsDTO) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BadgeDetailsDTO instance) {
		log.debug("attaching dirty BadgeDetails instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BadgeDetailsDTO instance) {
		log.debug("attaching clean BadgeDetails instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}