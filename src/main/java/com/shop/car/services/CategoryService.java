package com.shop.car.services;

import com.shop.car.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Category save(Category category);

    void delete (Integer id);

    Category getById (Integer id);

    Category update (Category category, Integer id);

}
