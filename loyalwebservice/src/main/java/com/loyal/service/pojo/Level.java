package com.loyal.service.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Level {
	
	private Integer levelID;
	
	private String descriptionEn;
	
	private String descriptionSV;
	
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

	public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	public String getDescriptionSV() {
		return descriptionSV;
	}

	public void setDescriptionSV(String descriptionSV) {
		this.descriptionSV = descriptionSV;
	}

	public int getLevelPoints() {
		return levelPoints;
	}

	public void setLevelPoints(int levelPoints) {
		this.levelPoints = levelPoints;
	}


}
