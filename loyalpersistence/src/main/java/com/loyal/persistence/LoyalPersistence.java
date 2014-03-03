package com.loyal.persistence;
import com.loyal.persistence.dto.LevelMasterDTO;
import com.loyal.persistence.dto.LoyalpointsMasterDTO;


public interface LoyalPersistence {
	
	public LevelMasterDTO insertLevel(LevelMasterDTO levelMasterDTO);
	
	public LoyalpointsMasterDTO insertLoyalPoints(LoyalpointsMasterDTO loyalPointsDTO);
	
	public LevelMasterDTO updateLevel(LevelMasterDTO levelDTO);
	
	public LoyalpointsMasterDTO updateLoyalpointsDTO(LoyalpointsMasterDTO loyalpointsDTO);
	
	public LevelMasterDTO retrieveLevel(Integer levelID);
	
	public LoyalpointsMasterDTO retrieveLoyalPoints(Integer loyalPointsId);

}
