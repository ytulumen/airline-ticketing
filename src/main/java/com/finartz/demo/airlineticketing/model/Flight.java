package com.finartz.demo.airlineticketing.model;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.sql.Timestamp;

@Entity
@Table(name = "flight")
@NamedQueries({
        @NamedQuery(name = "findFlightByFlightNumberDateCarrier",
                query = "SELECT f FROM Flight f WHERE (f.flightDate = :flightDate) AND (f.flightNumber = :flightNumber) AND (f.flightCarrier.shortCode = :fcShortCode)")
})
public class Flight extends BaseModel{
    @Column(name = "flight_carrier", nullable = false)
    private Airline flightCarrier;

    @Column(name = "route", nullable = false)
    private Route route;

    @Column
    private int capacity;

    @Column(name = "ticket_charge")
    private float ticketCharge;

    @Column(name = "flight_date", nullable = false)
    private Timestamp flightDate;

    @Column(name = "flight_number")
    private int flightNumber;

    public Flight() {
    }

    public Flight(Airline flightCarrier, Route route, int capacity, float ticketCharge, Timestamp flightDate, int flightNumber) {
        this.flightCarrier = flightCarrier;
        this.route = route;
        this.capacity = capacity;
        this.ticketCharge = ticketCharge;
        this.flightDate = flightDate;
        this.flightNumber = flightNumber;
    }


    public Airline getFlightCarrier() {
        return flightCarrier;
    }

    public void setFlightCarrier(Airline flightCarrier) {
        this.flightCarrier = flightCarrier;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getTicketCharge() {
        return ticketCharge;
    }

    public void setTicketCharge(float ticketCharge) {
        this.ticketCharge = ticketCharge;
    }

    public Timestamp getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Timestamp flightDate) {
        this.flightDate = flightDate;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }


    @Override
    public String toString() {
        return "Flight{" +
                "flightCarrier=" + flightCarrier +
                ", route=" + route +
                ", capacity=" + capacity +
                ", ticketCharge=" + ticketCharge +
                ", flightDate=" + flightDate +
                ", flightNumber=" + flightNumber +
                '}';
    }
}
