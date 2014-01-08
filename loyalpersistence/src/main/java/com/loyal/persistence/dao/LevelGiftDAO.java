package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.dto.LevelGiftDTO;

/**
 	* A data access object (DAO) providing persistence and search support for LevelGift entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.test.hibernate.LevelGift
  * @author MyEclipse Persistence Tools 
 */
public class LevelGiftDAO  {
	     private static final Logger log = LoggerFactory.getLogger(LevelGiftDAO.class);
		//property constants
	public static final String LEVEL_ID = "levelId";
	public static final String GIFT_ID = "giftId";

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    
    public void save(LevelGiftDTO transientInstance) {
        log.debug("saving LevelGift instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(LevelGiftDTO persistentInstance) {
        log.debug("deleting LevelGift instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public LevelGiftDTO findById( java.lang.Integer id) {
        log.debug("getting LevelGift instance with id: " + id);
        try {
        	LevelGiftDTO instance = (LevelGiftDTO) getSession()
                    .get(LevelGiftDTO.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<LevelGiftDTO> findByExample(LevelGiftDTO instance) {
        log.debug("finding LevelGift instance by example");
        try {
            List<LevelGiftDTO> results = (List<LevelGiftDTO>) getSession()
                    .createCriteria("com.test.hibernate.LevelGift")
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding LevelGift instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from LevelGift as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<LevelGiftDTO> findByLevelId(Object levelId
	) {
		return findByProperty(LEVEL_ID, levelId
		);
	}
	
	public List<LevelGiftDTO> findByGiftId(Object giftId
	) {
		return findByProperty(GIFT_ID, giftId
		);
	}
	

	public List findAll() {
		log.debug("finding all LevelGift instances");
		try {
			String queryString = "from LevelGift";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public LevelGiftDTO merge(LevelGiftDTO detachedInstance) {
        log.debug("merging LevelGift instance");
        try {
        	LevelGiftDTO result = (LevelGiftDTO) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(LevelGiftDTO instance) {
        log.debug("attaching dirty LevelGift instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(LevelGiftDTO instance) {
        log.debug("attaching clean LevelGift instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}