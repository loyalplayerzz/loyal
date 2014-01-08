package com.loyal.service.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.loyal.persistence.dao.LoyalpointsDAO;
import com.loyal.persistence.dto.LoyalpointsDTO;
import com.loyal.service.pojo.LoyalPoints;

public class LoyalPointsHelper {

	@Autowired
	public LoyalpointsDAO loyalPointsDAO;
	
	public LoyalpointsDAO getLoyalPointsDAO() {
		return loyalPointsDAO;
	}

	public void setLoyalPointsDAO(LoyalpointsDAO loyalPointsDAO) {
		this.loyalPointsDAO = loyalPointsDAO;
	}

	public LoyalPoints retrieveLoyalPoint(Integer id){
		LoyalpointsDTO loyalPointsDTO = loyalPointsDAO.findById(id);
		
		if(loyalPointsDTO != null){
			return convertDTOToObject(loyalPointsDTO);
		} else {
			return null;
		}
	}
	
	public void createLoyalPoints(LoyalPoints loyalPoints){
		LoyalpointsDTO loyalPointsDTO = null;
		
		if(loyalPoints !=null){
			loyalPointsDTO = convertObjToDTO(loyalPoints);
			loyalPointsDAO.save(loyalPointsDTO);
		}
	}
	
	public List<LoyalPoints> retrieveAllLoyalPoints(){
		List<LoyalPoints> loyalPointsList = new ArrayList<LoyalPoints>();
		
		for(LoyalpointsDTO loyalPointsDTO : loyalPointsDAO.findAll()){
			loyalPointsList.add(convertDTOToObject(loyalPointsDTO));
		} 
		return loyalPointsList;
	}
	
	public LoyalPoints convertDTOToObject(LoyalpointsDTO loyalpointsDTO){
		LoyalPoints loyalPoints = new LoyalPoints();
		loyalPoints.setBet(loyalpointsDTO.getBet());
		loyalPoints.setCurrencyType(loyalpointsDTO.getCurrency());
		loyalPoints.setLoyalPoints(loyalpointsDTO.getPoints());
		
		return loyalPoints;
	}
	
	public LoyalpointsDTO convertObjToDTO(LoyalPoints loyalPoints){
		LoyalpointsDTO loyalpointsDTO = new LoyalpointsDTO();
		loyalpointsDTO.setBet(loyalPoints.getBet());
		loyalpointsDTO.setPoints(loyalPoints.getLoyalPoints());
		loyalpointsDTO.setCurrency(loyalPoints.getCurrencyType());
		
		return loyalpointsDTO;
	}
	
}
