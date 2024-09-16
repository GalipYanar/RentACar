package com.example.RentACar.repository;

import com.example.RentACar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE c.brandId = :brandId")
    List<Car> findCarListByBrandId(Long brandId);

    @Transactional
    @Modifying
    @Query("UPDATE Car c SET c.active = :active WHERE c.id = :id")
    void updateCarActive(@Param("active") Boolean isActive, @Param("id") Long id);
}
