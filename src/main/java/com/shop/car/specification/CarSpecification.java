package com.shop.car.specification;

import com.shop.car.dto.CarCriteriaRequest;
import com.shop.car.entities.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class CarSpecification implements Specification<Car> {
    private Float minPrice;
    private Float maxPrice;
    private Integer brandId;
    private  Integer bodyStyleId;
    private Integer driveTrainId;
    private Integer fuelTypeId;
    private Integer passengersCapacityId;
    private Integer transmissionId;

    public CarSpecification(CarCriteriaRequest carCriteriaRequest) {
        this.minPrice = carCriteriaRequest.getMinPrice();
        this.maxPrice = carCriteriaRequest.getMaxPrice();
        this.brandId = carCriteriaRequest.getBrandId();
        this.bodyStyleId = carCriteriaRequest.getBodyStyleId();
        this.driveTrainId = carCriteriaRequest.getDriveTrainId();
        this.fuelTypeId = carCriteriaRequest.getFuelTypeId();
        this.passengersCapacityId = carCriteriaRequest.getPassengersCapacityId();
        this.transmissionId = carCriteriaRequest.getTransmissionId();
    }

    @Override
    public Predicate toPredicate(Root<Car> r, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.and( findByPriceBetween(r, cb), findByBrand(r, cb), findByBodyStyle(r, cb), findByDriveTrain(r, cb), findByFuelType(r, cb), findByPassengersCapacity(r, cb));
    }
    private Predicate findByBrand(Root<Car> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (brandId != null) {
            Join<Car, Brand> brand = r.join("brand");
            predicate = cb.equal(brand.get("id"), brandId);
        } else {
            predicate = cb.conjunction();
        }
        return predicate;
    }

    private Predicate findByBodyStyle(Root<Car> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (bodyStyleId != null) {
            Join<Car, BodyStyle> bodyStyle = r.join("bodyStyle");
            predicate = cb.equal(bodyStyle.get("id"), bodyStyleId);
        } else {
            predicate = cb.conjunction();
        }
        return predicate;
    }

    private Predicate findByDriveTrain(Root<Car> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (driveTrainId != null) {
            Join<Car, DriveTrain> driveTrain = r.join("driveTrain");
            predicate = cb.equal(driveTrain.get("id"), driveTrainId);
        } else {
            predicate = cb.conjunction();
        }
        return predicate;
    }

    private Predicate findByFuelType(Root<Car> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (fuelTypeId != null) {
            Join<Car, FuelType> fuelType = r.join("fuelType");
            predicate = cb.equal(fuelType.get("id"), fuelTypeId);
        } else {
            predicate = cb.conjunction();
        }
        return predicate;
    }

    private Predicate findByPassengersCapacity(Root<Car> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (passengersCapacityId != null) {
            Join<Car, PassengersCapacity> passengersCapacity = r.join("passengersCapacity");
            predicate = cb.equal(passengersCapacity.get("id"), passengersCapacityId);
        } else {
            predicate = cb.conjunction();
        }
        return predicate;
    }

    private Predicate findByTransmission(Root<Car> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (transmissionId != null) {
            Join<Car, Transmission> transmission = r.join("transmission");
            predicate = cb.equal(transmission.get("id"), transmissionId);
        } else {
            predicate = cb.conjunction();
        }
        return predicate;
    }

    private Predicate findByPriceBetween(Root<Car> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (minPrice != null && maxPrice != null) {
            predicate = cb.between(r.get("price"), minPrice, maxPrice);
        } else if (minPrice != null) {
            predicate = cb.greaterThan(r.get("price"), minPrice);
        } else if (maxPrice != null) {
            predicate = cb.lessThan(r.get("price"), maxPrice);
        } else {
            predicate = cb.conjunction();
        }
        return predicate;
    }
}
