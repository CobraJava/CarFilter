package com.shop.car.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCriteriaRequest extends PaginationRequest {
    private Float minPrice;
    private Float maxPrice;
    private Integer categoryId;
}

