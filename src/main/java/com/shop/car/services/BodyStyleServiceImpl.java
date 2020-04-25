package com.shop.car.services;

import com.shop.car.entities.BodyStyle;
import com.shop.car.exceptions.BodyStyleNotFoundException;
import com.shop.car.repositories.BodyStyleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodyStyleServiceImpl implements BodyStyleService {

    private BodyStyleRepository bodyStyleRepository;

    public BodyStyleServiceImpl(BodyStyleRepository bodyStyleRepository) {this.bodyStyleRepository = bodyStyleRepository;}

    @Override
    public List<BodyStyle> getAll() {
        return bodyStyleRepository.findAll();
    }

    @Override
    public BodyStyle save(BodyStyle bodyStyle) {
        return bodyStyleRepository.save(bodyStyle);
    }

    @Override
    public void delete(Integer id) { bodyStyleRepository.delete(getById(id));}

    @Override
    public BodyStyle getById(Integer id) {
        return bodyStyleRepository.findById(id).orElseThrow(()->new BodyStyleNotFoundException(id)); }

    @Override
    public BodyStyle update(BodyStyle bodyStyle, Integer id) {
        BodyStyle updatedBodyStyle = getById(id);
        updatedBodyStyle.setName(bodyStyle.getName());
        return updatedBodyStyle;
    }
}
