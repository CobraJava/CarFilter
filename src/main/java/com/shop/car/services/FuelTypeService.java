package com.shop.car.services;

import com.shop.car.entities.DriveTrain;
import com.shop.car.entities.FuelType;

import java.util.List;

public interface FuelTypeService {
    List<FuelType> getAll();

    FuelType save(FuelType fuelType);

    void delete (Integer id);

    FuelType getById (Integer id);

    FuelType update (FuelType fuelType, Integer id);
}
