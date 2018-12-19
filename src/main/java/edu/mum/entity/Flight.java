package edu.mum.entity;

import javax.persistence.*;

@Entity
public class Flight {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "FROM_AIRPORT_ID")
    Airport fromAirport;

    @ManyToOne
    @JoinColumn(name = "TO_AIRPORT_ID")
    Airport toAirport;

    @ManyToOne
    @JoinColumn(name = "AIRLINE_ID")
    private AirLine airline;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airport getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(Airport fromAirport) {
        this.fromAirport = fromAirport;
    }

    public Airport getToAirport() {
        return toAirport;
    }

    public void setToAirport(Airport toAirport) {
        this.toAirport = toAirport;
    }

    public AirLine getAirline() {
        return airline;
    }

    public void setAirline(AirLine airline) {
        this.airline = airline;
    }
}
