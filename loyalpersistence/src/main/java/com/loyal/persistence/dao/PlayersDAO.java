package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.dto.PlayersDTO;

/**
 * A data access object (DAO) providing persistence and search support for
 * PlayersDTO entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.test.hibernate.PlayersDTO
 * @author MyEclipse Persistence Tools
 */
public class PlayersDAO {
	private static final Logger log = LoggerFactory.getLogger(PlayersDAO.class);
	// property constants
	public static final String ACTIVE = "active";
	public static final String EXTERNAL_USER_ID = "externalUserId";
	public static final String LOYALPOINTS_ELIGIBILE = "loyalpointsEligibile";
	public static final String BADGES_ELIGIBLE = "badgesEligible";
	public static final String AGE = "age";
	public static final String SEX = "sex";
	public static final String COUNTRY = "country";

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

	public void save(PlayersDTO transientInstance) {
		log.debug("saving PlayersDTO instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PlayersDTO persistentInstance) {
		log.debug("deleting PlayersDTO instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlayersDTO findById(java.lang.Integer id) {
		log.debug("getting PlayersDTO instance with id: " + id);
		try {
			PlayersDTO instance = (PlayersDTO) getSession().get(
					"com.test.hibernate.PlayersDTO", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PlayersDTO> findByExample(PlayersDTO instance) {
		log.debug("finding PlayersDTO instance by example");
		try {
			List<PlayersDTO> results = (List<PlayersDTO>) getSession()
					.createCriteria("com.test.hibernate.PlayersDTO")
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
		log.debug("finding PlayersDTO instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PlayersDTO as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PlayersDTO> findByActive(Object active) {
		return findByProperty(ACTIVE, active);
	}

	public List<PlayersDTO> findByExternalUserId(Object externalUserId) {
		return findByProperty(EXTERNAL_USER_ID, externalUserId);
	}

	public List<PlayersDTO> findByLoyalpointsEligibile(Object loyalpointsEligibile) {
		return findByProperty(LOYALPOINTS_ELIGIBILE, loyalpointsEligibile);
	}

	public List<PlayersDTO> findByBadgesEligible(Object badgesEligible) {
		return findByProperty(BADGES_ELIGIBLE, badgesEligible);
	}

	public List<PlayersDTO> findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List<PlayersDTO> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<PlayersDTO> findByCountry(Object country) {
		return findByProperty(COUNTRY, country);
	}

	public List findAll() {
		log.debug("finding all PlayersDTO instances");
		try {
			String queryString = "from PlayersDTO";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PlayersDTO merge(PlayersDTO detachedInstance) {
		log.debug("merging PlayersDTO instance");
		try {
			PlayersDTO result = (PlayersDTO) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PlayersDTO instance) {
		log.debug("attaching dirty PlayersDTO instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlayersDTO instance) {
		log.debug("attaching clean PlayersDTO instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}