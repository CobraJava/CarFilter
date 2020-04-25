package com.shop.car.services;

import com.shop.car.entities.Transmission;

import java.util.List;

public interface TransmissionService {
    List<Transmission> getAll();

    Transmission save(Transmission transmission);

    void delete (Integer id);

    Transmission getById (Integer id);

    Transmission update (Transmission transmission, Integer id);
}
