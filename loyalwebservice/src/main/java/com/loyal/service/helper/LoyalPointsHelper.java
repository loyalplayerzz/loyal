package com.loyal.service.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.loyal.persistence.dao.LoyalpointsMasterDAO;
import com.loyal.persistence.dto.LoyalpointsMasterDTO;
import com.loyal.service.pojo.LoyalPoints;

public class LoyalPointsHelper {

	@Autowired
	public LoyalpointsMasterDAO loyalPointsDAO;
	
	public LoyalpointsMasterDAO getLoyalPointsDAO() {
		return loyalPointsDAO;
	}

	public void setLoyalPointsDAO(LoyalpointsMasterDAO loyalPointsDAO) {
		this.loyalPointsDAO = loyalPointsDAO;
	}

	public LoyalPoints retrieveLoyalPoint(Integer id){
		LoyalpointsMasterDTO loyalPointsDTO = loyalPointsDAO.findById(id);
		
		if(loyalPointsDTO != null){
			return convertDTOToObject(loyalPointsDTO);
		} else {
			return null;
		}
	}
	
	public void createLoyalPoints(LoyalPoints loyalPoints){
		LoyalpointsMasterDTO loyalPointsDTO = null;
		
		if(loyalPoints !=null){
			loyalPointsDTO = convertObjToDTO(loyalPoints);
			loyalPointsDAO.save(loyalPointsDTO);
		}
	}
	
	public void updateLoyalPoints(LoyalPoints loyalPoints){
		LoyalpointsMasterDTO loyalPointsDTO = null;
		
		if(loyalPoints !=null){
			loyalPointsDTO = convertObjToDTO(loyalPoints);
			loyalPointsDAO.merge(loyalPointsDTO);
		}
	}
	
	public List<LoyalPoints> retrieveAllLoyalPoints(){
		List<LoyalPoints> loyalPointsList = new ArrayList<LoyalPoints>();
		
		for(LoyalpointsMasterDTO loyalPointsDTO : loyalPointsDAO.findAll()){
			loyalPointsList.add(convertDTOToObject(loyalPointsDTO));
		} 
		return loyalPointsList;
	}
	
	public LoyalPoints convertDTOToObject(LoyalpointsMasterDTO loyalpointsDTO){
		LoyalPoints loyalPoints = new LoyalPoints();
		loyalPoints.setBet(loyalpointsDTO.getBet());
		loyalPoints.setLoyalPointsID(loyalpointsDTO.getId());
		loyalPoints.setCurrencyType(loyalpointsDTO.getCurrency());
		loyalPoints.setLoyalPoints(loyalpointsDTO.getPoints());
		
		return loyalPoints;
	}
	
	public LoyalpointsMasterDTO convertObjToDTO(LoyalPoints loyalPoints){
		LoyalpointsMasterDTO loyalpointsDTO = new LoyalpointsMasterDTO();
		loyalpointsDTO.setBet(loyalPoints.getBet());
		loyalpointsDTO.setId(loyalPoints.getLoyalPointsID());
		loyalpointsDTO.setPoints(loyalPoints.getLoyalPoints());
		loyalpointsDTO.setCurrency(loyalPoints.getCurrencyType());
		
		return loyalpointsDTO;
	}
	
}
