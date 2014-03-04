package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LoyalGifts entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "loyal_gifts", catalog = "loyal")
public class LoyalGiftsDTO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String giftType;
	private String name;
	private String description;
	private Integer points;
	private String image;

	// Constructors

	/** default constructor */
	public LoyalGiftsDTO() {
	}

	/** full constructor */
	public LoyalGiftsDTO(String giftType, String name, String description,
			Integer points, String image) {
		this.giftType = giftType;
		this.name = name;
		this.description = description;
		this.points = points;
		this.image = image;
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

	@Column(name = "gift_type", length = 2)
	public String getGiftType() {
		return this.giftType;
	}

	public void setGiftType(String giftType) {
		this.giftType = giftType;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "points")
	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Column(name = "image", length = 100)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}