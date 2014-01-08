package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * AlgoTotalroundsongame entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALGO_TOTALROUNDSONGAME"
    ,catalog="mysql"
)

public class AlgoTotalroundsongameDTO  implements java.io.Serializable {


    // Fields    

     private Integer badgeId;
     private Integer providerName;
     private Integer noOfRounds;
     private String nameOfGames;


    // Constructors

    /** default constructor */
    public AlgoTotalroundsongameDTO() {
    }

    
    /** full constructor */
    public AlgoTotalroundsongameDTO(Integer providerName, Integer noOfRounds, String nameOfGames) {
        this.providerName = providerName;
        this.noOfRounds = noOfRounds;
        this.nameOfGames = nameOfGames;
    }

   
    // Property accessors
    //@SequenceGenerator(name="generator")@Id @GeneratedValue(strategy=SEQUENCE, generator="generator")
    @Id
    @Column(name="badge_id", unique=true, nullable=false)

    public Integer getBadgeId() {
        return this.badgeId;
    }
    
    public void setBadgeId(Integer badgeId) {
        this.badgeId = badgeId;
    }
    
    @Column(name="provider_name")

    public Integer getProviderName() {
        return this.providerName;
    }
    
    public void setProviderName(Integer providerName) {
        this.providerName = providerName;
    }
    
    @Column(name="no_of_rounds")

    public Integer getNoOfRounds() {
        return this.noOfRounds;
    }
    
    public void setNoOfRounds(Integer noOfRounds) {
        this.noOfRounds = noOfRounds;
    }
    
    @Column(name="name_of_games", length=100)

    public String getNameOfGames() {
        return this.nameOfGames;
    }
    
    public void setNameOfGames(String nameOfGames) {
        this.nameOfGames = nameOfGames;
    }
   








}