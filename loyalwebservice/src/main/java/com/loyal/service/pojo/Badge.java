package com.loyal.service.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Badge {
	
	private String badgeName;
	
	public String getBadgeName() {
		return badgeName;
	}

	public void setBadgeName(String badgeName) {
		this.badgeName = badgeName;
	}

	private String badgeDescription;
	
	public String getBadgeDescription() {
		return badgeDescription;
	}

	public void setBadgeDescription(String badgeDescription) {
		this.badgeDescription = badgeDescription;
	}

	private Integer gift;
	
	private String image;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getGift() {
		return gift;
	}

	public void setGift(Integer gift) {
		this.gift = gift;
	}

	private Integer algorithmID;

	public Integer getAlgorithmID() {
		return algorithmID;
	}

	public void setAlgorithmID(Integer algorithmID) {
		this.algorithmID = algorithmID;
	}

}
