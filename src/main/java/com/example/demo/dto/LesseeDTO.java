package com.example.demo.dto;

import com.example.demo.entity.Reservation;

import java.util.Set;

public class LesseeDTO {

    public Long id;
    public String firstName;
    public String lastName;
    public Set<Reservation> reservations;

    public LesseeDTO() {

    }

    public LesseeDTO(Long id, String firstName, String lastName, Set<Reservation> reservations) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.reservations = reservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
