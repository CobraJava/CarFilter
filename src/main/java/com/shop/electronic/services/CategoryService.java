package com.shop.electronic.services;

import com.shop.electronic.dto.PaginationRequest;
import com.shop.electronic.dto.PaginationResponse;
import com.shop.electronic.entities.Category;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Category save(Category category);

    void delete (Integer id);

    Category getById (Integer id);

    Category update (Category category, Integer id);

}
