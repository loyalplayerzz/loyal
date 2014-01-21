package com.loyal.service.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.loyal.persistence.dao.LevelMasterDAO;
import com.loyal.persistence.dto.LevelMasterDTO;
import com.loyal.service.pojo.Level;

public class LevelHelper {

	@Autowired
	public LevelMasterDAO levelMasterDAO;
	
	public LevelMasterDAO getLevelMasterDAO() {
		return levelMasterDAO;
	}

	public void setLevelMasterDAO(LevelMasterDAO levelMasterDAO) {
		this.levelMasterDAO = levelMasterDAO;
	}

	public Level retrieveLevelDetails(Integer levelID){
		LevelMasterDTO levelDTO = levelMasterDAO.findById(levelID);
		
		if(levelDTO != null){
			return convertDTOToObject(levelDTO);
		} else {
			return null;
		}
	}
	
	public void createLevel(Level level){
		LevelMasterDTO levelDTO = null;
		
		if(level !=null){
			levelDTO = convertObjToDTO(level);
			levelMasterDAO.save(levelDTO);
		}
	}
	
	public List<Level> retrieveAllLevels(){
		List<Level> levelList = new ArrayList<Level>();
		
		for(LevelMasterDTO levelDTO : levelMasterDAO.findAll()){
			levelList.add(convertDTOToObject(levelDTO));
		} 
		return levelList;
	}
	
	public Level convertDTOToObject(LevelMasterDTO levelDTO){
		Level level = new Level();
		level.setLevelID(levelDTO.getId());
		level.setLevelPoints(levelDTO.getLevelPoints());
		level.setDescription(levelDTO.getDescription());
		level.setImage(levelDTO.getImage());
		return level;
	}
	
	public LevelMasterDTO convertObjToDTO(Level level){
		LevelMasterDTO levelDTO = new LevelMasterDTO();
		levelDTO.setId(level.getLevelID());
		levelDTO.setLevelPoints(level.getLevelPoints());
		levelDTO.setDescription(level.getDescription());
		levelDTO.setImage(level.getImage());
		return levelDTO;
	}
	
}
