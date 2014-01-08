package com.loyal.service.pojo;

public class AlgoTotalRoundsOnGame {
	
	private Integer badgeId;
	
	public Integer getTotalRoundsOnGameId() {
		return badgeId;
	}

	public void setTotalRoundsOnGameId(Integer totalRoundsOnGameId) {
		this.badgeId = totalRoundsOnGameId;
	}

	private String providerName;
	
	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public Integer getNoOfRounds() {
		return noOfRounds;
	}

	public void setNoOfRounds(Integer noOfRounds) {
		this.noOfRounds = noOfRounds;
	}

	public String getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getNameOfGame() {
		return nameOfGame;
	}

	public void setNameOfGame(String nameOfGame) {
		this.nameOfGame = nameOfGame;
	}

	private Integer noOfRounds;
	
	private String noOfDays;
	
	private String nameOfGame;

}
