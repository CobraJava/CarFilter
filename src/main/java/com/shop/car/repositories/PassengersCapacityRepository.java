package com.shop.car.repositories;

import com.shop.car.entities.PassengersCapacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengersCapacityRepository extends JpaRepository<PassengersCapacity, Integer> {
}