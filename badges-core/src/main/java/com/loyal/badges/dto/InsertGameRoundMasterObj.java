package com.loyal.badges.dto;

import java.util.Date;

public class InsertGameRoundMasterObj {
	
	private String playerId;
	private String provider;
	private String gameId;
	private String trasactionType;
	private String gameRoundId;
	private Date gameRoundStartDate;
	private Date gameRoundEndDate;
	private Double totalBet;
	private Double totalWin;
	
	public InsertGameRoundMasterObj(){
		
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getTrasactionType() {
		return trasactionType;
	}

	public void setTrasactionType(String trasactionType) {
		this.trasactionType = trasactionType;
	}

	public String getGameRoundId() {
		return gameRoundId;
	}

	public void setGameRoundId(String gameRoundId) {
		this.gameRoundId = gameRoundId;
	}

	public Date getGameRoundStartDate() {
		return gameRoundStartDate;
	}

	public void setGameRoundStartDate(Date gameRoundStartDate) {
		this.gameRoundStartDate = gameRoundStartDate;
	}

	public Date getGameRoundEndDate() {
		return gameRoundEndDate;
	}

	public void setGameRoundEndDate(Date gameRoundEndDate) {
		this.gameRoundEndDate = gameRoundEndDate;
	}

	public Double getTotalBet() {
		return totalBet;
	}

	public void setTotalBet(Double totalBet) {
		this.totalBet = totalBet;
	}

	public Double getTotalWin() {
		return totalWin;
	}

	public void setTotalWin(Double totalWin) {
		this.totalWin = totalWin;
	}

	@Override
	public String toString() {
		return "InsertGameRoundMasterObj [playerId=" + playerId + ", provider="
				+ provider + ", gameId=" + gameId + ", trasactionType="
				+ trasactionType + ", gameRoundId=" + gameRoundId
				+ ", gameRoundStartDate=" + gameRoundStartDate
				+ ", gameRoundEndDate=" + gameRoundEndDate + ", totalBet="
				+ totalBet + ", totalWin=" + totalWin + "]";
	}
	
}
