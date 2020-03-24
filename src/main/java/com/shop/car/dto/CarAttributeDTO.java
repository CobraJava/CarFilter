package com.shop.car.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarAttributeDTO {

    private Integer attributeId;

    @NotEmpty
    private String value;


}