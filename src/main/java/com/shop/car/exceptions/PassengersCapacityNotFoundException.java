package com.shop.car.exceptions;

import com.shop.car.entities.PassengersCapacity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PassengersCapacityNotFoundException extends RuntimeException {
    public PassengersCapacityNotFoundException(Integer id) { super("PassengersCapacity with ID = " + id + "not found"); }

}
