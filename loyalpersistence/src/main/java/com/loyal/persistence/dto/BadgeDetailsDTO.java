package com.loyal.persistence.dto;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BadgeDetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "badge_details", catalog = "loyal")
public class BadgeDetailsDTO implements java.io.Serializable {

	// Fields

	private Integer badgeId;
	private String badgeName;
	private String badgeDescription;
	private String algoType;
	private String algoId;
	private String active;
	private Timestamp createdDate;

	// Constructors

	/** default constructor */
	public BadgeDetailsDTO() {
	}

	/** minimal constructor */
	public BadgeDetailsDTO(String badgeName, String algoType, String algoId,
			String active, Timestamp createdDate) {
		this.badgeName = badgeName;
		this.algoType = algoType;
		this.algoId = algoId;
		this.active = active;
		this.createdDate = createdDate;
	}

	/** full constructor */
	public BadgeDetailsDTO(String badgeName, String badgeDescription,
			String algoType, String algoId, String active, Timestamp createdDate) {
		this.badgeName = badgeName;
		this.badgeDescription = badgeDescription;
		this.algoType = algoType;
		this.algoId = algoId;
		this.active = active;
		this.createdDate = createdDate;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "badge_id", unique = true, nullable = false)
	public Integer getBadgeId() {
		return this.badgeId;
	}

	public void setBadgeId(Integer badgeId) {
		this.badgeId = badgeId;
	}

	@Column(name = "badge_name", nullable = false, length = 75)
	public String getBadgeName() {
		return this.badgeName;
	}

	public void setBadgeName(String badgeName) {
		this.badgeName = badgeName;
	}

	@Column(name = "badge_description", length = 200)
	public String getBadgeDescription() {
		return this.badgeDescription;
	}

	public void setBadgeDescription(String badgeDescription) {
		this.badgeDescription = badgeDescription;
	}

	@Column(name = "algo_type", nullable = false, length = 10)
	public String getAlgoType() {
		return this.algoType;
	}

	public void setAlgoType(String algoType) {
		this.algoType = algoType;
	}

	@Column(name = "algo_id", nullable = false, length = 10)
	public String getAlgoId() {
		return this.algoId;
	}

	public void setAlgoId(String algoId) {
		this.algoId = algoId;
	}

	@Column(name = "active", nullable = false, length = 1)
	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Column(name = "created_date", nullable = false, length = 19)
	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

}