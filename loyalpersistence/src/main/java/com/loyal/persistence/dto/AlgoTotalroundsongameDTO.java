package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AlgoTotalroundsongame entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "algo_totalroundsongame", catalog = "loyal")
public class AlgoTotalroundsongameDTO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String algoId;
	private Integer providers;
	private Integer games;
	private Integer noOfGameRounds;
	private Integer noOfDays;

	// Constructors

	/** default constructor */
	public AlgoTotalroundsongameDTO() {
	}

	/** full constructor */
	public AlgoTotalroundsongameDTO(String algoId, Integer providers,
			Integer games, Integer noOfGameRounds, Integer noOfDays) {
		this.algoId = algoId;
		this.providers = providers;
		this.games = games;
		this.noOfGameRounds = noOfGameRounds;
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

	@Column(name = "no_of_game_rounds", nullable = false)
	public Integer getNoOfGameRounds() {
		return this.noOfGameRounds;
	}

	public void setNoOfGameRounds(Integer noOfGameRounds) {
		this.noOfGameRounds = noOfGameRounds;
	}

	@Column(name = "no_of_days", nullable = false)
	public Integer getNoOfDays() {
		return this.noOfDays;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

}