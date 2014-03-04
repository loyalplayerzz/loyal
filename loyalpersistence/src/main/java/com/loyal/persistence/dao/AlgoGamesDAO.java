package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.dto.AlgoGamesDTO;

/**
 * A data access object (DAO) providing persistence and search support for
 * AlgoGames entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.AlgoGamesDTO.hibernate.AlgoGames
 * @author MyEclipse Persistence Tools
 */
public class AlgoGamesDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AlgoGamesDAO.class);
	// property constants
	public static final String ALGO_ID = "algoId";
	public static final String ALGO_TYPE = "algoType";
	public static final String GAME = "game";
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


	public void save(AlgoGamesDTO transientInstance) {
		log.debug("saving AlgoGames instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AlgoGamesDTO persistentInstance) {
		log.debug("deleting AlgoGames instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlgoGamesDTO findById(java.lang.Integer id) {
		log.debug("getting AlgoGames instance with id: " + id);
		try {
			AlgoGamesDTO instance = (AlgoGamesDTO) getSession().get(
					"com.test.hibernate.AlgoGames", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<AlgoGamesDTO> findByExample(AlgoGamesDTO instance) {
		log.debug("finding AlgoGames instance by example");
		try {
			List<AlgoGamesDTO> results = (List<AlgoGamesDTO>) getSession()
					.createCriteria("com.test.hibernate.AlgoGames")
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
		log.debug("finding AlgoGames instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AlgoGames as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AlgoGamesDTO> findByAlgoId(Object algoId) {
		return findByProperty(ALGO_ID, algoId);
	}

	public List<AlgoGamesDTO> findByAlgoType(Object algoType) {
		return findByProperty(ALGO_TYPE, algoType);
	}

	public List<AlgoGamesDTO> findByGame(Object game) {
		return findByProperty(GAME, game);
	}

	public List<AlgoGamesDTO> findByActive(Object active) {
		return findByProperty(ACTIVE, active);
	}

	public List findAll() {
		log.debug("finding all AlgoGames instances");
		try {
			String queryString = "from AlgoGames";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AlgoGamesDTO merge(AlgoGamesDTO detachedInstance) {
		log.debug("merging AlgoGames instance");
		try {
			AlgoGamesDTO result = (AlgoGamesDTO) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AlgoGamesDTO instance) {
		log.debug("attaching dirty AlgoGames instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlgoGamesDTO instance) {
		log.debug("attaching clean AlgoGames instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}