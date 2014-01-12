package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.BaseHibernateDAO;
import com.loyal.persistence.dto.AlgorithmMasterDTO;

/**
 * A data access object (DAO) providing persistence and search support for
 * AlgorithmMaster entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.AlgorithmMasterDTO.hibernate.AlgorithmMaster
 * @author MyEclipse Persistence Tools
 */
public class AlgorithmMasterDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AlgorithmMasterDAO.class);
	// property constants
	public static final String PARAM_TABLE = "paramTable";
	public static final String DESCRIPTION = "description";

	public void save(AlgorithmMasterDTO transientInstance) {
		log.debug("saving AlgorithmMaster instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AlgorithmMasterDTO persistentInstance) {
		log.debug("deleting AlgorithmMaster instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlgorithmMasterDTO findById(java.lang.Integer id) {
		log.debug("getting AlgorithmMaster instance with id: " + id);
		try {
			AlgorithmMasterDTO instance = (AlgorithmMasterDTO) getSession().get(
					"com.test.hibernate.AlgorithmMaster", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<AlgorithmMasterDTO> findByExample(AlgorithmMasterDTO instance) {
		log.debug("finding AlgorithmMaster instance by example");
		try {
			List<AlgorithmMasterDTO> results = (List<AlgorithmMasterDTO>) getSession()
					.createCriteria("com.test.hibernate.AlgorithmMaster")
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
		log.debug("finding AlgorithmMaster instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AlgorithmMaster as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AlgorithmMasterDTO> findByParamTable(Object paramTable) {
		return findByProperty(PARAM_TABLE, paramTable);
	}

	public List<AlgorithmMasterDTO> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all AlgorithmMaster instances");
		try {
			String queryString = "from AlgorithmMaster";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AlgorithmMasterDTO merge(AlgorithmMasterDTO detachedInstance) {
		log.debug("merging AlgorithmMaster instance");
		try {
			AlgorithmMasterDTO result = (AlgorithmMasterDTO) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AlgorithmMasterDTO instance) {
		log.debug("attaching dirty AlgorithmMaster instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlgorithmMasterDTO instance) {
		log.debug("attaching clean AlgorithmMaster instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}