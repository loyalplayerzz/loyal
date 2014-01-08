package com.loyal.service.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.loyal.persistence.dao.BadgeDetailsDAO;
import com.loyal.persistence.dao.BadgeLoyalgiftDAO;
import com.loyal.persistence.dao.LoyalGiftsDAO;
import com.loyal.persistence.dto.BadgeDetailsDTO;
import com.loyal.persistence.dto.BadgeLoyalgiftDTO;
import com.loyal.persistence.dto.LoyalGiftsDTO;
import com.loyal.service.pojo.Badge;

public class BadgeHelper {

	@Autowired
	public BadgeDetailsDAO badgeDetailDAO;

	public BadgeDetailsDAO getBadgeDetailDAO() {
		return badgeDetailDAO;
	}

	public void setBadgeDetailDAO(BadgeDetailsDAO badgeDetailDAO) {
		this.badgeDetailDAO = badgeDetailDAO;
	}

	@Autowired
	public BadgeLoyalgiftDAO badgeLoyalGiftDAO;
	
	public BadgeLoyalgiftDAO getBadgeLoyalGiftDAO() {
		return badgeLoyalGiftDAO;
	}

	public void setBadgeLoyalGiftDAO(BadgeLoyalgiftDAO badgeLoyalGiftDAO) {
		this.badgeLoyalGiftDAO = badgeLoyalGiftDAO;
	}
	
	@Autowired
	public LoyalGiftsDAO loyalGiftsDAO;

	public LoyalGiftsDAO getLoyalGiftsDAO() {
		return loyalGiftsDAO;
	}

	public void setLoyalGiftsDAO(LoyalGiftsDAO loyalGiftsDAO) {
		this.loyalGiftsDAO = loyalGiftsDAO;
	}

	public Badge retrieveBadgeDetails(String badgeName){
		List<BadgeDetailsDTO> badgeDetailsDTOList = badgeDetailDAO.findByBadgeName(badgeName);
		
		if(badgeDetailsDTOList != null && badgeDetailsDTOList.size() > 0){
			BadgeLoyalgiftDTO badgeGiftDTO = (BadgeLoyalgiftDTO) badgeLoyalGiftDAO.findByBadgeId(badgeDetailsDTOList.get(0).getId());
			return convertDTOToObject(badgeDetailsDTOList.get(0), badgeGiftDTO);
		} else {
			return null;
		}
	}
	
	public void createBadgeDetails(Badge badge){
		BadgeDetailsDTO badgeDetailsDTO = null;
		
		if(badge !=null){
			HashMap<BadgeDetailsDTO, BadgeLoyalgiftDTO> badgeMap = convertObjToDTO(badge);
			
			for(BadgeDetailsDTO badgeDTO : badgeMap.keySet()){
				badgeDetailDAO.save(badgeDetailsDTO);
				badgeLoyalGiftDAO.save(badgeMap.get(badgeDTO));
			}
		
		}
	}
	
	public List<Badge> retrieveAllBadgeDetails(){
		List<Badge> badgeDetailList = new ArrayList<Badge>();
		
		for(BadgeDetailsDTO badgeDetailDTO : badgeDetailDAO.findAll()){
			BadgeLoyalgiftDTO badgeGiftDTO = (BadgeLoyalgiftDTO) badgeLoyalGiftDAO.findByBadgeId(badgeDetailDTO.getId());
			badgeDetailList.add(convertDTOToObject(badgeDetailDTO, badgeGiftDTO));
		} 
		return badgeDetailList;
	}
	
	public Badge convertDTOToObject(BadgeDetailsDTO badgeDetailsDTO, BadgeLoyalgiftDTO badgeGiftDTO){
		Badge badge = new Badge();
		badge.setBadgeName(badgeDetailsDTO.getBadgeName());
		badge.setBadgeDescription(badgeDetailsDTO.getBadgeDescription());
		badge.setAlgorithmID(badgeDetailsDTO.getAlgoId());
		badge.setGift(badgeGiftDTO.getLoyalGiftId());
		badge.setImage(badgeDetailsDTO.getImage());
		return badge;
	}
	
	public HashMap<BadgeDetailsDTO, BadgeLoyalgiftDTO> convertObjToDTO(Badge badge){
		BadgeDetailsDTO badgeDetailsDTO = new BadgeDetailsDTO();
		badgeDetailsDTO.setBadgeName(badge.getBadgeName());
		badgeDetailsDTO.setBadgeDescription(badge.getBadgeDescription());
		badgeDetailsDTO.setAlgoId(badge.getAlgorithmID());
		
		LoyalGiftsDTO giftsDTO = loyalGiftsDAO.findById(badge.getGift());
		
		BadgeLoyalgiftDTO badgeGiftDTO = new BadgeLoyalgiftDTO();
		badgeGiftDTO.setBadgeId(badgeDetailsDTO.getId());
		badgeGiftDTO.setLoyalGiftId(giftsDTO.getId());
		badgeDetailsDTO.setImage(badge.getImage());
		
		HashMap<BadgeDetailsDTO, BadgeLoyalgiftDTO> badgeMap = new HashMap<BadgeDetailsDTO, BadgeLoyalgiftDTO>();
		badgeMap.put(badgeDetailsDTO, badgeGiftDTO);
		return badgeMap;
	}
	


}
