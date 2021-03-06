package com.example.demo.dto;

import com.example.demo.entity.PlaceForRent;

public class LessorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private PlaceForRent placeForRent;

    public LessorDTO() {

    }
    public LessorDTO(Long id, String firstName, String lastName, PlaceForRent placeForRent) {
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
