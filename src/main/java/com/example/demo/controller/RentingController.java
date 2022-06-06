package com.example.demo.controller;

import com.example.demo.dto.LessorDTO;
import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Reservation;
import com.example.demo.service.RentingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class RentingController {

    @Autowired
    private RentingService rentingService;

    @GetMapping("/lessors")
    public List<LessorDTO> getAllLessors() {
        return rentingService.getAllLessors();
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
