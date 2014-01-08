package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.loyal.persistence.dto.AlgorithmDTO;

/**
 	* A data access object (DAO) providing persistence and search support for Algorithm entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.test.hibernate.Algorithm
  * @author MyEclipse Persistence Tools 
 */
@Transactional
public class AlgorithmDAO {
	
	private SessionFactory sessionFactory;
	
    public SessionFactory getSessionFactory() {
	return sessionFactory;
}
    
    private Session getSession(){
		return sessionFactory.getCurrentSession();
	}

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}

	     private static final Logger log = LoggerFactory.getLogger(AlgorithmDAO.class);
		//property constants
	public static final String PARAM_TABLE = "paramTable";
	public static final String DESCRIPTION = "description";



    
    public void save(AlgorithmDTO transientInstance) {
        log.debug("saving Algorithm instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlgorithmDTO persistentInstance) {
        log.debug("deleting Algorithm instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlgorithmDTO findById( java.lang.Integer id) {
        log.debug("getting Algorithm instance with id: " + id);
        try {
        	AlgorithmDTO instance = (AlgorithmDTO) getSession()
                    .get(AlgorithmDTO.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlgorithmDTO> findByExample(AlgorithmDTO instance) {
        log.debug("finding Algorithm instance by example");
        try {
            List<AlgorithmDTO> results = (List<AlgorithmDTO>) getSession()
                    .createCriteria(AlgorithmDTO.class)
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
      log.debug("finding Algorithm instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Algorithm as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlgorithmDTO> findByParamTable(Object paramTable
	) {
		return findByProperty(PARAM_TABLE, paramTable
		);
	}
	
	public List<AlgorithmDTO> findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	

	public List<AlgorithmDTO> findAll() {
		log.debug("finding all Algorithm instances");
		try {
			String queryString = "from Algorithm";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlgorithmDTO merge(AlgorithmDTO detachedInstance) {
        log.debug("merging Algorithm instance");
        try {
        	AlgorithmDTO result = (AlgorithmDTO) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlgorithmDTO instance) {
        log.debug("attaching dirty Algorithm instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlgorithmDTO instance) {
        log.debug("attaching clean Algorithm instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}