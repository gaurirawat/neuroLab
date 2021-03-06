package com.example.neuro.beans;

import com.example.neuro.utils.TestCategoryEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonRootName("Test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"test", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Vial> vials;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Double rate;

    @Enumerated(EnumType.STRING)
    private TestCategoryEnum testCategory;

    @Column(nullable = false)
    private Integer groupSize;

    private Integer lockedCounter;

    @Column(nullable = false)
    private boolean isActive;

    private Date lastActivDate;

    public Date getLastActivDate() {
        return lastActivDate;
    }

    public void setLastActivDate(Date lastActivDate) {
        this.lastActivDate = lastActivDate;
    }

    public List<Vial> getVials() {
        return vials;
    }

    public void setVials(List<Vial> vials) {
        this.vials = vials;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public TestCategoryEnum getTestCategory() {
        return testCategory;
    }

    public void setTestCategory(TestCategoryEnum testCategory) {
        this.testCategory = testCategory;
    }

    public Integer getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(Integer groupSize) {
        this.groupSize = groupSize;
    }

    public Integer getLockedCounter() {
        return lockedCounter;
    }

    public void setLockedCounter(Integer lockedCounter) {
        this.lockedCounter = lockedCounter;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", testCategory=" + testCategory +
                ", groupSize=" + groupSize +
                ", lockedCounter=" + lockedCounter +
                ", isActive=" + isActive +
                ", lastActivDate=" + lastActivDate +
                '}';
    }

    public Test() {
    }
}
