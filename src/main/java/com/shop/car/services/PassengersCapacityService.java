package com.shop.car.services;

import com.shop.car.entities.FuelType;
import com.shop.car.entities.PassengersCapacity;

import java.util.List;

public interface PassengersCapacityService {

    List<PassengersCapacity> getAll();

    PassengersCapacity save(PassengersCapacity passengersCapacity);

    void delete (Integer id);

    PassengersCapacity getById (Integer id);

    PassengersCapacity update (PassengersCapacity passengersCapacity, Integer id);
}
