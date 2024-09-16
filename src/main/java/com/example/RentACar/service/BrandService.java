package com.example.RentACar.service;

import com.example.RentACar.exception.BrandDeleteException;
import com.example.RentACar.exception.BrandDuplicateException;
import com.example.RentACar.model.Brand;
import com.example.RentACar.repository.BrandRepository;
import com.example.RentACar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CarRepository carRepository;

    public Brand createBrand(Brand brand){
        if (brand.getName() == null || brand.getName().trim().isEmpty()){
            throw new IllegalArgumentException("Brand name can not be empty.");
        }
        Optional<Brand> optionalBrand = brandRepository.findBrandByName(brand.getName());
        if (optionalBrand.isPresent()){
            throw new BrandDuplicateException("Brand is already exist." + brand.getName());
        }
        return brandRepository.save(brand);
    }

    public void deleteBrand(Long id){
        Long getCarCountByProductId = carRepository.getCarCountByProductId(id);
        if (getCarCountByProductId > 0){
            throw new BrandDeleteException("You can not delete this brand, because brand has = " + getCarCountByProductId + " cars.");
        }
        brandRepository.deleteById(id);
    }
}
