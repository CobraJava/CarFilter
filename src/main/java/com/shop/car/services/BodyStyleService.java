package com.shop.car.services;

import com.shop.car.entities.BodyStyle;
import com.shop.car.entities.Brand;

import java.util.List;

public interface BodyStyleService {
    List<BodyStyle> getAll();

    BodyStyle save(BodyStyle bodyStyle);

    void delete (Integer id);

    BodyStyle getById (Integer id);

    BodyStyle update (BodyStyle bodyStyle, Integer id);
}
