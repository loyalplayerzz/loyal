package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AlgoTotalbetonprovider entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "algo_totalbetonprovider", catalog = "loyal")
public class AlgoTotalbetonproviderDTO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String algoId;
	private Integer providers;
	private Integer games;
	private Double betAmount;
	private Integer noOfDays;

	// Constructors

	/** default constructor */
	public AlgoTotalbetonproviderDTO() {
	}

	/** full constructor */
	public AlgoTotalbetonproviderDTO(String algoId, Integer providers,
			Integer games, Double betAmount, Integer noOfDays) {
		this.algoId = algoId;
		this.providers = providers;
		this.games = games;
		this.betAmount = betAmount;
		this.noOfDays = noOfDays;
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

	@Column(name = "algo_id", nullable = false, length = 10)
	public String getAlgoId() {
		return this.algoId;
	}

	public void setAlgoId(String algoId) {
		this.algoId = algoId;
	}

	@Column(name = "providers", nullable = false)
	public Integer getProviders() {
		return this.providers;
	}

	public void setProviders(Integer providers) {
		this.providers = providers;
	}

	@Column(name = "games", nullable = false)
	public Integer getGames() {
		return this.games;
	}

	public void setGames(Integer games) {
		this.games = games;
	}

	@Column(name = "bet_amount", nullable = false, precision = 10, scale = 6)
	public Double getBetAmount() {
		return this.betAmount;
	}

	public void setBetAmount(Double betAmount) {
		this.betAmount = betAmount;
	}

	@Column(name = "no_of_days", nullable = false)
	public Integer getNoOfDays() {
		return this.noOfDays;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

}