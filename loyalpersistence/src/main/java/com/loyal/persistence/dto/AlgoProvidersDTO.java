package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AlgoProviders entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "algo_providers", catalog = "loyal")
public class AlgoProvidersDTO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String algoId;
	private String algoType;
	private String provider;
	private String active;

	// Constructors

	/** default constructor */
	public AlgoProvidersDTO() {
	}

	/** full constructor */
	public AlgoProvidersDTO(String algoId, String algoType, String provider,
			String active) {
		this.algoId = algoId;
		this.algoType = algoType;
		this.provider = provider;
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

	@Column(name = "provider", nullable = false, length = 45)
	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	@Column(name = "active", nullable = false, length = 1)
	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}