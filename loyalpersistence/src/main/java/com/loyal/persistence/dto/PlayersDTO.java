package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Players entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="PLAYERS"
    ,catalog="mysql"
)

public class PlayersDTO  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Boolean active;
     private String externalUserId;
     private Integer betAmt;
     private Boolean loyalpointsEligibile;
     private Boolean badgesEligible;
     private Integer age;
     private String sex;
     private String country;


    // Constructors

    /** default constructor */
    public PlayersDTO() {
    }

	/** minimal constructor */
    public PlayersDTO(String externalUserId) {
        this.externalUserId = externalUserId;
    }
    
    /** full constructor */
    public PlayersDTO(Boolean active, String externalUserId, Integer betAmt, Boolean loyalpointsEligibile, Boolean badgesEligible, Integer age, String sex, String country) {
        this.active = active;
        this.externalUserId = externalUserId;
        this.betAmt = betAmt;
        this.loyalpointsEligibile = loyalpointsEligibile;
        this.badgesEligible = badgesEligible;
        this.age = age;
        this.sex = sex;
        this.country = country;
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
    
    @Column(name="active")

    public Boolean getActive() {
        return this.active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    @Column(name="external_user_id", nullable=false, length=20)

    public String getExternalUserId() {
        return this.externalUserId;
    }
    
    public void setExternalUserId(String externalUserId) {
        this.externalUserId = externalUserId;
    }
    
    @Column(name="bet_amt")

    public Integer getBetAmt() {
        return this.betAmt;
    }
    
    public void setBetAmt(Integer betAmt) {
        this.betAmt = betAmt;
    }
    
    @Column(name="loyalpoints_eligibile")

    public Boolean getLoyalpointsEligibile() {
        return this.loyalpointsEligibile;
    }
    
    public void setLoyalpointsEligibile(Boolean loyalpointsEligibile) {
        this.loyalpointsEligibile = loyalpointsEligibile;
    }
    
    @Column(name="badges_eligible")

    public Boolean getBadgesEligible() {
        return this.badgesEligible;
    }
    
    public void setBadgesEligible(Boolean badgesEligible) {
        this.badgesEligible = badgesEligible;
    }
    
    @Column(name="age")

    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    @Column(name="sex", length=1)

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    @Column(name="country", length=25)

    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
   








}