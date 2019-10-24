package com.shop.electronic.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.electronic.dto.*;
import com.shop.electronic.entities.*;
import com.shop.electronic.exceptions.ItemNotFoundException;
import com.shop.electronic.repositories.ItemRepository;
import com.shop.electronic.specification.ItemSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    private CategoryService categoryService;

    private AttributeService attributeService;

    private  PictureService pictureService;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, CategoryService categoryService, AttributeService attributeService, PictureService pictureService) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
        this.attributeService = attributeService;
        this.pictureService = pictureService;
    }

    @Override
    public PaginationResponse<Item> getAll(ItemCriteriaRequest itemCriteriaRequest) {
        Page<Item> page = itemRepository.findAll(new ItemSpecification(itemCriteriaRequest), itemCriteriaRequest.toPageable());
        return new PaginationResponse<>(
                page.getTotalPages(),
                page.getTotalElements(),
                page.get().collect(Collectors.toList())
        );
    }

    @Override
    public Item save(ItemDTO itemDTO,  List<MultipartFile> files) throws IOException {
        List<String> paths = files
                .stream()
                .map((picture)->pictureService.save(picture))
                .collect(Collectors.toList());

        return itemRepository.save(convertDTO(itemDTO, paths));
    }

    @Override
    public void delete(Integer id) {
        itemRepository.delete(getById(id));
    }

    @Override
    public Item getById(Integer id) {
        return itemRepository.findById(id).orElseThrow(()->new ItemNotFoundException(id));
    }

    @Override
    public Item update(ItemDTO itemDTO, Integer id, List<MultipartFile> files) throws IOException {

        List<String> paths = files
                .stream()
                .map((picture)->pictureService.save(picture))
                .collect(Collectors.toList());

        Item oldItem = getById(id);

        Item updatedItem = convertDTO(itemDTO, paths);
        updatedItem.setId(oldItem.getId());

        return itemRepository.save(updatedItem);
    }

    private Item convertDTO(ItemDTO itemDTO, List<String> paths) throws IOException {
        System.out.println(itemDTO);
        Category category = categoryService.getById(itemDTO.getCategoryId());

        ObjectMapper objectMapper = new ObjectMapper();
        List<LinkedHashMap<String,String>> itemAttributeDTOs = objectMapper.readValue(itemDTO.getItemAttributes(), ArrayList.class);

        Map<Integer, String> map = Optional
                .ofNullable(itemAttributeDTOs)
                .orElse(new ArrayList<>())
                .stream()
                .map((itemAttributeDTO)->objectMapper.convertValue(itemAttributeDTO, ItemAttributeDTO.class))
                .collect(Collectors.toMap(ItemAttributeDTO::getAttributeId, ItemAttributeDTO::getValue));

        List<ItemAttribute> itemAttributes = attributeService
                .getAllByIds(map.keySet())
                .stream()
                .map((attribute)->{
                    ItemAttribute itemAttribute = new ItemAttribute();
                    itemAttribute.setAttribute(attribute);
                    itemAttribute.setValue(map.get(attribute.getId()));
                    return itemAttribute;
                })
                .collect(Collectors.toList());


        List<Picture> pictures = paths
                .stream()
                .map((path)->{
                    Picture picture = new Picture();
                    picture.setUrl(path);
                    return picture;
                })
                .collect(Collectors.toList());

        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setDescription(itemDTO.getDescription());
        item.setCategory(category);
        item.setPrice(itemDTO.getPrice());
        item.setAmount(itemDTO.getAmount());
        item.setItemAttributes(itemAttributes);
        item.setPictures(pictures);

        return item;
    }
}
