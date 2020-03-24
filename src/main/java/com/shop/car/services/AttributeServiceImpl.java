package com.shop.car.services;

import com.shop.car.entities.Attribute;
import com.shop.car.exceptions.AttributeNotFoundException;
import com.shop.car.repositories.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {

    private AttributeRepository attributeRepository;

    @Autowired
    public AttributeServiceImpl(AttributeRepository attributeRepository) { this.attributeRepository = attributeRepository; }


    @Override
    public List<Attribute> getAll() { return attributeRepository.findAll(); }

    @Override
    public List<Attribute> getAllByIds(Iterable<Integer> ids) {
        return attributeRepository.findAllById(ids);
    }

    @Override
    public Attribute save(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    @Override
    public void delete(Integer id) {
        attributeRepository.delete(getById(id));
    }

    @Override
    public Attribute getById(Integer id) {
        return attributeRepository.findById(id).orElseThrow(()->new AttributeNotFoundException(id));
    }

    @Override
    public Attribute update(Attribute attribute, Integer id) {
        return null;
    }
}
