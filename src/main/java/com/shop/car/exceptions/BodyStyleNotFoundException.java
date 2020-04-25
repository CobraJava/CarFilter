package com.shop.car.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BodyStyleNotFoundException extends RuntimeException {
    public BodyStyleNotFoundException(Integer id) { super("BodyStyle with ID = " + id + "not found"); }
}
