package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "lessors")
public class Lessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String firstName;
    public String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_for_rent_id")
    public PlaceForRent placeForRent;

    public Lessor() {

    }

    public Lessor(Long id, String firstName, String lastName, PlaceForRent placeForRent) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.placeForRent = placeForRent;
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

    public PlaceForRent getPlaceForRent() {
        return placeForRent;
    }

    public void setPlaceForRent(PlaceForRent placeForRent) {
        this.placeForRent = placeForRent;
    }
}
