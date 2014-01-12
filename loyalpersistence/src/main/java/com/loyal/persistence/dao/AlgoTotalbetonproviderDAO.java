package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.BaseHibernateDAO;
import com.loyal.persistence.dto.AlgoTotalbetonproviderDTO;

/**
 * A data access object (DAO) providing persistence and search support for
 * AlgoTotalbetonprovider entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.AlgoTotalbetonproviderDTO.hibernate.AlgoTotalbetonprovider
 * @author MyEclipse Persistence Tools
 */
public class AlgoTotalbetonproviderDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AlgoTotalbetonproviderDAO.class);
	// property constants
	public static final String ALGO_ID = "algoId";
	public static final String PROVIDERS = "providers";
	public static final String GAMES = "games";
	public static final String BET_AMOUNT = "betAmount";
	public static final String NO_OF_DAYS = "noOfDays";

	public void save(AlgoTotalbetonproviderDTO transientInstance) {
		log.debug("saving AlgoTotalbetonprovider instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AlgoTotalbetonproviderDTO persistentInstance) {
		log.debug("deleting AlgoTotalbetonprovider instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlgoTotalbetonproviderDTO findById(java.lang.Integer id) {
		log.debug("getting AlgoTotalbetonprovider instance with id: " + id);
		try {
			AlgoTotalbetonproviderDTO instance = (AlgoTotalbetonproviderDTO) getSession()
					.get("com.test.hibernate.AlgoTotalbetonprovider", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<AlgoTotalbetonproviderDTO> findByExample(
			AlgoTotalbetonproviderDTO instance) {
		log.debug("finding AlgoTotalbetonprovider instance by example");
		try {
			List<AlgoTotalbetonproviderDTO> results = (List<AlgoTotalbetonproviderDTO>) getSession()
					.createCriteria("com.test.hibernate.AlgoTotalbetonprovider")
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
		log.debug("finding AlgoTotalbetonprovider instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AlgoTotalbetonprovider as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AlgoTotalbetonproviderDTO> findByAlgoId(Object algoId) {
		return findByProperty(ALGO_ID, algoId);
	}

	public List<AlgoTotalbetonproviderDTO> findByProviders(Object providers) {
		return findByProperty(PROVIDERS, providers);
	}

	public List<AlgoTotalbetonproviderDTO> findByGames(Object games) {
		return findByProperty(GAMES, games);
	}

	public List<AlgoTotalbetonproviderDTO> findByBetAmount(Object betAmount) {
		return findByProperty(BET_AMOUNT, betAmount);
	}

	public List<AlgoTotalbetonproviderDTO> findByNoOfDays(Object noOfDays) {
		return findByProperty(NO_OF_DAYS, noOfDays);
	}

	public List findAll() {
		log.debug("finding all AlgoTotalbetonprovider instances");
		try {
			String queryString = "from AlgoTotalbetonprovider";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AlgoTotalbetonproviderDTO merge(AlgoTotalbetonproviderDTO detachedInstance) {
		log.debug("merging AlgoTotalbetonprovider instance");
		try {
			AlgoTotalbetonproviderDTO result = (AlgoTotalbetonproviderDTO) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AlgoTotalbetonproviderDTO instance) {
		log.debug("attaching dirty AlgoTotalbetonprovider instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlgoTotalbetonproviderDTO instance) {
		log.debug("attaching clean AlgoTotalbetonprovider instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}