package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * Loyalpoints entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="LOYALPOINTS"
    ,catalog="mysql"
)

public class LoyalpointsDTO  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer bet;
     private String currency;
     private Integer points;


    // Constructors

    /** default constructor */
    public LoyalpointsDTO() {
    }

    
    /** full constructor */
    public LoyalpointsDTO(Integer bet, String currency, Integer points) {
        this.bet = bet;
        this.currency = currency;
        this.points = points;
    }

   
    // Property accessors
   // @SequenceGenerator(name="generator")@Id @GeneratedValue(strategy=SEQUENCE, generator="generator")
    @Id
    @GeneratedValue
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="bet")

    public Integer getBet() {
        return this.bet;
    }
    
    public void setBet(Integer bet) {
        this.bet = bet;
    }
    
    @Column(name="currency", length=20)

    public String getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    @Column(name="points")

    public Integer getPoints() {
        return this.points;
    }
    
    public void setPoints(Integer points) {
        this.points = points;
    }
   








}