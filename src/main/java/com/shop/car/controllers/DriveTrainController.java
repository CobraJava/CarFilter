package com.shop.car.controllers;

import com.shop.car.entities.BodyStyle;
import com.shop.car.entities.DriveTrain;
import com.shop.car.services.DriveTrainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class DriveTrainController {

    private final DriveTrainService driveTrainService;

    public DriveTrainController(DriveTrainService driveTrainService) {
        this.driveTrainService = driveTrainService;
    }
    @PostMapping
    public DriveTrain create(@RequestBody DriveTrain driveTrain) { return driveTrainService.save(driveTrain);}

    @GetMapping
    public List<DriveTrain> findAll() {
        return driveTrainService.getAll();
    }

    @PutMapping("/{id}")
    public DriveTrain update(@PathVariable Integer id, @RequestBody DriveTrain driveTrain) { return driveTrainService.update(driveTrain, id); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { driveTrainService.delete(id); }

    @GetMapping("/{id}")
    public DriveTrain findById(@PathVariable Integer id) { return driveTrainService.getById(id); }
}
