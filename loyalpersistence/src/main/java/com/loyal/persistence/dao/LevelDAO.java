package com.loyal.persistence.dao;
// default package

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

import com.loyal.persistence.dto.LevelDTO;

/**
 	* A data access object (DAO) providing persistence and search support for Level entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Level
  * @author MyEclipse Persistence Tools 
 */
@Transactional
public class LevelDAO {
	
	private SessionFactory sessionFactory;
	
	     public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

		private static final Logger log = LoggerFactory.getLogger(LevelDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String DESCRIPTION_EN = "descriptionEn";
	public static final String DESCRIPTION_SV = "descriptionSv";
	public static final String POINTS = "points";
	public static final String IMAGE = "image";


	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}

    
    public void save(LevelDTO transientInstance) {
        log.debug("saving Level instance");
        try {
        	getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(LevelDTO persistentInstance) {
        log.debug("deleting Level instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public LevelDTO findById( java.lang.Integer id) {
        log.debug("getting Level instance with id: " + id);
        try {
        	LevelDTO instance = (LevelDTO)getSession().get(LevelDTO.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public Integer getLevelIDFromPoints(Integer points){
    	
    	List<LevelDTO> levelList = getSession().createCriteria(LevelDTO.class).add(Restrictions.gt("points", points)).list();
		
		if(levelList==null || levelList.isEmpty()){
			return 1;
		} else {
			return levelList.get(0).getId()-1;
		}
		
	}
    
    public List<LevelDTO> findByExample(LevelDTO instance) {
        log.debug("finding Level instance by example");
        try {
            List<LevelDTO> results = (List<LevelDTO>) getSession()
                    .createCriteria("Level")
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
      log.debug("finding Level instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Level as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<LevelDTO> findByNumber(Object number
	) {
		return findByProperty(NUMBER, number
		);
	}
	
	public List<LevelDTO> findByDescriptionEn(Object descriptionEn
	) {
		return findByProperty(DESCRIPTION_EN, descriptionEn
		);
	}
	
	public List<LevelDTO> findByDescriptionSv(Object descriptionSv
	) {
		return findByProperty(DESCRIPTION_SV, descriptionSv
		);
	}
	
	public List<LevelDTO> findByPoints(Object points
	) {
		return findByProperty(POINTS, points
		);
	}
	
	public List<LevelDTO> findByImage(Object image
	) {
		return findByProperty(IMAGE, image
		);
	}
	

	public List<LevelDTO> findAll() {
		log.debug("finding all Level instances");
		try {
			Query levelQuery = getSession().createQuery("from "+LevelDTO.class.getName());
			List<LevelDTO> levelList = levelQuery.list();
			//String queryString = "from Level";
	         //Query queryObject = getSession().createQuery(queryString);
			 return levelList;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public LevelDTO merge(LevelDTO detachedInstance) {
        log.debug("merging Level instance");
        try {
        	LevelDTO result = (LevelDTO) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(LevelDTO instance) {
        log.debug("attaching dirty Level instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(LevelDTO instance) {
        log.debug("attaching clean Level instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}