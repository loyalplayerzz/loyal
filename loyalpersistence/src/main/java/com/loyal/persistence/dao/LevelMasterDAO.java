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

import com.loyal.persistence.dto.LevelMasterDTO;


/**
 * A data access object (DAO) providing persistence and search support for
 * LevelMaster entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.LevelMasterDTO.hibernate.LevelMaster
 * @author MyEclipse Persistence Tools
 */
public class LevelMasterDAO {
	private static final Logger log = LoggerFactory
			.getLogger(LevelMasterDAO.class);
	// property constants
	public static final String DESCRIPTION = "description";
	public static final String LEVEL_POINTS = "levelPoints";
	public static final String IMAGE = "image";

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

	
	public void save(LevelMasterDTO transientInstance) {
		log.debug("saving LevelMaster instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LevelMasterDTO persistentInstance) {
		log.debug("deleting LevelMaster instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LevelMasterDTO findById(java.lang.Integer id) {
		log.debug("getting LevelMaster instance with id: " + id);
		try {
			LevelMasterDTO instance = (LevelMasterDTO) getSession().get(
					"com.test.hibernate.LevelMaster", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public Integer getLevelIDFromPoints(Integer points){
        List<LevelMasterDTO> levelList = getSession().createCriteria(LevelMasterDTO.class).add(Restrictions.gt("points", points)).list();
                if(levelList==null || levelList.isEmpty()){
                        return 1;
                } else {
                        return levelList.get(0).getId()-1;
                }
        }


	public List<LevelMasterDTO> findByExample(LevelMasterDTO instance) {
		log.debug("finding LevelMaster instance by example");
		try {
			List<LevelMasterDTO> results = (List<LevelMasterDTO>) getSession()
					.createCriteria("com.test.hibernate.LevelMaster")
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
		log.debug("finding LevelMaster instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from LevelMaster as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<LevelMasterDTO> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List<LevelMasterDTO> findByLevelPoints(Object levelPoints) {
		return findByProperty(LEVEL_POINTS, levelPoints);
	}

	public List<LevelMasterDTO> findByImage(Object image) {
		return findByProperty(IMAGE, image);
	}

	public List<LevelMasterDTO> findAll() {
		log.debug("finding all LevelMaster instances");
		try {
			String queryString = "from LevelMaster";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LevelMasterDTO merge(LevelMasterDTO detachedInstance) {
		log.debug("merging LevelMaster instance");
		try {
			LevelMasterDTO result = (LevelMasterDTO) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LevelMasterDTO instance) {
		log.debug("attaching dirty LevelMaster instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LevelMasterDTO instance) {
		log.debug("attaching clean LevelMaster instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}