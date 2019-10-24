package com.shop.electronic.controllers;

import com.shop.electronic.dto.ItemCriteriaRequest;
import com.shop.electronic.dto.ItemDTO;
import com.shop.electronic.dto.PaginationRequest;
import com.shop.electronic.dto.PaginationResponse;
import com.shop.electronic.entities.Item;
import com.shop.electronic.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping
    public Item create(ItemDTO itemDTO, @RequestParam("files") List<MultipartFile> files) throws IOException, IllegalAccessException {
        return itemService.save(itemDTO, files);
    }

    @GetMapping
    public PaginationResponse<Item> findAll(ItemCriteriaRequest itemCriteriaRequest){
        return itemService.getAll(itemCriteriaRequest);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable Integer id, ItemDTO itemDTO, @RequestParam("files") List<MultipartFile> files ){
        return itemService.update(itemDTO, id, files);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        itemService.delete(id);
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable Integer id){
        return  itemService.getById(id);
    }
}
