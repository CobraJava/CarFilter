package com.shop.car.controllers;

import com.shop.car.entities.Transmission;
import com.shop.car.services.TransmissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TransmissionController {
    private TransmissionService transmissionService;

    public TransmissionController(TransmissionService transmissionService) {
        this.transmissionService = transmissionService;
    }

    @PostMapping
    public Transmission create(@RequestBody Transmission transmission) { return transmissionService.save(transmission);}

    @GetMapping
    public List<Transmission> findAll() { return transmissionService.getAll(); }

    @PutMapping("/{id}")
    public Transmission update(@PathVariable Integer id, @RequestBody Transmission transmission) { return transmissionService.update(transmission, id); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { transmissionService.delete(id); }

    @GetMapping("/{id}")
    public Transmission findById(@PathVariable Integer id) { return transmissionService.getById(id); }
}
