package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LoyalpointsMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "loyalpoints_master", catalog = "loyal")
public class LoyalpointsMasterDTO implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer bet;
	private String currency;
	private Integer points;

	// Constructors

	/** default constructor */
	public LoyalpointsMasterDTO() {
	}

	/** full constructor */
	public LoyalpointsMasterDTO(Integer bet, String currency, Integer points) {
		this.bet = bet;
		this.currency = currency;
		this.points = points;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "bet")
	public Integer getBet() {
		return this.bet;
	}

	public void setBet(Integer bet) {
		this.bet = bet;
	}

	@Column(name = "currency", length = 20)
	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name = "points")
	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

}