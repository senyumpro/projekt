package com.example.demo.dto;

import com.example.demo.entity.Lessor;
import com.example.demo.entity.Reservation;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

public class PlaceForRentDTO {

    private Long id;
    private String name;
    private double area;
    private double unitPrice;

    private Lessor lessor;

    private Reservation reservation;

    private String description;
}
