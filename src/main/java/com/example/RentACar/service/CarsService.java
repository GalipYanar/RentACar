package com.example.RentACar.service;

import com.example.RentACar.exception.CarNotFoundException;
import com.example.RentACar.model.Cars;
import com.example.RentACar.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service

public class CarsService {

    private static final String UPLOAD_DIR = "upload";

    @Autowired
    private CarsRepository carsRepository;

    public Cars createCar(MultipartFile file, Cars cars){
        if (Objects.nonNull(file)){
            String imagePath = saveFile(file, cars.getModel());
            cars.setImage(imagePath);
        }else {
            Cars existCar = carsRepository.findById(cars.getId()).orElseThrow(() -> new CarNotFoundException("Car not found: " + cars.getModel()));
            cars.setImage(existCar.getImage());
        }
        return carsRepository.save(cars);
    }

    private String saveFile(MultipartFile file,String carModel){
        carModel = carModel.replaceAll("\\s", "");
        String fileName = carModel + "." + StringUtils.getFilenameExtension(file.getOriginalFilename());
        Path uploadPath = Path.of(UPLOAD_DIR);
        Path filePath;
        try {
            Files.createDirectories(uploadPath);
            filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return filePath.toString();
    }
}
