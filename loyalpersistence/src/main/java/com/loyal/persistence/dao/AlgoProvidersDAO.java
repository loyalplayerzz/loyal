package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.dto.AlgoProvidersDTO;

/**
 * A data access object (DAO) providing persistence and search support for
 * AlgoProviders entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.AlgoProvidersDTO.hibernate.AlgoProviders
 * @author MyEclipse Persistence Tools
 */
public class AlgoProvidersDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AlgoProvidersDAO.class);
	// property constants
	public static final String ALGO_ID = "algoId";
	public static final String ALGO_TYPE = "algoType";
	public static final String PROVIDER = "provider";
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


	public void save(AlgoProvidersDTO transientInstance) {
		log.debug("saving AlgoProviders instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AlgoProvidersDTO persistentInstance) {
		log.debug("deleting AlgoProviders instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlgoProvidersDTO findById(java.lang.Integer id) {
		log.debug("getting AlgoProviders instance with id: " + id);
		try {
			AlgoProvidersDTO instance = (AlgoProvidersDTO) getSession().get(
					"com.test.hibernate.AlgoProviders", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<AlgoProvidersDTO> findByExample(AlgoProvidersDTO instance) {
		log.debug("finding AlgoProviders instance by example");
		try {
			List<AlgoProvidersDTO> results = (List<AlgoProvidersDTO>) getSession()
					.createCriteria("com.test.hibernate.AlgoProviders")
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
		log.debug("finding AlgoProviders instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AlgoProviders as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AlgoProvidersDTO> findByAlgoId(Object algoId) {
		return findByProperty(ALGO_ID, algoId);
	}

	public List<AlgoProvidersDTO> findByAlgoType(Object algoType) {
		return findByProperty(ALGO_TYPE, algoType);
	}

	public List<AlgoProvidersDTO> findByProvider(Object provider) {
		return findByProperty(PROVIDER, provider);
	}

	public List<AlgoProvidersDTO> findByActive(Object active) {
		return findByProperty(ACTIVE, active);
	}

	public List findAll() {
		log.debug("finding all AlgoProviders instances");
		try {
			String queryString = "from AlgoProviders";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AlgoProvidersDTO merge(AlgoProvidersDTO detachedInstance) {
		log.debug("merging AlgoProviders instance");
		try {
			AlgoProvidersDTO result = (AlgoProvidersDTO) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AlgoProvidersDTO instance) {
		log.debug("attaching dirty AlgoProviders instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlgoProvidersDTO instance) {
		log.debug("attaching clean AlgoProviders instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}