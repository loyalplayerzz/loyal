package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * BadgeDetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="BADGE_DETAILS"
    ,catalog="mysql"
)

public class BadgeDetailsDTO  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String badgeName;
     private String badgeDescription;
     private String description;
     private Integer algoId;
     private Boolean active;
     private String image;


    // Constructors

    /** default constructor */
    public BadgeDetailsDTO() {
    }

    
    /** full constructor */
    public BadgeDetailsDTO(String badgeName, String badgeDescription, String description, Integer algoId, Boolean active, String image) {
        this.badgeName = badgeName;
        this.badgeDescription = badgeDescription;
        this.description = description;
        this.algoId = algoId;
        this.active = active;
        this.image = image;
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
    
    @Column(name="badge_name", length=15)

    public String getBadgeName() {
        return this.badgeName;
    }
    
    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }
    
    @Column(name="badge_description", length=100)

    public String getBadgeDescription() {
        return this.badgeDescription;
    }
    
    public void setBadgeDescription(String badgeDescription) {
        this.badgeDescription = badgeDescription;
    }
    
    @Column(name="description", length=100)

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="algo_id")

    public Integer getAlgoId() {
        return this.algoId;
    }
    
    public void setAlgoId(Integer algoId) {
        this.algoId = algoId;
    }
    
    @Column(name="active")

    public Boolean getActive() {
        return this.active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    @Column(name="image", length=100)

    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
   








}