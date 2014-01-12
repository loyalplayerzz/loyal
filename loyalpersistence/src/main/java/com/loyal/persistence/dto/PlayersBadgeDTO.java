package com.loyal.persistence.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PlayersBadge entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "players_badge", catalog = "loyal")
public class PlayersBadgeDTO implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer playerId;
	private Integer badgeId;
	private String createdBy;
	private Date createdTimestamp;
	private String updatedBy;
	private Date updatedTimestamp;

	// Constructors

	/** default constructor */
	public PlayersBadgeDTO() {
	}

	/** minimal constructor */
	public PlayersBadgeDTO(Integer playerId, Integer badgeId) {
		this.playerId = playerId;
		this.badgeId = badgeId;
	}

	/** full constructor */
	public PlayersBadgeDTO(Integer playerId, Integer badgeId, String createdBy,
			Date createdTimestamp, String updatedBy, Date updatedTimestamp) {
		this.playerId = playerId;
		this.badgeId = badgeId;
		this.createdBy = createdBy;
		this.createdTimestamp = createdTimestamp;
		this.updatedBy = updatedBy;
		this.updatedTimestamp = updatedTimestamp;
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

	@Column(name = "player_id", nullable = false)
	public Integer getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	@Column(name = "badge_id", nullable = false)
	public Integer getBadgeId() {
		return this.badgeId;
	}

	public void setBadgeId(Integer badgeId) {
		this.badgeId = badgeId;
	}

	@Column(name = "created_by", length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_timestamp", length = 10)
	public Date getCreatedTimestamp() {
		return this.createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	@Column(name = "updated_by", length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "updated_timestamp", length = 10)
	public Date getUpdatedTimestamp() {
		return this.updatedTimestamp;
	}

	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

}