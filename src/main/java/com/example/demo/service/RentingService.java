package com.example.demo.service;

import com.example.demo.dto.LesseeDTO;
import com.example.demo.dto.LessorDTO;
import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Lessee;
import com.example.demo.entity.Lessor;
import com.example.demo.entity.PlaceForRent;
import com.example.demo.entity.Reservation;
import com.example.demo.repository.LesseeRepository;
import com.example.demo.repository.LessorRepository;
import com.example.demo.repository.PlaceForRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public List<LessorDTO> getAllLessors() {
        return lessorRepository.findAll()
                .stream()
                .map(this::convertLessorEntityToDTO)
                .collect(Collectors.toList());
    }

    public Set<Reservation> getReservationsByLesseeId(Long lesseeId) {
        Lessee lessee = lesseeRepository.getReferenceById(lesseeId);
        return lessee.getReservations();
    }

    public Set<Reservation> getReservationsByPlaceForRentId(Long placeForRentId) {
        PlaceForRent placeForRent = placeForRentRepository.getReferenceById(placeForRentId);
        //return placeForRent.getReservations();
        return null;
    }

    private LessorDTO convertLessorEntityToDTO(Lessor lessor) {
        LessorDTO lessorDTO = new LessorDTO();
        lessorDTO.setId(lessor.getId());
        lessorDTO.setFirstName(lessor.getFirstName());
        lessorDTO.setLastName(lessor.getLastName());

        return lessorDTO;
    }
}
