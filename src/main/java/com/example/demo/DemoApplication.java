package com.example.demo;


import com.example.demo.entity.Lessor;
import com.example.demo.repository.LessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired

	private LessorRepository lessorRepository;

	@Override
	public void run(String... args) throws Exception {
		Lessor lessor = new Lessor();
		lessor.setFirstName("John");
		lessor.setLastName("Dupa");
		lessorRepository.save(lessor);
	}
}