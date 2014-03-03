package com.loyal.service.pojo;

public class LoyalPoints {
	
	private Integer loyalPointsID;
	
	public Integer getLoyalPointsID() {
		return loyalPointsID;
	}

	public void setLoyalPointsID(Integer loyalPointsID) {
		this.loyalPointsID = loyalPointsID;
	}

	private Integer bet;
	
	private String currencyType;
	
	private Integer loyalPoints;

	public Integer getBet() {
		return bet;
	}

	public void setBet(Integer bet) {
		this.bet = bet;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public Integer getLoyalPoints() {
		return loyalPoints;
	}

	public void setLoyalPoints(Integer loyalPoints) {
		this.loyalPoints = loyalPoints;
	}

}
