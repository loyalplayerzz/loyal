package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AlgorithmMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "algorithm_master", catalog = "loyal")
public class AlgorithmMasterDTO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String paramTable;
	private String description;

	// Constructors

	/** default constructor */
	public AlgorithmMasterDTO() {
	}

	/** full constructor */
	public AlgorithmMasterDTO(String paramTable, String description) {
		this.paramTable = paramTable;
		this.description = description;
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

	@Column(name = "param_table", length = 100)
	public String getParamTable() {
		return this.paramTable;
	}

	public void setParamTable(String paramTable) {
		this.paramTable = paramTable;
	}

	@Column(name = "description", length = 250)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}