package com.shop.electronic.services;

import com.shop.electronic.dto.PaginationRequest;
import com.shop.electronic.dto.PaginationResponse;
import com.shop.electronic.entities.Category;
import com.shop.electronic.exceptions.CategoryNotFoundException;
import com.shop.electronic.repositories.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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


