package com.example.demo.repository;

import com.example.demo.entity.PlaceForRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceForRentRepository extends JpaRepository<PlaceForRent, Long> {
}
