package com.shop.car.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TransmissionNotFoundException extends RuntimeException {
    public TransmissionNotFoundException(Integer id) { super("Transmission with ID = " + id + "not found"); }
}
