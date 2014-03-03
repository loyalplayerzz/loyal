package com.loyal.persistence.dto;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * GameRoundSummary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "game_round_summary", catalog = "loyal", uniqueConstraints = @UniqueConstraint(columnNames = {
		"player_id", "gameId", "game_round_date" }))
public class GameRoundSummaryDTO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String playerId;
	private String provider;
	private String gameId;
	private Timestamp gameRoundDate;
	private Integer gameRounds;
	private Double totalBet;
	private Double totalWin;

	// Constructors

	/** default constructor */
	public GameRoundSummaryDTO() {
	}

	/** minimal constructor */
	public GameRoundSummaryDTO(String playerId, String gameId,
			Timestamp gameRoundDate, Integer gameRounds) {
		this.playerId = playerId;
		this.gameId = gameId;
		this.gameRoundDate = gameRoundDate;
		this.gameRounds = gameRounds;
	}

	/** full constructor */
	public GameRoundSummaryDTO(String playerId, String provider, String gameId,
			Timestamp gameRoundDate, Integer gameRounds, Double totalBet,
			Double totalWin) {
		this.playerId = playerId;
		this.provider = provider;
		this.gameId = gameId;
		this.gameRoundDate = gameRoundDate;
		this.gameRounds = gameRounds;
		this.totalBet = totalBet;
		this.totalWin = totalWin;
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

	@Column(name = "player_id", nullable = false, length = 45)
	public String getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	@Column(name = "provider", length = 45)
	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	@Column(name = "gameId", nullable = false, length = 45)
	public String getGameId() {
		return this.gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	@Column(name = "game_round_date", nullable = false, length = 19)
	public Timestamp getGameRoundDate() {
		return this.gameRoundDate;
	}

	public void setGameRoundDate(Timestamp gameRoundDate) {
		this.gameRoundDate = gameRoundDate;
	}

	@Column(name = "game_rounds", nullable = false)
	public Integer getGameRounds() {
		return this.gameRounds;
	}

	public void setGameRounds(Integer gameRounds) {
		this.gameRounds = gameRounds;
	}

	@Column(name = "total_bet", precision = 22, scale = 0)
	public Double getTotalBet() {
		return this.totalBet;
	}

	public void setTotalBet(Double totalBet) {
		this.totalBet = totalBet;
	}

	@Column(name = "total_win", precision = 22, scale = 0)
	public Double getTotalWin() {
		return this.totalWin;
	}

	public void setTotalWin(Double totalWin) {
		this.totalWin = totalWin;
	}

}