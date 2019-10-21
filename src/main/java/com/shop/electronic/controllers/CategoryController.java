package com.shop.electronic.controllers;

import com.shop.electronic.dto.PaginationRequest;
import com.shop.electronic.dto.PaginationResponse;
import com.shop.electronic.entities.Category;
import com.shop.electronic.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) { this.categoryService = categoryService; }

    @PostMapping
    public Category create(@RequestBody Category category) { return categoryService.save(category);}

    @GetMapping
    public PaginationResponse<Category> findAll(PaginationRequest paginationRequest) {
        return categoryService.getAll(paginationRequest);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Integer id, @RequestBody Category category) { return categoryService.update(category, id); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { categoryService.delete(id); }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Integer id) { return categoryService.getById(id); }

}
