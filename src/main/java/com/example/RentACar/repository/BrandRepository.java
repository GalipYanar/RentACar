package com.example.RentACar.repository;

import com.example.RentACar.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Optional<Brand> findBrandByName(String name);
}
