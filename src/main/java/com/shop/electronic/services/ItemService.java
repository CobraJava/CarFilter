package com.shop.electronic.services;

import com.shop.electronic.dto.ItemCriteriaRequest;
import com.shop.electronic.dto.ItemDTO;
import com.shop.electronic.dto.PaginationResponse;
import com.shop.electronic.entities.Item;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

public interface ItemService {

    PaginationResponse<Item> getAll(ItemCriteriaRequest itemCriteriaRequest);

    Item save(ItemDTO itemDTO,  List<MultipartFile> files) throws IOException;

    void delete(Integer Id);

    Item getById(Integer Id);

    Item update(ItemDTO itemDTO, Integer id, List<MultipartFile> files) throws IOException;
}