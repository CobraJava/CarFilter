package com.shop.car.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.car.dto.*;
import com.shop.car.entities.*;
import com.shop.car.exceptions.CarNotFoundException;
import com.shop.car.repositories.CarRepository;
import com.shop.car.specification.ItemSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    private BrandService brandService;

    private AttributeService attributeService;

    private  PictureService pictureService;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, BrandService brandService, AttributeService attributeService, PictureService pictureService) {
        this.carRepository = carRepository;
        this.brandService = brandService;
        this.attributeService = attributeService;
        this.pictureService = pictureService;
    }

    @Override
    public PaginationResponse<Car> getAll(CarCriteriaRequest carCriteriaRequest) {
        Page<Car> page = carRepository.findAll(new ItemSpecification(carCriteriaRequest), carCriteriaRequest.toPageable());
        return new PaginationResponse<>(
                page.getTotalPages(),
                page.getTotalElements(),
                page.get().collect(Collectors.toList())
        );
    }

    @Override
    public Car save(CarDTO carDTO, List<MultipartFile> files) throws IOException {
        List<String> paths = files
                .stream()
                .map((picture)->pictureService.save(picture))
                .collect(Collectors.toList());

        return carRepository.save(convertDTO(carDTO, paths));
    }

    @Override
    public void delete(Integer id) {
        carRepository.delete(getById(id));
    }

    @Override
    public Car getById(Integer id) {
        return carRepository.findById(id).orElseThrow(()->new CarNotFoundException(id));
    }

    @Override
    public Car update(CarDTO carDTO, Integer id, List<MultipartFile> files) throws IOException {


        List<String> paths = files
                .stream()
                .map((picture)->pictureService.save(picture))
                .collect(Collectors.toList());

        Car oldCar = getById(id);

        Car updatedCar = convertDTO(carDTO, paths);
        updatedCar.setId(oldCar.getId());

        return carRepository.save(updatedCar);
    }

    private Car convertDTO(CarDTO carDTO, List<String> paths) throws IOException {
        System.out.println(carDTO);
        Brand brand = brandService.getById(carDTO.getCategoryId());

        ObjectMapper objectMapper = new ObjectMapper();
        List<LinkedHashMap<String,String>> carAttributeDTOs = objectMapper.readValue(carDTO.getCarAttributes(), ArrayList.class);

        Map<Integer, String> map = Optional
                .ofNullable(carAttributeDTOs)
                .orElse(new ArrayList<>())
                .stream()
                .map((carAttributeDTO)->objectMapper.convertValue(carAttributeDTO, CarAttributeDTO.class))
                .collect(Collectors.toMap(CarAttributeDTO::getAttributeId, CarAttributeDTO::getValue));

        List<CarAttribute> carAttributes = attributeService
                .getAllByIds(map.keySet())
                .stream()
                .map((attribute)->{
                    CarAttribute carAttribute = new CarAttribute();
                    carAttribute.setAttribute(attribute);
                    carAttribute.setValue(map.get(attribute.getId()));
                    return carAttribute;
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

        Car car = new Car();
        car.setName(carDTO.getName());
        car.setDescription(carDTO.getDescription());
        car.setBrand(brand);
        car.setPrice(carDTO.getPrice());
        car.setAmount(carDTO.getAmount());
        car.setCarAttributes(carAttributes);
        car.setPictures(pictures);

        return car;
    }
}
