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
    private String id;

    private String model;

    private String colour;

    private Double dailyPrice;

    private Double km;

    private TransmissionType transmissionType;

    private FuelType fuelType;
}
