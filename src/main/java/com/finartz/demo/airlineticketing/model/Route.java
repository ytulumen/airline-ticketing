package com.finartz.demo.airlineticketing.model;

import javax.persistence.*;

@Entity
@Table(name = "route")
public class Route extends BaseModel {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "from_id", referencedColumnName = "id")
    private Airport from;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "to_id", referencedColumnName = "id")
    private Airport to;

    public Route() {
    }

    public Route(Airport from, Airport to) {
        this.from = from;
        this.to = to;
    }

    public Airport getFrom() {
        return from;
    }

    public void setFrom(Airport from) {
        this.from = from;
    }

    public Airport getTo() {
        return to;
    }

    public void setTo(Airport to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Route{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
