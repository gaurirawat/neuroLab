package com.example.neuro.beans;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@JsonRootName("Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @ManyToOne(optional = false, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "masterId")
    @JsonIgnoreProperties(value = {"payments", "hibernateLazyInitializer"}, allowSetters = true)
    private Master master;

    private Double amount;

    private String details;


    private Date transactionDate= Date.valueOf(LocalDate.now());

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", master=" + master +
                ", amount=" + amount +
                ", details='" + details + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }

    public Payment() {
    }
}
