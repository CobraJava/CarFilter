package com.shop.electronic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {




    private String name;


    private String description;

    private Float price;

    private Integer amount;


    private String itemAttributes;

    private Integer categoryId;


}
