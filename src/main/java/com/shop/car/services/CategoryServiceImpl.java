package com.shop.car.services;

import com.shop.car.entities.Category;
import com.shop.car.exceptions.CategoryNotFoundException;
import com.shop.car.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) { this.categoryRepository = categoryRepository; }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) { return categoryRepository.save(category); }

    @Override
    public void delete(Integer id) { categoryRepository.delete(getById(id));}

    @Override
    public Category getById(Integer id) { return categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException(id)); }

    @Transactional
    @Override
    public Category update(Category category, Integer id) {
        Category updatedCategory = getById(id);
        updatedCategory.setName(category.getName());
        return updatedCategory;
    }
}


