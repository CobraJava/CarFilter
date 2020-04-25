package com.shop.car.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DriveTrainNotFoundException extends RuntimeException {
    public  DriveTrainNotFoundException(Integer id) { super("DriveTrain with ID = " + id + "not found"); }
}
