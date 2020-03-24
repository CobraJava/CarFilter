package com.shop.car.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {




    private String name;


    private String description;

    private Float price;

    private Integer amount;


    private String carAttributes;

    private Integer categoryId;


}
