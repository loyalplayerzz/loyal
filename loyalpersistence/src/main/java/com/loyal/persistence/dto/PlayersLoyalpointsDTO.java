package com.loyal.persistence.dto;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * PlayersLoyalpoints entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="PLAYERS_LOYALPOINTS"
    ,catalog="mysql"
)

public class PlayersLoyalpointsDTO  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer playerId;
     private Integer loyalpointsId;
     private String createdBy;
     private Date createdTimestamp;
     private String updatedBy;
     private Date updatedTimestamp;


    // Constructors

    /** default constructor */
    public PlayersLoyalpointsDTO() {
    }

	/** minimal constructor */
    public PlayersLoyalpointsDTO(Integer playerId, Integer loyalpointsId) {
        this.playerId = playerId;
        this.loyalpointsId = loyalpointsId;
    }
    
    /** full constructor */
    public PlayersLoyalpointsDTO(Integer playerId, Integer loyalpointsId, String createdBy, Date createdTimestamp, String updatedBy, Date updatedTimestamp) {
        this.playerId = playerId;
        this.loyalpointsId = loyalpointsId;
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
    
    @Column(name="loyalpoints_id", nullable=false)

    public Integer getLoyalpointsId() {
        return this.loyalpointsId;
    }
    
    public void setLoyalpointsId(Integer loyalpointsId) {
        this.loyalpointsId = loyalpointsId;
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