package com.finartz.demo.airlineticketing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "airport")
public class Airport extends BaseModel {
    @Column(name = "name", unique = false, nullable = false, length = 50)
    private String name;

    @Column(name = "short_code", unique = true, nullable = false, length = 3)
    private String shortCode;

    public Airport() {
    }

    public Airport(String name, String shortCode) {
        this.name = name;
        this.shortCode = shortCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", shortCode='" + shortCode + '\'' +
                '}';
    }
}
