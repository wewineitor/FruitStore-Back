package com.wewin.fruitStore.user.service;

import com.wewin.fruitStore.user.dto.UserDTO;

public interface UserService {
    void register(UserDTO userDTO);
    UserDTO login(String email, String password);
    void updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
}