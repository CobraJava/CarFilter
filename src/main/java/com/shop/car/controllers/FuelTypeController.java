package com.shop.car.controllers;

import com.shop.car.entities.DriveTrain;
import com.shop.car.entities.FuelType;
import com.shop.car.services.FuelTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class FuelTypeController {

    private FuelTypeService fuelTypeService;

    public FuelTypeController(FuelTypeService fuelTypeService) {
        this.fuelTypeService = fuelTypeService;
    }
    @PostMapping
    public FuelType create(@RequestBody FuelType fuelType) { return fuelTypeService.save(fuelType);}

    @GetMapping
    public List<FuelType> findAll() {
        return fuelTypeService.getAll();
    }

    @PutMapping("/{id}")
    public FuelType update(@PathVariable Integer id, @RequestBody FuelType fuelType) { return fuelTypeService.update(fuelType, id); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { fuelTypeService.delete(id); }

    @GetMapping("/{id}")
    public FuelType findById(@PathVariable Integer id) { return fuelTypeService.getById(id); }
}
