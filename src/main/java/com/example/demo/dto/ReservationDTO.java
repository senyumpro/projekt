package com.example.demo.dto;

import com.example.demo.entity.Lessee;
import com.example.demo.entity.PlaceForRent;

import javax.persistence.*;

public class ReservationDTO {

    private Long id;
    private Lessee lessee;
    private PlaceForRent placeForRent;
    private int leaseTerm;
    private double cost;

    public ReservationDTO() {

    }

    public ReservationDTO(Long id, Lessee lessee, PlaceForRent placeForRent, int leaseTerm, double cost) {
        this.id = id;
        this.lessee = lessee;
        this.placeForRent = placeForRent;
        this.leaseTerm = leaseTerm;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lessee getLessee() {
        return lessee;
    }

    public void setLessee(Lessee lessee) {
        this.lessee = lessee;
    }

    public PlaceForRent getPlaceForRent() {
        return placeForRent;
    }

    public void setPlaceForRent(PlaceForRent placeForRent) {
        this.placeForRent = placeForRent;
    }

    public int getLeaseTerm() {
        return leaseTerm;
    }

    public void setLeaseTerm(int leaseTerm) {
        this.leaseTerm = leaseTerm;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
