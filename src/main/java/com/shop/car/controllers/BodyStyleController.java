package com.shop.car.controllers;

import com.shop.car.entities.BodyStyle;
import com.shop.car.entities.Brand;
import com.shop.car.services.BodyStyleService;
import com.shop.car.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BodyStyleController {

    private final BodyStyleService bodyStyleService;

    public BodyStyleController(BodyStyleService bodyStyleService) {
        this.bodyStyleService = bodyStyleService;
    }

    @PostMapping
    public BodyStyle create(@RequestBody BodyStyle bodyStyle) { return bodyStyleService.save(bodyStyle);}

    @GetMapping
    public List<BodyStyle> findAll() {
        return bodyStyleService.getAll();
    }

    @PutMapping("/{id}")
    public BodyStyle update(@PathVariable Integer id, @RequestBody BodyStyle bodyStyle) { return bodyStyleService.update(bodyStyle, id); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { bodyStyleService.delete(id); }

    @GetMapping("/{id}")
    public BodyStyle findById(@PathVariable Integer id) { return bodyStyleService.getById(id); }

}
