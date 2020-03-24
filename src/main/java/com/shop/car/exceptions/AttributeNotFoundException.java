package com.shop.car.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AttributeNotFoundException extends RuntimeException
{
    public AttributeNotFoundException(Integer id) { super("Car with ID = " + id + "not found"); }
}
