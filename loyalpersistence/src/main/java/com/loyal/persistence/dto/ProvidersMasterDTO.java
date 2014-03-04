package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProvidersMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "providers_master", catalog = "loyal")
public class ProvidersMasterDTO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String providerName;
	private String description;
	private String type;
	private Boolean active;

	// Constructors

	/** default constructor */
	public ProvidersMasterDTO() {
	}

	/** full constructor */
	public ProvidersMasterDTO(String providerName, String description,
			String type, Boolean active) {
		this.providerName = providerName;
		this.description = description;
		this.type = type;
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

	@Column(name = "provider_name", length = 100)
	public String getProviderName() {
		return this.providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	@Column(name = "description", length = 250)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "type", length = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "active")
	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}