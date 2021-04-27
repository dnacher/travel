package com.travels.travel.persistence.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "travel")
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "passenger_name")
    private String passengerName;

    @Column(name = "passenger_birth_date")
    private Date passengerBirthDate;

    @Column(name = "passport")
    private String passport;

    @Column(name = "email")
    private String email;

    @JoinTable(
            name = "flight_travel",
            joinColumns = @JoinColumn(name = "travel_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="flight_id", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Flight> flights;

    public Travel(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Date getPassengerBirthDate() {
        return passengerBirthDate;
    }

    public void setPassengerBirthDate(Date passengerBirthDate) {
        this.passengerBirthDate = passengerBirthDate;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
