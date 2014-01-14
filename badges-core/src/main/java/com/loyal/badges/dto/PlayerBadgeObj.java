package com.loyal.badges.dto;

import java.util.Date;

public class PlayerBadgeObj {
	
	private String playerId;
	private String badgeId;
	private int rowNum;
	private Date badgeDate;
	private String badgeType;
	
	public PlayerBadgeObj(){
		
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getBadgeId() {
		return badgeId;
	}

	public void setBadgeId(String badgeId) {
		this.badgeId = badgeId;
	}
    
	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public Date getBadgeDate() {
		return badgeDate;
	}

	public void setBadgeDate(Date badgeDate) {
		this.badgeDate = badgeDate;
	}
	

	public String getBadgeType() {
        return badgeType;
    }

    public void setBadgeType(String badgeType) {
        this.badgeType = badgeType;
    }

    @Override
	public String toString() {
		return "PlayerBadgeObj [playerId=" + playerId + ", badgeId=" + badgeId
				+ ", rowNum=" + rowNum + ", badgeDate=" + badgeDate + "]";
	}

}
