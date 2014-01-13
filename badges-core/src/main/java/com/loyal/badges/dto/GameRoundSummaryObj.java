package com.loyal.badges.dto;

import java.util.Date;

public class GameRoundSummaryObj {
	
	private String rowId;
	private String playerId;
	private String provider;
	private String gameId;
	private Date gameRoundDate;
	private int noOfGameRounds;
	private Double totalBet;
	private Double totalWin;
	
	public GameRoundSummaryObj(){
		
	}
	
	
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
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
	public Date getGameRoundDate() {
		return gameRoundDate;
	}
	public void setGameRoundDate(Date gameRoundDate) {
		this.gameRoundDate = gameRoundDate;
	}
	public int getNoOfGameRounds() {
		return noOfGameRounds;
	}
	public void setNoOfGameRounds(int noOfGameRounds) {
		this.noOfGameRounds = noOfGameRounds;
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
		return "GameRoundSummaryObj [playerId=" + playerId + ", provider="
				+ provider + ", gameId=" + gameId + ", gameRoundDate="
				+ gameRoundDate + ", noOfGameRounds=" + noOfGameRounds
				+ ", totalBet=" + totalBet + ", totalWin=" + totalWin + "]";
	}
}
