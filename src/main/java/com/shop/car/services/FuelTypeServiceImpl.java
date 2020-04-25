package com.shop.car.services;

import com.shop.car.entities.FuelType;
import com.shop.car.exceptions.FuelTypeNotFoundException;
import com.shop.car.repositories.FuelTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelTypeServiceImpl implements FuelTypeService {

    private FuelTypeRepository fuelTypeRepository;

    public FuelTypeServiceImpl(FuelTypeRepository fuelTypeRepository) {
        this.fuelTypeRepository = fuelTypeRepository;
    }

    @Override
    public List<FuelType> getAll() { return fuelTypeRepository.findAll(); }

    @Override
    public FuelType save(FuelType fuelType) { return fuelTypeRepository.save(fuelType); }

    @Override
    public void delete(Integer id) { fuelTypeRepository.delete(getById(id));}

    @Override
    public FuelType getById(Integer id) { return fuelTypeRepository.findById(id).orElseThrow(()-> new FuelTypeNotFoundException(id)); }

    @Override
    public FuelType update(FuelType fuelType, Integer id) {
        FuelType updatedFuelType = getById(id);
        updatedFuelType.setName(fuelType.getName());
        return updatedFuelType;
    }
}
