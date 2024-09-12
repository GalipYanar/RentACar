package com.example.RentACar.model;

import com.example.RentACar.enumm.FuelType;
import com.example.RentACar.enumm.TransmissionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cars")

public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private String colour;

    private Double dailyPrice;

    private Double km;

    private TransmissionType transmissionType;

    private FuelType fuelType;

    @Column(name = "units_in_stock")
    private Long unitInStock;

    @Column(name = "brand_id")
    private Long brandId;

    private String image;

    private Boolean active;
}
