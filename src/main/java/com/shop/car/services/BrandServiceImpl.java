package com.shop.car.services;

import com.shop.car.entities.Brand;
import com.shop.car.exceptions.BrandNotFoundException;
import com.shop.car.repositories.BrandRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) { this.brandRepository = brandRepository; }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand save(Brand brand) { return brandRepository.save(brand); }

    @Override
    public void delete(Integer id) { brandRepository.delete(getById(id));}

    @Override
    public Brand getById(Integer id) { return brandRepository.findById(id).orElseThrow(()->new BrandNotFoundException(id)); }

    @Transactional
    @Override
    public Brand update(Brand brand, Integer id) {
        Brand updatedBrand = getById(id);
        updatedBrand.setName(brand.getName());
        return updatedBrand;
    }
}


