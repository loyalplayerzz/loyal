package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AlgoGames entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "algo_games", catalog = "loyal")
public class AlgoGamesDTO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String algoId;
	private String algoType;
	private String game;
	private String active;

	// Constructors

	/** default constructor */
	public AlgoGamesDTO() {
	}

	/** full constructor */
	public AlgoGamesDTO(String algoId, String algoType, String game, String active) {
		this.algoId = algoId;
		this.algoType = algoType;
		this.game = game;
		this.active = active;
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

	@Column(name = "algo_type", nullable = false, length = 10)
	public String getAlgoType() {
		return this.algoType;
	}

	public void setAlgoType(String algoType) {
		this.algoType = algoType;
	}

	@Column(name = "game", nullable = false, length = 45)
	public String getGame() {
		return this.game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	@Column(name = "active", nullable = false, length = 1)
	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}