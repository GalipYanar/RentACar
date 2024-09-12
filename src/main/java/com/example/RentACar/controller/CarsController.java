package com.example.RentACar.controller;

import com.example.RentACar.model.Cars;
import com.example.RentACar.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/cars")
@RestController

public class CarsController {

    @Autowired
    private CarsService carsService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/create", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Cars> createProduct(@RequestPart("file") MultipartFile file,
                                              @RequestPart("cars") Cars cars) {

        return new ResponseEntity<>(carsService.createCar(file, cars), HttpStatus.CREATED);
    }
}
