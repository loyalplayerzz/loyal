package com.loyal.persistence.dto;

// default package

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Level entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "LEVEL", catalog = "mysql")
public class LevelDTO implements Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1872593009064233752L;
	private Integer id;
	private String number;
	private String descriptionEn;
	private String descriptionSv;
	private Integer points;
	private String image;

	// Constructors

	/** default constructor */
	public LevelDTO() {
	}

	/** full constructor */
	public LevelDTO(Integer id, Integer points, String descriptionEn, String descriptionSv, String image) {
		this.descriptionEn = descriptionEn;
		this.descriptionSv = descriptionSv;
		this.points = points;
		this.image = image;
		this.id = id;
	}

	// Property accessors
	//@SequenceGenerator(name = "generator")
	@Id
	//@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "description_en", length = 100)
	public String getDescriptionEn() {
		return this.descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	@Column(name = "description_sv", length = 100)
	public String getDescriptionSv() {
		return this.descriptionSv;
	}

	public void setDescriptionSv(String descriptionSv) {
		this.descriptionSv = descriptionSv;
	}

	@Column(name = "points")
	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Column(name = "image")
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}