package com.wewin.fruitStore.user.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String lastname;
    private String password;
    private String phone;
    private String address;
    private String email;
}
