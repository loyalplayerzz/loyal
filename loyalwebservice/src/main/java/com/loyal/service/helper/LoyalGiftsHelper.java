package com.loyal.service.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.loyal.persistence.dao.LoyalGiftsDAO;
import com.loyal.persistence.dto.LoyalGiftsDTO;
import com.loyal.service.pojo.LoyalGifts;

public class LoyalGiftsHelper {

	//@Autowired
	public LoyalGiftsDAO loyalGiftsDAO ;

	public LoyalGiftsDAO getLoyalGiftsDAO() {
		return loyalGiftsDAO;
	}

	public void setLoyalGiftsDAO(LoyalGiftsDAO loyalGiftDAO) {
		this.loyalGiftsDAO = loyalGiftDAO;
	}

	public LoyalGifts retrieveLoyalGift(String name){
		LoyalGiftsDTO loyalGiftsDTO = (LoyalGiftsDTO) loyalGiftsDAO.findByName(name);
		
		if(loyalGiftsDTO != null){
			return convertDTOToObject(loyalGiftsDTO);
		} else {
			return null;
		}
	}
	
	public void createLoyalGifts(LoyalGifts loyalGifts){
		LoyalGiftsDTO loyalGiftsDTO = null;
		
		if(loyalGifts !=null){
			loyalGiftsDTO = convertObjToDTO(loyalGifts);
			loyalGiftsDAO.save(loyalGiftsDTO);
		}
	}
	
	public List<LoyalGifts> retrieveAllLoyalGifts(){
		List<LoyalGifts> loyalGiftsList = new ArrayList<LoyalGifts>();
		
		for(LoyalGiftsDTO loyalGiftsDTO : loyalGiftsDAO.findAll()){
			loyalGiftsList.add(convertDTOToObject(loyalGiftsDTO));
		} 
		return loyalGiftsList;
	}
	
	public LoyalGifts convertDTOToObject(LoyalGiftsDTO loyalGiftsDTO){
		LoyalGifts loyalGifts = new LoyalGifts();
		loyalGifts.setDescription(loyalGiftsDTO.getDescription());
		loyalGifts.setGiftType(loyalGiftsDTO.getGiftType());
		loyalGifts.setLevelPoints(loyalGiftsDTO.getPoints());
		loyalGifts.setImageURL(loyalGiftsDTO.getImage());
		
		//TODO level and badges need to be mapped
		return loyalGifts;
	}
	
	public LoyalGiftsDTO convertObjToDTO(LoyalGifts loyalGifts){
		LoyalGiftsDTO loyalGiftsDTO = new LoyalGiftsDTO();
		loyalGiftsDTO.setDescription(loyalGifts.getDescription());
		loyalGiftsDTO.setGiftType(loyalGifts.getGiftType());
		loyalGiftsDTO.setImage(loyalGifts.getImageURL());
		loyalGiftsDTO.setName(loyalGifts.getName());
		loyalGiftsDTO.setPoints(loyalGifts.getLevelPoints());
		
		return loyalGiftsDTO;
	}
	


}
