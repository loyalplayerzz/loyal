package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.BaseHibernateDAO;
import com.loyal.persistence.dto.ProvidersMasterDTO;


/**
 * A data access object (DAO) providing persistence and search support for
 * ProvidersMaster entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ProvidersMasterDTO.hibernate.ProvidersMaster
 * @author MyEclipse Persistence Tools
 */
public class ProvidersMasterDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ProvidersMasterDAO.class);
	// property constants
	public static final String PROVIDER_NAME = "providerName";
	public static final String DESCRIPTION = "description";
	public static final String TYPE = "type";
	public static final String ACTIVE = "active";

	public void save(ProvidersMasterDTO transientInstance) {
		log.debug("saving ProvidersMaster instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ProvidersMasterDTO persistentInstance) {
		log.debug("deleting ProvidersMaster instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProvidersMasterDTO findById(java.lang.Integer id) {
		log.debug("getting ProvidersMaster instance with id: " + id);
		try {
			ProvidersMasterDTO instance = (ProvidersMasterDTO) getSession().get(
					"com.test.hibernate.ProvidersMaster", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ProvidersMasterDTO> findByExample(ProvidersMasterDTO instance) {
		log.debug("finding ProvidersMaster instance by example");
		try {
			List<ProvidersMasterDTO> results = (List<ProvidersMasterDTO>) getSession()
					.createCriteria("com.test.hibernate.ProvidersMaster")
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
		log.debug("finding ProvidersMaster instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ProvidersMaster as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ProvidersMasterDTO> findByProviderName(Object providerName) {
		return findByProperty(PROVIDER_NAME, providerName);
	}

	public List<ProvidersMasterDTO> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List<ProvidersMasterDTO> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<ProvidersMasterDTO> findByActive(Object active) {
		return findByProperty(ACTIVE, active);
	}

	public List findAll() {
		log.debug("finding all ProvidersMaster instances");
		try {
			String queryString = "from ProvidersMaster";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ProvidersMasterDTO merge(ProvidersMasterDTO detachedInstance) {
		log.debug("merging ProvidersMaster instance");
		try {
			ProvidersMasterDTO result = (ProvidersMasterDTO) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ProvidersMasterDTO instance) {
		log.debug("attaching dirty ProvidersMaster instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProvidersMasterDTO instance) {
		log.debug("attaching clean ProvidersMaster instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}