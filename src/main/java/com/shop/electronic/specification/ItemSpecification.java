package com.shop.electronic.specification;

import com.shop.electronic.dto.ItemCriteriaRequest;
import com.shop.electronic.entities.Category;
import com.shop.electronic.entities.Item;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class ItemSpecification implements Specification<Item> {
    private Float minPrice;
    private Float maxPrice;
    private Integer categoryId;

    public ItemSpecification(ItemCriteriaRequest itemCriteriaRequest) {
        this.minPrice = itemCriteriaRequest.getMinPrice();
        this.maxPrice = itemCriteriaRequest.getMaxPrice();
        this.categoryId = itemCriteriaRequest.getCategoryId();
    }

    @Override
    public Predicate toPredicate(Root<Item> r, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.and( findByPriceBetween(r, cb), findByCategory(r, cb));
    }
    private Predicate findByCategory(Root<Item> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (categoryId != null) {
            Join<Item, Category> category = r.join("category");
            predicate = cb.equal(category.get("id"), categoryId);
        } else {
            predicate = cb.conjunction();
        }
        return predicate;
    }

    private Predicate findByPriceBetween(Root<Item> r, CriteriaBuilder cb) {
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
