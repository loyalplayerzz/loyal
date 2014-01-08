package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.dto.BadgeLoyalgiftDTO;

/**
 	* A data access object (DAO) providing persistence and search support for BadgeLoyalgiftDTO entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.test.hibernate.BadgeLoyalgiftDTO
  * @author MyEclipse Persistence Tools 
 */
public class BadgeLoyalgiftDAO {
	     private static final Logger log = LoggerFactory.getLogger(BadgeLoyalgiftDAO.class);
		//property constants
	public static final String BADGE_ID = "badgeId";
	public static final String LOYAL_GIFT_ID = "loyalGiftId";


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

    
    public void save(BadgeLoyalgiftDTO transientInstance) {
        log.debug("saving BadgeLoyalgiftDTO instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(BadgeLoyalgiftDTO persistentInstance) {
        log.debug("deleting BadgeLoyalgiftDTO instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public BadgeLoyalgiftDTO findById( java.lang.Integer id) {
        log.debug("getting BadgeLoyalgiftDTO instance with id: " + id);
        try {
            BadgeLoyalgiftDTO instance = (BadgeLoyalgiftDTO) getSession()
                    .get("com.test.hibernate.BadgeLoyalgiftDTO", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<BadgeLoyalgiftDTO> findByExample(BadgeLoyalgiftDTO instance) {
        log.debug("finding BadgeLoyalgiftDTO instance by example");
        try {
            List<BadgeLoyalgiftDTO> results = (List<BadgeLoyalgiftDTO>) getSession()
                    .createCriteria("com.test.hibernate.BadgeLoyalgiftDTO")
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
      log.debug("finding BadgeLoyalgiftDTO instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from BadgeLoyalgiftDTO as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<BadgeLoyalgiftDTO> findByBadgeId(Object badgeId
	) {
		return findByProperty(BADGE_ID, badgeId
		);
	}
	
	public List<BadgeLoyalgiftDTO> findByLoyalGiftId(Object loyalGiftId
	) {
		return findByProperty(LOYAL_GIFT_ID, loyalGiftId
		);
	}
	

	public List findAll() {
		log.debug("finding all BadgeLoyalgiftDTO instances");
		try {
			String queryString = "from BadgeLoyalgiftDTO";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public BadgeLoyalgiftDTO merge(BadgeLoyalgiftDTO detachedInstance) {
        log.debug("merging BadgeLoyalgiftDTO instance");
        try {
            BadgeLoyalgiftDTO result = (BadgeLoyalgiftDTO) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(BadgeLoyalgiftDTO instance) {
        log.debug("attaching dirty BadgeLoyalgiftDTO instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(BadgeLoyalgiftDTO instance) {
        log.debug("attaching clean BadgeLoyalgiftDTO instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}