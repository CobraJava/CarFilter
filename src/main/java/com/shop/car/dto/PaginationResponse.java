package com.shop.car.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PaginationResponse<T> {
    private Integer pages;
    private Long elements;
    private List<T> data;
}