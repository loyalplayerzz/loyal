package com.loyal.service.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Level {
	
	private Integer levelID;
	
	private String description;
	
	private int levelPoints;
	
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getLevelID() {
		return levelID;
	}

	public void setLevelID(Integer levelID) {
		this.levelID = levelID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getLevelPoints() {
		return levelPoints;
	}

	public void setLevelPoints(int levelPoints) {
		this.levelPoints = levelPoints;
	}


}
