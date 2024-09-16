package com.example.RentACar.controller;

import com.example.RentACar.model.Brand;
import com.example.RentACar.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/brand")
@RestController

public class BrandController {

    @Autowired
    private BrandService brandService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand){
        return new ResponseEntity<>(brandService.createBrand(brand), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("id") Long id){
        brandService.deleteBrand(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
