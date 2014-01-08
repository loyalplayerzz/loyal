package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * BadgeLoyalgift entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="BADGE_LOYALGIFT"
    ,catalog="mysql"
)

public class BadgeLoyalgiftDTO  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer badgeId;
     private Integer loyalGiftId;


    // Constructors

    /** default constructor */
    public BadgeLoyalgiftDTO() {
    }

    
    /** full constructor */
    public BadgeLoyalgiftDTO(Integer badgeId, Integer loyalGiftId) {
        this.badgeId = badgeId;
        this.loyalGiftId = loyalGiftId;
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
    
    @Column(name="badge_id", nullable=false)

    public Integer getBadgeId() {
        return this.badgeId;
    }
    
    public void setBadgeId(Integer badgeId) {
        this.badgeId = badgeId;
    }
    
    @Column(name="loyal_gift_id", nullable=false)

    public Integer getLoyalGiftId() {
        return this.loyalGiftId;
    }
    
    public void setLoyalGiftId(Integer loyalGiftId) {
        this.loyalGiftId = loyalGiftId;
    }
   








}