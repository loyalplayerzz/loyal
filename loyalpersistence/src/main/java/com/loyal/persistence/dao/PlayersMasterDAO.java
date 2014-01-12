package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.BaseHibernateDAO;
import com.loyal.persistence.dto.PlayersMasterDTO;


/**
 * A data access object (DAO) providing persistence and search support for
 * PlayersMaster entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.PlayersMasterDTO.hibernate.PlayersMaster
 * @author MyEclipse Persistence Tools
 */
public class PlayersMasterDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PlayersMasterDAO.class);
	// property constants
	public static final String ACTIVE = "active";
	public static final String EXTERNAL_USER_ID = "externalUserId";
	public static final String BET_AMT = "betAmt";
	public static final String LOYALPOINTS_ELIGIBILE = "loyalpointsEligibile";
	public static final String BADGES_ELIGIBLE = "badgesEligible";
	public static final String SEX = "sex";
	public static final String COUNTRY = "country";

	public void save(PlayersMasterDTO transientInstance) {
		log.debug("saving PlayersMaster instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PlayersMasterDTO persistentInstance) {
		log.debug("deleting PlayersMaster instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlayersMasterDTO findById(java.lang.Integer id) {
		log.debug("getting PlayersMaster instance with id: " + id);
		try {
			PlayersMasterDTO instance = (PlayersMasterDTO) getSession().get(
					"com.test.hibernate.PlayersMaster", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PlayersMasterDTO> findByExample(PlayersMasterDTO instance) {
		log.debug("finding PlayersMaster instance by example");
		try {
			List<PlayersMasterDTO> results = (List<PlayersMasterDTO>) getSession()
					.createCriteria("com.test.hibernate.PlayersMaster")
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
		log.debug("finding PlayersMaster instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PlayersMaster as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PlayersMasterDTO> findByActive(Object active) {
		return findByProperty(ACTIVE, active);
	}

	public List<PlayersMasterDTO> findByExternalUserId(Object externalUserId) {
		return findByProperty(EXTERNAL_USER_ID, externalUserId);
	}

	public List<PlayersMasterDTO> findByBetAmt(Object betAmt) {
		return findByProperty(BET_AMT, betAmt);
	}

	public List<PlayersMasterDTO> findByLoyalpointsEligibile(
			Object loyalpointsEligibile) {
		return findByProperty(LOYALPOINTS_ELIGIBILE, loyalpointsEligibile);
	}

	public List<PlayersMasterDTO> findByBadgesEligible(Object badgesEligible) {
		return findByProperty(BADGES_ELIGIBLE, badgesEligible);
	}

	public List<PlayersMasterDTO> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<PlayersMasterDTO> findByCountry(Object country) {
		return findByProperty(COUNTRY, country);
	}

	public List findAll() {
		log.debug("finding all PlayersMaster instances");
		try {
			String queryString = "from PlayersMaster";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PlayersMasterDTO merge(PlayersMasterDTO detachedInstance) {
		log.debug("merging PlayersMaster instance");
		try {
			PlayersMasterDTO result = (PlayersMasterDTO) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PlayersMasterDTO instance) {
		log.debug("attaching dirty PlayersMaster instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlayersMasterDTO instance) {
		log.debug("attaching clean PlayersMaster instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}