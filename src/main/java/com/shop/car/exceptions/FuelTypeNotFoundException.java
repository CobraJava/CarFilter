package com.shop.car.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FuelTypeNotFoundException extends RuntimeException {
    public  FuelTypeNotFoundException(Integer id) { super("FuelType with ID = " + id + "not found"); }
}
