package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.BaseHibernateDAO;
import com.loyal.persistence.dto.PlayersLevelDTO;


/**
 * A data access object (DAO) providing persistence and search support for
 * PlayersLevel entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.PlayersLevelDTO.hibernate.PlayersLevel
 * @author MyEclipse Persistence Tools
 */
public class PlayersLevelDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PlayersLevelDAO.class);
	// property constants
	public static final String PLAYER_ID = "playerId";
	public static final String LEVEL_ID = "levelId";
	public static final String CREATED_BY = "createdBy";
	public static final String UPDATED_BY = "updatedBy";

	public void save(PlayersLevelDTO transientInstance) {
		log.debug("saving PlayersLevel instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PlayersLevelDTO persistentInstance) {
		log.debug("deleting PlayersLevel instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlayersLevelDTO findById(java.lang.Integer id) {
		log.debug("getting PlayersLevel instance with id: " + id);
		try {
			PlayersLevelDTO instance = (PlayersLevelDTO) getSession().get(
					"com.test.hibernate.PlayersLevel", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PlayersLevelDTO> findByExample(PlayersLevelDTO instance) {
		log.debug("finding PlayersLevel instance by example");
		try {
			List<PlayersLevelDTO> results = (List<PlayersLevelDTO>) getSession()
					.createCriteria("com.test.hibernate.PlayersLevel")
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
		log.debug("finding PlayersLevel instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PlayersLevel as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PlayersLevelDTO> findByPlayerId(Object playerId) {
		return findByProperty(PLAYER_ID, playerId);
	}

	public List<PlayersLevelDTO> findByLevelId(Object levelId) {
		return findByProperty(LEVEL_ID, levelId);
	}

	public List<PlayersLevelDTO> findByCreatedBy(Object createdBy) {
		return findByProperty(CREATED_BY, createdBy);
	}

	public List<PlayersLevelDTO> findByUpdatedBy(Object updatedBy) {
		return findByProperty(UPDATED_BY, updatedBy);
	}

	public List findAll() {
		log.debug("finding all PlayersLevel instances");
		try {
			String queryString = "from PlayersLevel";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PlayersLevelDTO merge(PlayersLevelDTO detachedInstance) {
		log.debug("merging PlayersLevel instance");
		try {
			PlayersLevelDTO result = (PlayersLevelDTO) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PlayersLevelDTO instance) {
		log.debug("attaching dirty PlayersLevel instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlayersLevelDTO instance) {
		log.debug("attaching clean PlayersLevel instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}