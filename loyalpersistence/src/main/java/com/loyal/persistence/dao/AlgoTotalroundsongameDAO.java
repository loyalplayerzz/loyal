package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.dto.AlgoTotalroundsongameDTO;

/**
 * A data access object (DAO) providing persistence and search support for
 * AlgoTotalroundsongameDTO entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.AlgoTotalroundsongameDTODTO.hibernate.AlgoTotalroundsongameDTO
 * @author MyEclipse Persistence Tools
 */
public class AlgoTotalroundsongameDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AlgoTotalroundsongameDAO.class);
	// property constants
	public static final String PROVIDER_NAME = "providerName";
	public static final String NO_OF_ROUNDS = "noOfRounds";
	public static final String NAME_OF_GAMES = "nameOfGames";

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

	public void save(AlgoTotalroundsongameDTO transientInstance) {
		log.debug("saving AlgoTotalroundsongameDTO instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AlgoTotalroundsongameDTO persistentInstance) {
		log.debug("deleting AlgoTotalroundsongameDTO instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlgoTotalroundsongameDTO findById(java.lang.Integer id) {
		log.debug("getting AlgoTotalroundsongameDTO instance with id: " + id);
		try {
			AlgoTotalroundsongameDTO instance = (AlgoTotalroundsongameDTO) getSession()
					.get("com.test.hibernate.AlgoTotalroundsongameDTO", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<AlgoTotalroundsongameDTO> findByExample(
			AlgoTotalroundsongameDTO instance) {
		log.debug("finding AlgoTotalroundsongameDTO instance by example");
		try {
			List<AlgoTotalroundsongameDTO> results = (List<AlgoTotalroundsongameDTO>) getSession()
					.createCriteria("com.test.hibernate.AlgoTotalroundsongameDTO")
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
		log.debug("finding AlgoTotalroundsongameDTO instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AlgoTotalroundsongameDTO as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AlgoTotalroundsongameDTO> findByProviderName(Object providerName) {
		return findByProperty(PROVIDER_NAME, providerName);
	}

	public List<AlgoTotalroundsongameDTO> findByNoOfRounds(Object noOfRounds) {
		return findByProperty(NO_OF_ROUNDS, noOfRounds);
	}

	public List<AlgoTotalroundsongameDTO> findByNameOfGames(Object nameOfGames) {
		return findByProperty(NAME_OF_GAMES, nameOfGames);
	}

	public List findAll() {
		log.debug("finding all AlgoTotalroundsongameDTO instances");
		try {
			String queryString = "from AlgoTotalroundsongameDTO";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AlgoTotalroundsongameDTO merge(AlgoTotalroundsongameDTO detachedInstance) {
		log.debug("merging AlgoTotalroundsongameDTO instance");
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
		log.debug("attaching dirty AlgoTotalroundsongameDTO instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlgoTotalroundsongameDTO instance) {
		log.debug("attaching clean AlgoTotalroundsongameDTO instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}