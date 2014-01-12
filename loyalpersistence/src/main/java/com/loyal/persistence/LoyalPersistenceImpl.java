package com.loyal.persistence;

import com.loyal.persistence.dao.LevelMasterDAO;
import com.loyal.persistence.dao.LoyalpointsMasterDAO;
import com.loyal.persistence.dto.LevelMasterDTO;
import com.loyal.persistence.dto.LoyalpointsMasterDTO;


public class LoyalPersistenceImpl implements LoyalPersistence {
	
	public LevelMasterDAO levelDAO;
	
	public LoyalpointsMasterDAO loyalPointsDAO;

	public LoyalpointsMasterDAO getLoyalPointsDAO() {
		return loyalPointsDAO;
	}

	public void setLoyalPointsDAO(LoyalpointsMasterDAO loyalPointsDAO) {
		this.loyalPointsDAO = loyalPointsDAO;
	}

	public LevelMasterDAO getLevelDAO() {
		return levelDAO;
	}

	public void setLevelDAO(LevelMasterDAO levelDAO) {
		this.levelDAO = levelDAO;
	}

	@Override
	public LevelMasterDTO insertLevel(LevelMasterDTO levelDTO) {
		LevelMasterDTO insertedLevelDTO = levelDAO.merge(levelDTO);
		return insertedLevelDTO;
	}

	@Override
	public LoyalpointsMasterDTO insertLoyalPoints(LoyalpointsMasterDTO loyalPointsDTO) {
		LoyalpointsMasterDTO insertedLoyalPointsDTO = loyalPointsDAO.merge(loyalPointsDTO);
		return insertedLoyalPointsDTO;
	}

	@Override
	public LevelMasterDTO updateLevel(LevelMasterDTO levelDTO) {
		LevelMasterDTO updatedLevelDTO = levelDAO.merge(levelDTO);
		return updatedLevelDTO;
	}

	@Override
	public LoyalpointsMasterDTO updateLoyalpointsDTO(LoyalpointsMasterDTO loyalpointsDTO) {
		LoyalpointsMasterDTO updatedLoyalPointsDTO = loyalPointsDAO.merge(loyalpointsDTO);
		return updatedLoyalPointsDTO;
	}

	@Override
	public LevelMasterDTO retrieveLevel(Integer levelID) {
		LevelMasterDTO levelDTO = levelDAO.findById(levelID);
		return levelDTO;
	}

	@Override
	public LoyalpointsMasterDTO retrieveLoyalPoints(Integer loyalPointsId) {
		LoyalpointsMasterDTO loyalPointsDTO = loyalPointsDAO.findById(loyalPointsId);
		return loyalPointsDTO;
	}

}
