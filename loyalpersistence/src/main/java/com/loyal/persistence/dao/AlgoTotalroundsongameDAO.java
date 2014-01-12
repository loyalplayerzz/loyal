package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.BaseHibernateDAO;
import com.loyal.persistence.dto.AlgoTotalroundsongameDTO;

/**
 * A data access object (DAO) providing persistence and search support for
 * AlgoTotalroundsongame entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.AlgoTotalroundsongameDTO.hibernate.AlgoTotalroundsongame
 * @author MyEclipse Persistence Tools
 */
public class AlgoTotalroundsongameDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AlgoTotalroundsongameDAO.class);
	// property constants
	public static final String ALGO_ID = "algoId";
	public static final String PROVIDERS = "providers";
	public static final String GAMES = "games";
	public static final String NO_OF_GAME_ROUNDS = "noOfGameRounds";
	public static final String NO_OF_DAYS = "noOfDays";

	public void save(AlgoTotalroundsongameDTO transientInstance) {
		log.debug("saving AlgoTotalroundsongame instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AlgoTotalroundsongameDTO persistentInstance) {
		log.debug("deleting AlgoTotalroundsongame instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlgoTotalroundsongameDTO findById(java.lang.Integer id) {
		log.debug("getting AlgoTotalroundsongame instance with id: " + id);
		try {
			AlgoTotalroundsongameDTO instance = (AlgoTotalroundsongameDTO) getSession()
					.get("com.test.hibernate.AlgoTotalroundsongame", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<AlgoTotalroundsongameDTO> findByExample(
			AlgoTotalroundsongameDTO instance) {
		log.debug("finding AlgoTotalroundsongame instance by example");
		try {
			List<AlgoTotalroundsongameDTO> results = (List<AlgoTotalroundsongameDTO>) getSession()
					.createCriteria("com.test.hibernate.AlgoTotalroundsongame")
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
		log.debug("finding AlgoTotalroundsongame instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AlgoTotalroundsongame as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AlgoTotalroundsongameDTO> findByAlgoId(Object algoId) {
		return findByProperty(ALGO_ID, algoId);
	}

	public List<AlgoTotalroundsongameDTO> findByProviders(Object providers) {
		return findByProperty(PROVIDERS, providers);
	}

	public List<AlgoTotalroundsongameDTO> findByGames(Object games) {
		return findByProperty(GAMES, games);
	}

	public List<AlgoTotalroundsongameDTO> findByNoOfGameRounds(
			Object noOfGameRounds) {
		return findByProperty(NO_OF_GAME_ROUNDS, noOfGameRounds);
	}

	public List<AlgoTotalroundsongameDTO> findByNoOfDays(Object noOfDays) {
		return findByProperty(NO_OF_DAYS, noOfDays);
	}

	public List findAll() {
		log.debug("finding all AlgoTotalroundsongame instances");
		try {
			String queryString = "from AlgoTotalroundsongame";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AlgoTotalroundsongameDTO merge(AlgoTotalroundsongameDTO detachedInstance) {
		log.debug("merging AlgoTotalroundsongame instance");
		try {
			AlgoTotalroundsongameDTO result = (AlgoTotalroundsongameDTO) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AlgoTotalroundsongameDTO instance) {
		log.debug("attaching dirty AlgoTotalroundsongame instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlgoTotalroundsongameDTO instance) {
		log.debug("attaching clean AlgoTotalroundsongame instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}