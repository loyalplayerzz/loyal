package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LevelMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "level_master", catalog = "loyal")
public class LevelMasterDTO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String description;
	private Integer levelPoints;
	private String image;

	// Constructors

	/** default constructor */
	public LevelMasterDTO() {
	}

	/** full constructor */
	public LevelMasterDTO(String description, Integer levelPoints, String image) {
		this.description = description;
		this.levelPoints = levelPoints;
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

	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "level_points")
	public Integer getLevelPoints() {
		return this.levelPoints;
	}

	public void setLevelPoints(Integer levelPoints) {
		this.levelPoints = levelPoints;
	}

	@Column(name = "image", length = 100)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}