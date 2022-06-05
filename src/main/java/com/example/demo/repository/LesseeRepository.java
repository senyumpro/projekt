package com.example.demo.repository;

import com.example.demo.entity.Lessee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LesseeRepository extends JpaRepository<Lessee, Long> {
}
