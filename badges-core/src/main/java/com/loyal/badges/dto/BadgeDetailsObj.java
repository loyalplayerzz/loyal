package com.loyal.badges.dto;

import java.util.List;

public class BadgeDetailsObj {
	
	private String badgeId;
	private String algoId;
	private String badgeType;
	private boolean allProviderSelected;
	private boolean allGamesSelested;
	private List<String> providers;
	private List<String> games;
	private int noOfDays;
	private int noOfRounds;
	private Double betAmount;
	
	public BadgeDetailsObj(){
		
	}
	
	public String getBadgeId() {
		return badgeId;
	}
	public void setBadgeId(String badgeId) {
		this.badgeId = badgeId;
	}
	
	public String getAlgoId() {
		return algoId;
	}

	public void setAlgoId(String algoId) {
		this.algoId = algoId;
	}

	public String getBadgeType() {
		return badgeType;
	}
	public void setBadgeType(String badgeType) {
		this.badgeType = badgeType;
	}
	public boolean isAllProviderSelected() {
		return allProviderSelected;
	}
	public void setAllProviderSelected(boolean allProviderSelected) {
		this.allProviderSelected = allProviderSelected;
	}
	public boolean isAllGamesSelested() {
		return allGamesSelested;
	}
	public void setAllGamesSelested(boolean allGamesSelested) {
		this.allGamesSelested = allGamesSelested;
	}
	public List<String> getProviders() {
		return providers;
	}
	public void setProviders(List<String> providers) {
		this.providers = providers;
	}
	public List<String> getGames() {
		return games;
	}
	public void setGames(List<String> games) {
		this.games = games;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public int getNoOfRounds() {
		return noOfRounds;
	}
	public void setNoOfRounds(int noOfRounds) {
		this.noOfRounds = noOfRounds;
	}
	public Double getBetAmount() {
		return betAmount;
	}
	public void setBetAmount(Double betAmount) {
		this.betAmount = betAmount;
	}
	@Override
	public String toString() {
		return "BadgeDetailsObj [badgeId=" + badgeId + ", badgeType="
				+ badgeType + ", allProviderSelected=" + allProviderSelected
				+ ", allGamesSelested=" + allGamesSelested + ", providers="
				+ providers + ", games=" + games + ", noOfDays=" + noOfDays
				+ ", noOfRounds=" + noOfRounds + ", betAmount=" + betAmount
				+ "]";
	}
	
}
