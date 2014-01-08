package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.loyal.persistence.dto.LoyalpointsDTO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Loyalpoints entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.LoyalpointsDTO.hibernate.Loyalpoints
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class LoyalpointsDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	private static final Logger log = LoggerFactory
			.getLogger(LoyalpointsDAO.class);
	// property constants
	public static final String BET = "bet";
	public static final String CURRENCY = "currency";
	public static final String POINTS = "points";

	public void save(LoyalpointsDTO transientInstance) {
		log.debug("saving Loyalpoints instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LoyalpointsDTO persistentInstance) {
		log.debug("deleting Loyalpoints instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public Integer getPointIDBasedOnBet(Integer bet){
	
		List<LoyalpointsDTO> loyalPointsList= getSession().createCriteria(LoyalpointsDTO.class).add(Restrictions.gt("bet", bet)).list();
		
		if(loyalPointsList == null || loyalPointsList.isEmpty()){
			return 1;
		} else {
			return loyalPointsList.get(0).getId() - 1;
		}
	}
	
	public List<LoyalpointsDTO> findAll() {
		log.debug("finding all Level instances");
		try {
			Query loyalPointsQuery = getSession().createQuery("from "+LoyalpointsDTO.class.getName());
			List<LoyalpointsDTO> loyalpointsDTOs = loyalPointsQuery.list();
			 return loyalpointsDTOs;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LoyalpointsDTO findById(java.lang.Integer id) {
		log.debug("getting Loyalpoints instance with id: " + id);
		try {
			LoyalpointsDTO instance = (LoyalpointsDTO) getSession().get(
					"com.test.hibernate.Loyalpoints", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<LoyalpointsDTO> findByExample(LoyalpointsDTO instance) {
		log.debug("finding Loyalpoints instance by example");
		try {
			List<LoyalpointsDTO> results = (List<LoyalpointsDTO>) getSession()
					.createCriteria("com.test.hibernate.Loyalpoints")
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
		log.debug("finding Loyalpoints instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Loyalpoints as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<LoyalpointsDTO> findByBet(Object bet) {
		return findByProperty(BET, bet);
	}

	public List<LoyalpointsDTO> findByCurrency(Object currency) {
		return findByProperty(CURRENCY, currency);
	}

	public List<LoyalpointsDTO> findByPoints(Object points) {
		return findByProperty(POINTS, points);
	}

	public LoyalpointsDTO merge(LoyalpointsDTO detachedInstance) {
		log.debug("merging Loyalpoints instance");
		try {
			LoyalpointsDTO result = (LoyalpointsDTO) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LoyalpointsDTO instance) {
		log.debug("attaching dirty Loyalpoints instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LoyalpointsDTO instance) {
		log.debug("attaching clean Loyalpoints instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}