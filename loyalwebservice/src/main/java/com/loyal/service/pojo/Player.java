package com.loyal.service.pojo;

import java.util.HashMap;

public class Player {
	
	private String userID;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public HashMap<String, String> getBadges() {
		return badges;
	}

	public void setBadges(HashMap<String, String> badges) {
		this.badges = badges;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevelAwardedDate() {
		return levelAwardedDate;
	}

	public void setLevelAwardedDate(String levelAwardedDate) {
		this.levelAwardedDate = levelAwardedDate;
	}

	public String getLoyalPoints() {
		return loyalPoints;
	}

	public void setLoyalPoints(String loyalPoints) {
		this.loyalPoints = loyalPoints;
	}

	public String getLoyalPointsAwardedDate() {
		return loyalPointsAwardedDate;
	}

	public void setLoyalPointsAwardedDate(String loyalPointsAwardedDate) {
		this.loyalPointsAwardedDate = loyalPointsAwardedDate;
	}

	private String playerName;
	
	private HashMap<String, String> badges;
	
	private String level;
	
	private String levelAwardedDate;
	
	private String loyalPoints;
	
	private String loyalPointsAwardedDate;
	
}
