package com.loyal.service.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.loyal.persistence.dao.LevelDAO;
import com.loyal.persistence.dto.LevelDTO;
import com.loyal.service.pojo.Level;

public class LevelHelper {

	@Autowired
	public LevelDAO levelDAO;
	
	public LevelDAO getLevelDAO() {
		return levelDAO;
	}

	public void setLevelDAO(LevelDAO levelDAO) {
		this.levelDAO = levelDAO;
	}

	public Level retrieveLevelDetails(Integer levelID){
		LevelDTO levelDTO = levelDAO.findById(levelID);
		
		if(levelDTO != null){
			return convertDTOToObject(levelDTO);
		} else {
			return null;
		}
	}
	
	public void createLevel(Level level){
		LevelDTO levelDTO = null;
		
		if(level !=null){
			levelDTO = convertObjToDTO(level);
			levelDAO.save(levelDTO);
		}
	}
	
	public List<Level> retrieveAllLevels(){
		List<Level> levelList = new ArrayList<Level>();
		
		for(LevelDTO levelDTO : levelDAO.findAll()){
			levelList.add(convertDTOToObject(levelDTO));
		} 
		return levelList;
	}
	
	public Level convertDTOToObject(LevelDTO levelDTO){
		Level level = new Level();
		level.setLevelID(levelDTO.getId());
		level.setLevelPoints(levelDTO.getPoints());
		level.setDescriptionEn(levelDTO.getDescriptionEn());
		level.setDescriptionSV(levelDTO.getDescriptionSv());
		level.setImage(levelDTO.getImage());
		return level;
	}
	
	public LevelDTO convertObjToDTO(Level level){
		LevelDTO levelDTO = new LevelDTO();
		levelDTO.setId(level.getLevelID());
		levelDTO.setPoints(level.getLevelPoints());
		levelDTO.setDescriptionEn(level.getDescriptionEn());
		levelDTO.setImage(level.getImage());
		return levelDTO;
	}
	
}
