package com.example.demo.service;

import com.example.demo.dto.LessorDTO;
import com.example.demo.entity.Lessor;
import com.example.demo.repository.LessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.*;

import java.util.List;

@Service
public class RentingService {

    @Autowired
    private LessorRepository lessorRepository;

    public List<LessorDTO> getAllLessors() {
        return lessorRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private LessorDTO convertEntityToDto(Lessor member) {
        LessorDTO lessorDTO = new LessorDTO();
        lessorDTO.setId(member.getId());
        lessorDTO.setFirstName(member.getFirstName());
        lessorDTO.setLastName(member.getLastName());

        return lessorDTO;
    }
}
