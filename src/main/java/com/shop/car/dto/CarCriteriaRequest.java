package com.shop.car.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarCriteriaRequest extends PaginationRequest {
    private Float minPrice;
    private Float maxPrice;
    private Integer categoryId;
}

