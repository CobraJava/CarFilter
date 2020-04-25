package com.shop.car.services;

import com.shop.car.entities.BodyStyle;
import com.shop.car.entities.DriveTrain;

import java.util.List;

public interface DriveTrainService {
    List<DriveTrain> getAll();

    DriveTrain save(DriveTrain driveTrain);

    void delete (Integer id);

    DriveTrain getById (Integer id);

    DriveTrain update (DriveTrain driveTrain, Integer id);
}
