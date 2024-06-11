package com.example.ecommerce.laptop_ecommerce_platform.service;

import com.example.ecommerce.laptop_ecommerce_platform.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);

    UserDto updateUser(Long userId, UserDto updatedUser);

    void deleteUser(Long userId);
}
