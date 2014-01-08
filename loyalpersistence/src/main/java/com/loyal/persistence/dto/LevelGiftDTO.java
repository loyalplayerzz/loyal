package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * LevelGift entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="LEVEL_GIFT"
    ,catalog="mysql"
)

public class LevelGiftDTO  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer levelId;
     private Integer giftId;


    // Constructors

    /** default constructor */
    public LevelGiftDTO() {
    }

    
    /** full constructor */
    public LevelGiftDTO(Integer levelId, Integer giftId) {
        this.levelId = levelId;
        this.giftId = giftId;
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
    
    @Column(name="level_id", nullable=false)

    public Integer getLevelId() {
        return this.levelId;
    }
    
    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }
    
    @Column(name="gift_id", nullable=false)

    public Integer getGiftId() {
        return this.giftId;
    }
    
    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }
   








}