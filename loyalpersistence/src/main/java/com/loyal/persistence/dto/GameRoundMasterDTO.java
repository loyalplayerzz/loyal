package com.loyal.persistence.dto;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GameRoundMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "game_round_master", catalog = "loyal")
public class GameRoundMasterDTO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String gameId;
	private String gameRoundId;
	private String transactionType;
	private Timestamp gameRoundStartDate;
	private Timestamp gameRoundEndDate;
	private Double casinoCurrencyBet;
	private Double casinoCurrencyWin;
	private String playerId;
	private String analyzedBadges;
	private String gameProvider;

	// Constructors

	/** default constructor */
	public GameRoundMasterDTO() {
	}

	/** minimal constructor */
	public GameRoundMasterDTO(String gameId, String gameRoundId,
			String transactionType, Timestamp gameRoundStartDate,
			String gameProvider) {
		this.gameId = gameId;
		this.gameRoundId = gameRoundId;
		this.transactionType = transactionType;
		this.gameRoundStartDate = gameRoundStartDate;
		this.gameProvider = gameProvider;
	}

	/** full constructor */
	public GameRoundMasterDTO(String gameId, String gameRoundId,
			String transactionType, Timestamp gameRoundStartDate,
			Timestamp gameRoundEndDate, Double casinoCurrencyBet,
			Double casinoCurrencyWin, String playerId, String analyzedBadges,
			String gameProvider) {
		this.gameId = gameId;
		this.gameRoundId = gameRoundId;
		this.transactionType = transactionType;
		this.gameRoundStartDate = gameRoundStartDate;
		this.gameRoundEndDate = gameRoundEndDate;
		this.casinoCurrencyBet = casinoCurrencyBet;
		this.casinoCurrencyWin = casinoCurrencyWin;
		this.playerId = playerId;
		this.analyzedBadges = analyzedBadges;
		this.gameProvider = gameProvider;
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

	@Column(name = "gameId", nullable = false, length = 45)
	public String getGameId() {
		return this.gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	@Column(name = "game_round_id", nullable = false, length = 45)
	public String getGameRoundId() {
		return this.gameRoundId;
	}

	public void setGameRoundId(String gameRoundId) {
		this.gameRoundId = gameRoundId;
	}

	@Column(name = "transaction_type", nullable = false, length = 45)
	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Column(name = "game_round_start_date", nullable = false, length = 19)
	public Timestamp getGameRoundStartDate() {
		return this.gameRoundStartDate;
	}

	public void setGameRoundStartDate(Timestamp gameRoundStartDate) {
		this.gameRoundStartDate = gameRoundStartDate;
	}

	@Column(name = "game_round_end_date", length = 19)
	public Timestamp getGameRoundEndDate() {
		return this.gameRoundEndDate;
	}

	public void setGameRoundEndDate(Timestamp gameRoundEndDate) {
		this.gameRoundEndDate = gameRoundEndDate;
	}

	@Column(name = "casino_currency_bet", precision = 22, scale = 0)
	public Double getCasinoCurrencyBet() {
		return this.casinoCurrencyBet;
	}

	public void setCasinoCurrencyBet(Double casinoCurrencyBet) {
		this.casinoCurrencyBet = casinoCurrencyBet;
	}

	@Column(name = "casino_currency_win", precision = 22, scale = 0)
	public Double getCasinoCurrencyWin() {
		return this.casinoCurrencyWin;
	}

	public void setCasinoCurrencyWin(Double casinoCurrencyWin) {
		this.casinoCurrencyWin = casinoCurrencyWin;
	}

	@Column(name = "player_id", length = 45)
	public String getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	@Column(name = "analyzed_badges", length = 1)
	public String getAnalyzedBadges() {
		return this.analyzedBadges;
	}

	public void setAnalyzedBadges(String analyzedBadges) {
		this.analyzedBadges = analyzedBadges;
	}

	@Column(name = "game_provider", nullable = false, length = 45)
	public String getGameProvider() {
		return this.gameProvider;
	}

	public void setGameProvider(String gameProvider) {
		this.gameProvider = gameProvider;
	}

}