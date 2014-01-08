package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.dto.PlayersLoyalpointsDTO;

/**
 	* A data access object (DAO) providing persistence and search support for PlayersLoyalpointsDTO entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.test.hibernate.PlayersLoyalpointsDTO
  * @author MyEclipse Persistence Tools 
 */
public class PlayersLoyalpointsDAO {
	     private static final Logger log = LoggerFactory.getLogger(PlayersLoyalpointsDAO.class);
		//property constants
	public static final String PLAYER_ID = "playerId";
	public static final String LOYALPOINTS_ID = "loyalpointsId";
	public static final String CREATED_BY = "createdBy";
	public static final String UPDATED_BY = "updatedBy";

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

    
    public void save(PlayersLoyalpointsDTO transientInstance) {
        log.debug("saving PlayersLoyalpointsDTO instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PlayersLoyalpointsDTO persistentInstance) {
        log.debug("deleting PlayersLoyalpointsDTO instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PlayersLoyalpointsDTO findById( java.lang.Integer id) {
        log.debug("getting PlayersLoyalpointsDTO instance with id: " + id);
        try {
            PlayersLoyalpointsDTO instance = (PlayersLoyalpointsDTO) getSession()
                    .get("com.test.hibernate.PlayersLoyalpointsDTO", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<PlayersLoyalpointsDTO> findByExample(PlayersLoyalpointsDTO instance) {
        log.debug("finding PlayersLoyalpointsDTO instance by example");
        try {
            List<PlayersLoyalpointsDTO> results = (List<PlayersLoyalpointsDTO>) getSession()
                    .createCriteria("com.test.hibernate.PlayersLoyalpointsDTO")
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
      log.debug("finding PlayersLoyalpointsDTO instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PlayersLoyalpointsDTO as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<PlayersLoyalpointsDTO> findByPlayerId(Object playerId
	) {
		return findByProperty(PLAYER_ID, playerId
		);
	}
	
	public List<PlayersLoyalpointsDTO> findByLoyalpointsId(Object loyalpointsId
	) {
		return findByProperty(LOYALPOINTS_ID, loyalpointsId
		);
	}
	
	public List<PlayersLoyalpointsDTO> findByCreatedBy(Object createdBy
	) {
		return findByProperty(CREATED_BY, createdBy
		);
	}
	
	public List<PlayersLoyalpointsDTO> findByUpdatedBy(Object updatedBy
	) {
		return findByProperty(UPDATED_BY, updatedBy
		);
	}
	

	public List findAll() {
		log.debug("finding all PlayersLoyalpointsDTO instances");
		try {
			String queryString = "from PlayersLoyalpointsDTO";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PlayersLoyalpointsDTO merge(PlayersLoyalpointsDTO detachedInstance) {
        log.debug("merging PlayersLoyalpointsDTO instance");
        try {
            PlayersLoyalpointsDTO result = (PlayersLoyalpointsDTO) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PlayersLoyalpointsDTO instance) {
        log.debug("attaching dirty PlayersLoyalpointsDTO instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PlayersLoyalpointsDTO instance) {
        log.debug("attaching clean PlayersLoyalpointsDTO instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}