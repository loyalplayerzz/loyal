package com.loyal.service.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.loyal.persistence.dao.BadgeDetailsDAO;
import com.loyal.persistence.dao.BadgeLoyalGiftDAO;
import com.loyal.persistence.dao.LoyalGiftsDAO;
import com.loyal.persistence.dto.BadgeDetailsDTO;
import com.loyal.persistence.dto.BadgeLoyalGiftDTO;
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
	public BadgeLoyalGiftDAO badgeLoyalGiftDAO;
	
	public BadgeLoyalGiftDAO getBadgeLoyalGiftDAO() {
		return badgeLoyalGiftDAO;
	}

	public void setBadgeLoyalGiftDAO(BadgeLoyalGiftDAO badgeLoyalGiftDAO) {
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
			BadgeLoyalGiftDTO badgeGiftDTO = (BadgeLoyalGiftDTO) badgeLoyalGiftDAO.findByBadgeId(badgeDetailsDTOList.get(0).getBadgeId());
			return convertDTOToObject(badgeDetailsDTOList.get(0), badgeGiftDTO);
		} else {
			return null;
		}
	}
	
	public void createBadgeDetails(Badge badge){
		BadgeDetailsDTO badgeDetailsDTO = null;
		
		if(badge !=null){
			HashMap<BadgeDetailsDTO, BadgeLoyalGiftDTO> badgeMap = convertObjToDTO(badge);
			
			for(BadgeDetailsDTO badgeDTO : badgeMap.keySet()){
				badgeDetailDAO.save(badgeDetailsDTO);
				badgeLoyalGiftDAO.save(badgeMap.get(badgeDTO));
			}
		
		}
	}
	
	public List<Badge> retrieveAllBadgeDetails(){
		List<Badge> badgeDetailList = new ArrayList<Badge>();
		
		for(BadgeDetailsDTO badgeDetailDTO : badgeDetailDAO.findAll()){
			BadgeLoyalGiftDTO badgeGiftDTO = (BadgeLoyalGiftDTO) badgeLoyalGiftDAO.findByBadgeId(badgeDetailDTO.getBadgeId());
			badgeDetailList.add(convertDTOToObject(badgeDetailDTO, badgeGiftDTO));
		} 
		return badgeDetailList;
	}
	
	public Badge convertDTOToObject(BadgeDetailsDTO badgeDetailsDTO, BadgeLoyalGiftDTO badgeGiftDTO){
		Badge badge = new Badge();
		badge.setBadgeName(badgeDetailsDTO.getBadgeName());
		badge.setBadgeDescription(badgeDetailsDTO.getBadgeDescription());
		badge.setAlgorithmID(Integer.valueOf(badgeDetailsDTO.getAlgoId()));
		badge.setGift(badgeGiftDTO.getLoyalGiftId());
		//badge.setImage(badgeDetailsDTO.getImage());
		return badge;
	}
	
	public HashMap<BadgeDetailsDTO, BadgeLoyalGiftDTO> convertObjToDTO(Badge badge){
		BadgeDetailsDTO badgeDetailsDTO = new BadgeDetailsDTO();
		badgeDetailsDTO.setBadgeName(badge.getBadgeName());
		badgeDetailsDTO.setBadgeDescription(badge.getBadgeDescription());
		badgeDetailsDTO.setAlgoId(String.valueOf(badge.getAlgorithmID()));
		
		LoyalGiftsDTO giftsDTO = loyalGiftsDAO.findById(badge.getGift());
		
		BadgeLoyalGiftDTO badgeGiftDTO = new BadgeLoyalGiftDTO();
		badgeGiftDTO.setBadgeId(badgeDetailsDTO.getBadgeId());
		badgeGiftDTO.setLoyalGiftId(giftsDTO.getId());
		//badgeDetailsDTO.setImage(badge.getImage());
		
		HashMap<BadgeDetailsDTO, BadgeLoyalGiftDTO> badgeMap = new HashMap<BadgeDetailsDTO, BadgeLoyalGiftDTO>();
		badgeMap.put(badgeDetailsDTO, badgeGiftDTO);
		return badgeMap;
	}
	


}
