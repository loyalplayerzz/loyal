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

import com.loyal.persistence.dto.LoyalpointsMasterDTO;


/**
 * A data access object (DAO) providing persistence and search support for
 * LoyalpointsMaster entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.LoyalpointsMasterDTO.hibernate.LoyalpointsMaster
 * @author MyEclipse Persistence Tools
 */
public class LoyalpointsMasterDAO {
	private static final Logger log = LoggerFactory
			.getLogger(LoyalpointsMasterDAO.class);
	// property constants
	public static final String BET = "bet";
	public static final String CURRENCY = "currency";
	public static final String POINTS = "points";
	
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


	public void save(LoyalpointsMasterDTO transientInstance) {
		log.debug("saving LoyalpointsMaster instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LoyalpointsMasterDTO persistentInstance) {
		log.debug("deleting LoyalpointsMaster instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LoyalpointsMasterDTO findById(java.lang.Integer id) {
		log.debug("getting LoyalpointsMaster instance with id: " + id);
		try {
			LoyalpointsMasterDTO instance = (LoyalpointsMasterDTO) getSession().get(
					LoyalpointsMasterDTO.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<LoyalpointsMasterDTO> findByExample(LoyalpointsMasterDTO instance) {
		log.debug("finding LoyalpointsMaster instance by example");
		try {
			List<LoyalpointsMasterDTO> results = (List<LoyalpointsMasterDTO>) getSession()
					.createCriteria(LoyalpointsMasterDTO.class)
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
		log.debug("finding LoyalpointsMaster instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from LoyalpointsMaster as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<LoyalpointsMasterDTO> findByBet(Object bet) {
		return findByProperty(BET, bet);
	}

	public List<LoyalpointsMasterDTO> findByCurrency(Object currency) {
		return findByProperty(CURRENCY, currency);
	}

	public List<LoyalpointsMasterDTO> findByPoints(Object points) {
		return findByProperty(POINTS, points);
	}

	public List<LoyalpointsMasterDTO> findAll() {
		log.debug("finding all LoyalpointsMaster instances");
		try {
			String queryString = "from LoyalpointsMasterDTO";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	 public Integer getPointIDBasedOnBet(Double bet){
         List<LoyalpointsMasterDTO> loyalPointsList= getSession().createCriteria(LoyalpointsMasterDTO.class).add(Restrictions.gt("bet", bet)).list();
         if(loyalPointsList == null || loyalPointsList.isEmpty()){
                 return 1;
         } else {
                 return loyalPointsList.get(0).getId() - 1;
         }
 }


	public LoyalpointsMasterDTO merge(LoyalpointsMasterDTO detachedInstance) {
		log.debug("merging LoyalpointsMaster instance");
		try {
			LoyalpointsMasterDTO result = (LoyalpointsMasterDTO) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LoyalpointsMasterDTO instance) {
		log.debug("attaching dirty LoyalpointsMaster instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LoyalpointsMasterDTO instance) {
		log.debug("attaching clean LoyalpointsMaster instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}