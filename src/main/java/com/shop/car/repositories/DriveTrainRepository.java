package com.shop.car.repositories;

import com.shop.car.entities.Brand;
import com.shop.car.entities.DriveTrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriveTrainRepository extends JpaRepository<DriveTrain, Integer> {
}