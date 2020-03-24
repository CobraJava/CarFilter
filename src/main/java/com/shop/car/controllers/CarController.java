package com.shop.car.controllers;

import com.shop.car.dto.CarCriteriaRequest;
import com.shop.car.dto.CarDTO;
import com.shop.car.dto.PaginationResponse;
import com.shop.car.entities.Car;
import com.shop.car.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/item")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @PostMapping
    public Car create(CarDTO carDTO, @RequestParam("files") List<MultipartFile> files) throws IOException, IllegalAccessException {
        return carService.save(carDTO, files);
    }

    @GetMapping
    public PaginationResponse<Car> findAll(CarCriteriaRequest carCriteriaRequest){
        return carService.getAll(carCriteriaRequest);
    }

    @PutMapping("/{id}")
    public Car update(@PathVariable Integer id, CarDTO carDTO, @RequestBody List<MultipartFile> files ) throws IOException {
        return carService.update(carDTO, id, files);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        carService.delete(id);
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable Integer id){
        return  carService.getById(id);
    }
}
