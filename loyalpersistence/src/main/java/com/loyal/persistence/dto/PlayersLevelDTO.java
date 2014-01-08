package com.loyal.persistence.dto;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * PlayersLevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="PLAYERS_LEVEL"
    ,catalog="mysql"
)

public class PlayersLevelDTO  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer playerId;
     private Integer levelId;
     private String createdBy;
     private Date createdTimestamp;
     private String updatedBy;
     private Date updatedTimestamp;


    // Constructors

    /** default constructor */
    public PlayersLevelDTO() {
    }

	/** minimal constructor */
    public PlayersLevelDTO(Integer playerId, Integer levelId) {
        this.playerId = playerId;
        this.levelId = levelId;
    }
    
    /** full constructor */
    public PlayersLevelDTO(Integer playerId, Integer levelId, String createdBy, Date createdTimestamp, String updatedBy, Date updatedTimestamp) {
        this.playerId = playerId;
        this.levelId = levelId;
        this.createdBy = createdBy;
        this.createdTimestamp = createdTimestamp;
        this.updatedBy = updatedBy;
        this.updatedTimestamp = updatedTimestamp;
    }

   
    // Property accessors
    //@SequenceGenerator(name="generator")@Id @GeneratedValue(strategy=SEQUENCE, generator="generator")
    @Id
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="player_id", nullable=false)

    public Integer getPlayerId() {
        return this.playerId;
    }
    
    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }
    
    @Column(name="level_id", nullable=false)

    public Integer getLevelId() {
        return this.levelId;
    }
    
    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }
    
    @Column(name="created_by", length=20)

    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="created_timestamp", length=10)

    public Date getCreatedTimestamp() {
        return this.createdTimestamp;
    }
    
    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }
    
    @Column(name="updated_by", length=20)

    public String getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="updated_timestamp", length=10)

    public Date getUpdatedTimestamp() {
        return this.updatedTimestamp;
    }
    
    public void setUpdatedTimestamp(Date updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }
   








}