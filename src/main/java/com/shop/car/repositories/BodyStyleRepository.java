package com.shop.car.repositories;

import com.shop.car.entities.BodyStyle;
import com.shop.car.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyStyleRepository extends JpaRepository<BodyStyle, Integer> {
}