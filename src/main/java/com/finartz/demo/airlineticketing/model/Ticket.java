package com.finartz.demo.airlineticketing.model;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private Flight flight;

    @Column
    private float price;

    @Column(name = "credit_card_number", nullable = false, length = 16)
    private String creditCardNumber;

    public Ticket() {
    }

    public Ticket(Flight flight, float price, String creditCardNumber) {
        this.flight = flight;
        this.price = price;
        this.creditCardNumber = creditCardNumber;
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

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "flight=" + flight.toString() +
                ", price=" + price +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                '}';
    }
}
