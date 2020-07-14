package com.finartz.demo.airlineticketing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "airline")
public class Airline extends BaseModel {

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "short_code", unique = true, nullable = false, length = 2)
    private String shortCode;

    public Airline() {
        super();
    }

    public Airline(String name, String shortCode) {
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
        return "Airline{" +
                "name='" + name + '\'' +
                ", shortCode='" + shortCode + '\'' +
                '}';
    }
}
