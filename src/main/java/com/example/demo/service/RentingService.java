package com.example.demo.service;

import com.example.demo.dto.LesseeDTO;
import com.example.demo.dto.LessorDTO;
import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Lessee;
import com.example.demo.entity.Lessor;
import com.example.demo.entity.PlaceForRent;
import com.example.demo.entity.Reservation;
import com.example.demo.exceptions.ReservationAlreadyExistsException;
import com.example.demo.repository.LesseeRepository;
import com.example.demo.repository.LessorRepository;
import com.example.demo.repository.PlaceForRentRepository;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.Set;
import java.util.stream.*;

import java.util.List;

@Service
public class RentingService {

    @Autowired
    private LessorRepository lessorRepository;

    @Autowired
    private LesseeRepository lesseeRepository;

    @Autowired
    private PlaceForRentRepository placeForRentRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation addReservation(ReservationDTO reservation) {
        Set<Reservation> existingReservation = reservationRepository.findExistingReservation(reservation.getStartDate(), reservation.getEndDate(), reservation.getPlaceForRentId());//TODO check for null

        if (!existingReservation.isEmpty()) {
            throw new ReservationAlreadyExistsException(String.format("Reservation with: %s %s %s already exists", reservation.getStartDate(), reservation.getEndDate(), reservation.getPlaceForRentId()));
        }

        Reservation save = reservationRepository.save(convertReservationDTOtoEntity(reservation));

        return save;
    }

    public Reservation updateReservation(Reservation reservation) {
        Set<Reservation> existingReservation = reservationRepository.findExistingReservation(reservation.getStartDate(), reservation.getEndDate(), reservation.getPlaceForRent().getId());//TODO check for null

        if (!existingReservation.isEmpty()) {
            throw new ReservationAlreadyExistsException(String.format("Reservation with: %s %s %s already exists", reservation.getStartDate(), reservation.getEndDate(), reservation.getPlaceForRent().getId()));
        }

        reservationRepository.save(reservation);
        return reservation;
    }

    public Set<Reservation> getReservationsByLesseeId(Long lesseeId) {
        Lessee lessee = lesseeRepository.getReferenceById(lesseeId);
        return lessee.getReservations();
    }

    public Set<Reservation> getReservationsByPlaceForRentId(Long placeForRentId) {
        PlaceForRent placeForRent = placeForRentRepository.getReferenceById(placeForRentId);
        return placeForRent.getReservations();
    }



    private Reservation convertReservationDTOtoEntity(ReservationDTO reservationDTO) {
        Optional<Lessee> foundLessee = lesseeRepository.findById(reservationDTO.getLesseeId());

        if (foundLessee.isEmpty()) {
            throw new RuntimeException(); //TODO exception + mapping
        }

        Optional<PlaceForRent> foundPlaceForRent = placeForRentRepository.findById(reservationDTO.getPlaceForRentId());

        if (foundPlaceForRent.isEmpty()) {
            throw new RuntimeException(); //TODO exception + mapping
        }

        Reservation reservation = new Reservation(null, foundLessee.get(), foundPlaceForRent.get(), reservationDTO.getStartDate(), reservationDTO.getEndDate(), calculateCost());

        return reservation;
    }

    private double calculateCost() {
        //TODO
        return 10;
    }









    /*public List<LessorDTO> getAllLessors() {
        return lessorRepository.findAll()
                .stream()
                .map(this::convertLessorEntityToDTO)
                .collect(Collectors.toList());

    }

    private LessorDTO convertLessorEntityToDTO(Lessor lessor) {
        LessorDTO lessorDTO = new LessorDTO();
        lessorDTO.setId(lessor.getId());
        lessorDTO.setFirstName(lessor.getFirstName());
        lessorDTO.setLastName(lessor.getLastName());

        return lessorDTO;
    }*/
}
