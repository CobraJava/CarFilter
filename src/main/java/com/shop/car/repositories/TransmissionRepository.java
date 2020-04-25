package com.shop.car.repositories;

import com.shop.car.entities.PassengersCapacity;
import com.shop.car.entities.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransmissionRepository extends JpaRepository<Transmission, Integer> {
}
