package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "lessee_id")
    private Lessee lessee;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "place_for_rent_id")
    private PlaceForRent placeForRent;

    private int leaseTerm;
    private double cost;

    public Reservation() {

    }

    public Reservation(Long id, Lessee lessee, PlaceForRent placeForRent, int leaseTerm, double cost) {
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

    public int getLeaseTerm() {
        return leaseTerm;
    }

    public void setLeaseTerm(int leaseTerm) {
        this.leaseTerm = leaseTerm;
    }

    public Lessee getLessee() {
        return lessee;
    }

    public void setLessee(Lessee lessee) {
        this.lessee = lessee;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public PlaceForRent getPlaceForRent() {
        return placeForRent;
    }

    public void setPlaceForRent(PlaceForRent placeForRent) {
        this.placeForRent = placeForRent;
    }
}
