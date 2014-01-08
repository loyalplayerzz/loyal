package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.dto.PlayersBadgeDTO;

/**
 * A data access object (DAO) providing persistence and search support for
 * PlayersBadge entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.PlayersBadgeDTO.hibernate.PlayersBadge
 * @author MyEclipse Persistence Tools
 */
public class PlayersBadgeDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PlayersBadgeDAO.class);
	// property constants
	public static final String PLAYER_ID = "playerId";
	public static final String BADGE_ID = "badgeId";
	public static final String CREATED_BY = "createdBy";
	public static final String UPDATED_BY = "updatedBy";

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

	public void save(PlayersBadgeDTO transientInstance) {
		log.debug("saving PlayersBadge instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PlayersBadgeDTO persistentInstance) {
		log.debug("deleting PlayersBadge instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlayersBadgeDTO findById(java.lang.Integer id) {
		log.debug("getting PlayersBadge instance with id: " + id);
		try {
			PlayersBadgeDTO instance = (PlayersBadgeDTO) getSession().get(
					"com.test.hibernate.PlayersBadge", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PlayersBadgeDTO> findByExample(PlayersBadgeDTO instance) {
		log.debug("finding PlayersBadge instance by example");
		try {
			List<PlayersBadgeDTO> results = (List<PlayersBadgeDTO>) getSession()
					.createCriteria("com.test.hibernate.PlayersBadge")
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
		log.debug("finding PlayersBadge instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PlayersBadge as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PlayersBadgeDTO> findByPlayerId(Object playerId) {
		return findByProperty(PLAYER_ID, playerId);
	}

	public List<PlayersBadgeDTO> findByBadgeId(Object badgeId) {
		return findByProperty(BADGE_ID, badgeId);
	}

	public List<PlayersBadgeDTO> findByCreatedBy(Object createdBy) {
		return findByProperty(CREATED_BY, createdBy);
	}

	public List<PlayersBadgeDTO> findByUpdatedBy(Object updatedBy) {
		return findByProperty(UPDATED_BY, updatedBy);
	}

	public List findAll() {
		log.debug("finding all PlayersBadge instances");
		try {
			String queryString = "from PlayersBadge";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PlayersBadgeDTO merge(PlayersBadgeDTO detachedInstance) {
		log.debug("merging PlayersBadge instance");
		try {
			PlayersBadgeDTO result = (PlayersBadgeDTO) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PlayersBadgeDTO instance) {
		log.debug("attaching dirty PlayersBadge instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlayersBadgeDTO instance) {
		log.debug("attaching clean PlayersBadge instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}