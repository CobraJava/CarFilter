package com.shop.car.services;

import com.shop.car.entities.PassengersCapacity;
import com.shop.car.exceptions.PassengersCapacityNotFoundException;
import com.shop.car.repositories.PassengersCapacityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengersCapacityServiceImpl implements PassengersCapacityService {

     private PassengersCapacityRepository passengersCapacityRepository;

    public PassengersCapacityServiceImpl(PassengersCapacityRepository passengersCapacityRepository) {
        this.passengersCapacityRepository = passengersCapacityRepository;
    }

    @Override
    public List<PassengersCapacity> getAll() { return passengersCapacityRepository.findAll(); }

    @Override
    public PassengersCapacity save(PassengersCapacity passengersCapacity) { return passengersCapacityRepository.save(passengersCapacity); }

    @Override
    public void delete(Integer id) { passengersCapacityRepository.delete(getById(id));}

    @Override
    public PassengersCapacity getById(Integer id) { return passengersCapacityRepository.findById(id).orElseThrow(()-> new PassengersCapacityNotFoundException(id)); }

    @Override
    public PassengersCapacity update(PassengersCapacity passengersCapacity, Integer id) {
        PassengersCapacity updatedPassengersCapacity = getById(id);
        updatedPassengersCapacity.setName(passengersCapacity.getName());
        return updatedPassengersCapacity;
    }
}
