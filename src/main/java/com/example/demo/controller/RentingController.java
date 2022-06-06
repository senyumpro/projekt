package com.example.demo.controller;

import com.example.demo.dto.LessorDTO;
import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Reservation;
import com.example.demo.service.RentingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class RentingController {

    @Autowired
    private RentingService rentingService;

    @PostMapping("reservations/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return rentingService.addReservation(reservation);
    }

    @PutMapping("reservations/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return rentingService.updateReservation(reservation);
    }

    @GetMapping("/reservations/reservationsByName/{lessorId}")
    public Set<Reservation> getReservationsByLesseeId(@PathVariable Long lessorId) {
        return rentingService.getReservationsByLesseeId(lessorId);
    }

    @GetMapping("reservations/reservationsByPlace/{placeForRentId}")
    public Set<Reservation> getReservationsByPlaceForRentId(@PathVariable Long placeForRentId) {
        return rentingService.getReservationsByPlaceForRentId(placeForRentId);
    }

}
