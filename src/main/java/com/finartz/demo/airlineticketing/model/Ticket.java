package com.finartz.demo.airlineticketing.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket extends BaseModel{
    @OneToOne
    @JoinColumn(name = "flight", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Flight flight;

    @Column
    private float price;

    public Ticket() {
    }

    public Ticket(Flight flight, float price) {
        this.flight = flight;
        this.price = price;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "flight=" + flight +
                ", price=" + price +
                '}';
    }
}
