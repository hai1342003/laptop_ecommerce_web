package com.example.ecommerce.laptop_ecommerce_platform.service.impl;

import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.UserDto;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Laptop;
import com.example.ecommerce.laptop_ecommerce_platform.entity.User;
import com.example.ecommerce.laptop_ecommerce_platform.exception.ResourceNotFoundException;
import com.example.ecommerce.laptop_ecommerce_platform.mapper.LaptopMapper;
import com.example.ecommerce.laptop_ecommerce_platform.mapper.UserMapper;
import com.example.ecommerce.laptop_ecommerce_platform.repository.LaptopRepository;
import com.example.ecommerce.laptop_ecommerce_platform.repository.UserRepository;
import com.example.ecommerce.laptop_ecommerce_platform.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User is not exists with given id: " + userId));

        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User is not exists with given id" + userId)
        );

        user.setUsername(updatedUser.getName());
        user.setRole(updatedUser.getRole());


        User updatedUserObj = userRepository.save(user);

        return UserMapper.mapToUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User is not exists with given id" + userId)
        );

        userRepository.deleteById(userId);
    }
}
