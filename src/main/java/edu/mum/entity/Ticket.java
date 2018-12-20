package edu.mum.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private long id;

    @Temporal(TemporalType.DATE)
    @Column
    private Date issuedDate;

    @ManyToOne
    @JoinColumn(name = "PASSANGER_ID")
    private Member passanger;

    @ManyToOne
    @JoinColumn(name = "FLIGHT_ID")
    private Flight flight;

    @Column
    private int seatNo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Member getPassanger() {
        return passanger;
    }

    public void setPassanger(Member passanger) {
        this.passanger = passanger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }
}
