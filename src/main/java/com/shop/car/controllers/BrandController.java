package com.shop.car.controllers;

import com.shop.car.entities.Brand;
import com.shop.car.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) { this.brandService = brandService; }

    @PostMapping
    public Brand create(@RequestBody Brand brand) { return brandService.save(brand);}

    @GetMapping
    public List<Brand> findAll() {
        return brandService.getAll();
    }

    @PutMapping("/{id}")
    public Brand update(@PathVariable Integer id, @RequestBody Brand brand) { return brandService.update(brand, id); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { brandService.delete(id); }

    @GetMapping("/{id}")
    public Brand findById(@PathVariable Integer id) { return brandService.getById(id); }

}
