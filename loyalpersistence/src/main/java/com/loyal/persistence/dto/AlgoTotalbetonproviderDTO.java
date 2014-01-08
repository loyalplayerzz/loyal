package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * AlgoTotalbetonprovider entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALGO_TOTALBETONPROVIDER"
    ,catalog="mysql"
)

public class AlgoTotalbetonproviderDTO  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String providerId;
     private Integer betAmt;
     private Integer noOfDays;


    // Constructors

    /** default constructor */
    public AlgoTotalbetonproviderDTO() {
    }

    
    /** full constructor */
    public AlgoTotalbetonproviderDTO(String providerId, Integer betAmt, Integer noOfDays) {
        this.providerId = providerId;
        this.betAmt = betAmt;
        this.noOfDays = noOfDays;
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
    
    @Column(name="provider_id", length=100)

    public String getProviderId() {
        return this.providerId;
    }
    
    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
    
    @Column(name="bet_amt")

    public Integer getBetAmt() {
        return this.betAmt;
    }
    
    public void setBetAmt(Integer betAmt) {
        this.betAmt = betAmt;
    }
    
    @Column(name="no_of_days")

    public Integer getNoOfDays() {
        return this.noOfDays;
    }
    
    public void setNoOfDays(Integer noOfDays) {
        this.noOfDays = noOfDays;
    }
   








}