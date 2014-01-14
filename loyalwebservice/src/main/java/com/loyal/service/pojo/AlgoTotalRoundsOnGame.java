package com.loyal.service.pojo;

public class AlgoTotalRoundsOnGame {
	
	private Integer badgeId;
	
	public Integer getTotalRoundsOnGameId() {
		return badgeId;
	}

	public void setTotalRoundsOnGameId(Integer totalRoundsOnGameId) {
		this.badgeId = totalRoundsOnGameId;
	}

	private Integer providers;
	
	public Integer getProviders() {
		return providers;
	}

	public void setProviders(Integer providers) {
		this.providers = providers;
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
