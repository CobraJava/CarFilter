package com.shop.car.controllers;

import com.shop.car.entities.FuelType;
import com.shop.car.entities.PassengersCapacity;
import com.shop.car.services.FuelTypeService;
import com.shop.car.services.PassengersCapacityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PassengersCapacityController {

    private PassengersCapacityService passengersCapacityService;

    public PassengersCapacityController(PassengersCapacityService passengersCapacityService) {
        this.passengersCapacityService = passengersCapacityService;
    }

    @PostMapping
    public PassengersCapacity create(@RequestBody PassengersCapacity passengersCapacity) { return passengersCapacityService.save(passengersCapacity);}

    @GetMapping
    public List<PassengersCapacity> findAll() { return passengersCapacityService.getAll(); }

    @PutMapping("/{id}")
    public PassengersCapacity update(@PathVariable Integer id, @RequestBody PassengersCapacity passengersCapacity) { return passengersCapacityService.update(passengersCapacity, id); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { passengersCapacityService.delete(id); }

    @GetMapping("/{id}")
    public PassengersCapacity findById(@PathVariable Integer id) { return passengersCapacityService.getById(id); }
}