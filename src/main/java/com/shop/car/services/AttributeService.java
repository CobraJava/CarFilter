package com.shop.car.services;

import com.shop.car.entities.Attribute;

import java.util.List;

public interface AttributeService {

    List<Attribute> getAll();

    List<Attribute> getAllByIds(Iterable<Integer> ids);

    Attribute save(Attribute attribute);

    void delete (Integer id);

    Attribute getById (Integer id);

    Attribute update (Attribute attribute, Integer id);
}
