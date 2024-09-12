package com.example.RentACar.repository;

import com.example.RentACar.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Cars, Long> {
}
