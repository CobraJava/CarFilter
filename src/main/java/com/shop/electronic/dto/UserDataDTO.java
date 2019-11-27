package com.shop.electronic.dto;


import com.shop.electronic.entities.Role;
import lombok.Data;


import java.util.List;

@Data
public class UserDataDTO {

    private String username;

    private String email;

    private String password;

    Role role;

}