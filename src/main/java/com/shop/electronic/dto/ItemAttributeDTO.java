package com.shop.electronic.dto;

import com.shop.electronic.entities.Attribute;
import com.shop.electronic.entities.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemAttributeDTO {

    private Integer attributeId;

    @NotEmpty
    private String value;


}