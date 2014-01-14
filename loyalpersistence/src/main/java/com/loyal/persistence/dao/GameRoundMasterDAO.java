package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.BaseHibernateDAO;
import com.loyal.persistence.dto.GameRoundMasterDTO;

/**
 * A data access object (DAO) providing persistence and search support for
 * GameRoundMaster entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.GameRoundMasterDTO.hibernate.GameRoundMaster
 * @author MyEclipse Persistence Tools
 */
public class GameRoundMasterDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(GameRoundMasterDAO.class);
	// property constants
	public static final String GAME_ID = "gameId";
	public static final String GAME_ROUND_ID = "gameRoundId";
	public static final String TRANSACTION_TYPE = "transactionType";
	public static final String CASINO_CURRENCY_BET = "casinoCurrencyBet";
	public static final String CASINO_CURRENCY_WIN = "casinoCurrencyWin";
	public static final String PLAYER_ID = "playerId";
	public static final String ANALYZED_BADGES = "analyzedBadges";
	public static final String GAME_PROVIDER = "gameProvider";

	public void save(GameRoundMasterDTO transientInstance) {
		log.debug("saving GameRoundMaster instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(GameRoundMasterDTO persistentInstance) {
		log.debug("deleting GameRoundMaster instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GameRoundMasterDTO findById(java.lang.Integer id) {
		log.debug("getting GameRoundMaster instance with id: " + id);
		try {
			GameRoundMasterDTO instance = (GameRoundMasterDTO) getSession().get(
					"com.test.hibernate.GameRoundMaster", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<GameRoundMasterDTO> findByExample(GameRoundMasterDTO instance) {
		log.debug("finding GameRoundMaster instance by example");
		try {
			List<GameRoundMasterDTO> results = (List<GameRoundMasterDTO>) getSession()
					.createCriteria("com.test.hibernate.GameRoundMaster")
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
		log.debug("finding GameRoundMaster instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from GameRoundMaster as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<GameRoundMasterDTO> findByGameId(Object gameId) {
		return findByProperty(GAME_ID, gameId);
	}

	public List<GameRoundMasterDTO> findByGameRoundId(Object gameRoundId) {
		return findByProperty(GAME_ROUND_ID, gameRoundId);
	}

	public List<GameRoundMasterDTO> findByTransactionType(Object transactionType) {
		return findByProperty(TRANSACTION_TYPE, transactionType);
	}

	public List<GameRoundMasterDTO> findByCasinoCurrencyBet(
			Object casinoCurrencyBet) {
		return findByProperty(CASINO_CURRENCY_BET, casinoCurrencyBet);
	}

	public List<GameRoundMasterDTO> findByCasinoCurrencyWin(
			Object casinoCurrencyWin) {
		return findByProperty(CASINO_CURRENCY_WIN, casinoCurrencyWin);
	}

	public List<GameRoundMasterDTO> findByPlayerId(Object playerId) {
		return findByProperty(PLAYER_ID, playerId);
	}

	public List<GameRoundMasterDTO> findByAnalyzedBadges(Object analyzedBadges) {
		return findByProperty(ANALYZED_BADGES, analyzedBadges);
	}

	public List<GameRoundMasterDTO> findByGameProvider(Object gameProvider) {
		return findByProperty(GAME_PROVIDER, gameProvider);
	}

	public List findAll() {
		log.debug("finding all GameRoundMaster instances");
		try {
			String queryString = "from GameRoundMaster";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GameRoundMasterDTO merge(GameRoundMasterDTO detachedInstance) {
		log.debug("merging GameRoundMaster instance");
		try {
			GameRoundMasterDTO result = (GameRoundMasterDTO) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GameRoundMasterDTO instance) {
		log.debug("attaching dirty GameRoundMaster instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GameRoundMasterDTO instance) {
		log.debug("attaching clean GameRoundMaster instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}