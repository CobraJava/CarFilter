package com.shop.car.controllers;

import com.shop.car.entities.Attribute;
import com.shop.car.services.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{attribute}")
public class AttributeController {

    private final AttributeService attributeService;

    @Autowired
    public AttributeController(AttributeService attributeService) { this.attributeService = attributeService; }

    @PostMapping
    public Attribute create(@RequestBody @Validated Attribute attribute) { return attributeService.save(attribute);}

    @GetMapping
    public List<Attribute> findAll() { return attributeService.getAll(); }

    @PutMapping("/{id}")
    public Attribute update(@PathVariable Integer id, @RequestBody Attribute attribute) { return attributeService.update(attribute, id); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { attributeService.delete(id); }

    @GetMapping("/{id}")
    public Attribute findById(@PathVariable Integer id) { return attributeService.getById(id); }

}
