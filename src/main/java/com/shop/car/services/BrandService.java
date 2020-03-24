package com.shop.car.services;

import com.shop.car.entities.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getAll();

    Brand save(Brand brand);

    void delete (Integer id);

    Brand getById (Integer id);

    Brand update (Brand brand, Integer id);

}
