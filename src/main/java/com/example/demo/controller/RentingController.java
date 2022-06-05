package com.example.demo.controller;

import com.example.demo.dto.LessorDTO;
import com.example.demo.service.RentingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentingController {

    @Autowired
    private RentingService lessorService;

    @GetMapping("/lessors")
    public List<LessorDTO> getAllLessors() {
        return lessorService.getAllLessors();
    }
}
