package com.finartz.demo.airlineticketing.model;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "flight", uniqueConstraints = @UniqueConstraint(columnNames={"flight_number", "flight_date", "flight_carrier_id"}))
@NamedQueries({
        @NamedQuery(name = "findFlightByFlightNumberDateCarrier",
                query = "SELECT f FROM Flight f WHERE (f.flightDate = :flightDate) AND (f.flightNumber = :flightNumber) AND (f.flightCarrier.shortCode = :fcShortCode)")
})
public class Flight extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "flight_carrier_id", referencedColumnName = "id")
    private Airline flightCarrier;

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id")
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
                "flightCarrier=" + flightCarrier.toString() +
                ", route=" + route.toString() +
                ", capacity=" + capacity +
                ", ticketCharge=" + ticketCharge +
                ", flightDate=" + flightDate +
                ", flightNumber=" + flightNumber +
                '}';
    }
}
