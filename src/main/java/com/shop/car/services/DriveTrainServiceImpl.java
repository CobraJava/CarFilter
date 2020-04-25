package com.shop.car.services;

import com.shop.car.entities.DriveTrain;
import com.shop.car.exceptions.DriveTrainNotFoundException;
import com.shop.car.repositories.DriveTrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriveTrainServiceImpl implements DriveTrainService {

private DriveTrainRepository driveTrainRepository;

    public DriveTrainServiceImpl(DriveTrainRepository driveTrainRepository) {
        this.driveTrainRepository = driveTrainRepository;
    }

    @Override
    public List<DriveTrain> getAll() {
        return driveTrainRepository.findAll();
    }

    @Override
    public DriveTrain save(DriveTrain driveTrain) { return driveTrainRepository.save(driveTrain); }

    @Override
    public void delete(Integer id) { driveTrainRepository.delete(getById(id));}

    @Override
    public DriveTrain getById(Integer id) {
        return driveTrainRepository.findById(id).orElseThrow(()->new DriveTrainNotFoundException(id));}

    @Override
    public DriveTrain update(DriveTrain driveTrain, Integer id) {
        DriveTrain updatedDriveTrain = getById(id);
        updatedDriveTrain.setName(driveTrain.getName());
        return updatedDriveTrain;
    }


}
