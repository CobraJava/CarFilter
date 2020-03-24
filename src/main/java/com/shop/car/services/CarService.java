package com.shop.car.services;

import com.shop.car.dto.CarCriteriaRequest;
import com.shop.car.dto.CarDTO;
import com.shop.car.dto.PaginationResponse;
import com.shop.car.entities.Car;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

public interface CarService {

    PaginationResponse<Car> getAll(CarCriteriaRequest carCriteriaRequest);

    Car save(CarDTO carDTO, List<MultipartFile> files) throws IOException;

    void delete(Integer Id);

    Car getById(Integer Id);

    Car update(CarDTO carDTO, Integer id, List<MultipartFile> files) throws IOException;
}