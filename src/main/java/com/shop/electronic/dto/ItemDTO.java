package com.shop.electronic.dto;

import com.shop.electronic.entities.Category;
import com.shop.electronic.entities.ItemAttribute;
import com.shop.electronic.entities.Picture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {



    @NotEmpty
    private String name;


    private String description;

    @PositiveOrZero
    private Float price;

    @PositiveOrZero
    private Integer amount;


    private List<ItemAttributeDTO> itemAttributes;

    @NotEmpty
    private Integer categoryId;


}
