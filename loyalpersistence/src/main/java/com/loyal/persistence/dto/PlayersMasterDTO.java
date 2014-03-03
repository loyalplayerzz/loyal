package com.loyal.persistence.dto;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PlayersMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "players_master", catalog = "loyal")
public class PlayersMasterDTO implements java.io.Serializable {

	// Fields

	private Integer id;
	private Boolean active;
	private String externalUserId;
	private Double betAmt;
	private Boolean loyalpointsEligibile;
	private Boolean badgesEligible;
	private Timestamp dateOfBirth;
	private String sex;
	private String country;

	// Constructors

	/** default constructor */
	public PlayersMasterDTO() {
	}

	/** minimal constructor */
	public PlayersMasterDTO(String externalUserId) {
		this.externalUserId = externalUserId;
	}

	/** full constructor */
	public PlayersMasterDTO(Boolean active, String externalUserId, Double betAmt,
			Boolean loyalpointsEligibile, Boolean badgesEligible,
			Timestamp dateOfBirth, String sex, String country) {
		this.active = active;
		this.externalUserId = externalUserId;
		this.betAmt = betAmt;
		this.loyalpointsEligibile = loyalpointsEligibile;
		this.badgesEligible = badgesEligible;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.country = country;
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

	@Column(name = "active")
	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Column(name = "external_user_id", nullable = false, length = 20)
	public String getExternalUserId() {
		return this.externalUserId;
	}

	public void setExternalUserId(String externalUserId) {
		this.externalUserId = externalUserId;
	}

	@Column(name = "bet_amt", precision = 22, scale = 0)
	public Double getBetAmt() {
		return this.betAmt;
	}

	public void setBetAmt(Double betAmt) {
		this.betAmt = betAmt;
	}

	@Column(name = "loyalpoints_eligibile")
	public Boolean getLoyalpointsEligibile() {
		return this.loyalpointsEligibile;
	}

	public void setLoyalpointsEligibile(Boolean loyalpointsEligibile) {
		this.loyalpointsEligibile = loyalpointsEligibile;
	}

	@Column(name = "badges_eligible")
	public Boolean getBadgesEligible() {
		return this.badgesEligible;
	}

	public void setBadgesEligible(Boolean badgesEligible) {
		this.badgesEligible = badgesEligible;
	}

	@Column(name = "date_of_birth", length = 19)
	public Timestamp getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Timestamp dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "sex", length = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "country", length = 25)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}