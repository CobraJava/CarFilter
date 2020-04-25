package com.shop.car.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarCriteriaRequest extends PaginationRequest {
    private Float minPrice;
    private Float maxPrice;
    private Integer brandId;
    private Integer bodyStyleId;
    private Integer driveTrainId;
    private Integer fuelTypeId;
    private Integer passengersCapacityId;
    private Integer transmissionId;

}

