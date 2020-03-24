package com.shop.car.dto;


import com.shop.car.entities.Role;
import lombok.Data;

@Data
public class UserDataDTO {

    private String username;

    private String email;

    private String password;

    Role role;

}