package com.shop.car.services;

import com.shop.car.entities.Transmission;
import com.shop.car.exceptions.TransmissionNotFoundException;
import com.shop.car.repositories.TransmissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransmissionServiceImpl implements TransmissionService {

    private TransmissionRepository transmissionRepository;

    public TransmissionServiceImpl(TransmissionRepository transmissionRepository) {
        this.transmissionRepository = transmissionRepository;
    }

    @Override
    public List<Transmission> getAll() { return transmissionRepository.findAll(); }

    @Override
    public Transmission save(Transmission transmission) { return transmissionRepository.save(transmission); }

    @Override
    public void delete(Integer id) { transmissionRepository.delete(getById(id));}

    @Override
    public Transmission getById(Integer id) { return transmissionRepository.findById(id).orElseThrow(()-> new TransmissionNotFoundException(id)); }

    @Override
    public Transmission update(Transmission transmission, Integer id) {
        Transmission updatedTransmission = getById(id);
        updatedTransmission.setName(transmission.getName());
        return updatedTransmission; }
}
