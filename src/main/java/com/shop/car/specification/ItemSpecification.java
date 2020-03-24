package com.shop.car.specification;

import com.shop.car.dto.CarCriteriaRequest;
import com.shop.car.entities.Brand;
import com.shop.car.entities.Car;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class ItemSpecification implements Specification<Car> {
    private Float minPrice;
    private Float maxPrice;
    private Integer categoryId;

    public ItemSpecification(CarCriteriaRequest carCriteriaRequest) {
        this.minPrice = carCriteriaRequest.getMinPrice();
        this.maxPrice = carCriteriaRequest.getMaxPrice();
        this.categoryId = carCriteriaRequest.getCategoryId();
    }

    @Override
    public Predicate toPredicate(Root<Car> r, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.and( findByPriceBetween(r, cb), findByCategory(r, cb));
    }
    private Predicate findByCategory(Root<Car> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (categoryId != null) {
            Join<Car, Brand> category = r.join("brand");
            predicate = cb.equal(category.get("id"), categoryId);
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
