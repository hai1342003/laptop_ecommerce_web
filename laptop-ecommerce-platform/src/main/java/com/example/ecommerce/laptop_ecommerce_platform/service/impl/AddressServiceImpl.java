package com.example.ecommerce.laptop_ecommerce_platform.service.impl;

import com.example.ecommerce.laptop_ecommerce_platform.dto.AddressDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.UserDto;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Address;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Laptop;
import com.example.ecommerce.laptop_ecommerce_platform.entity.User;
import com.example.ecommerce.laptop_ecommerce_platform.exception.ResourceNotFoundException;
import com.example.ecommerce.laptop_ecommerce_platform.mapper.AddressMapper;
import com.example.ecommerce.laptop_ecommerce_platform.mapper.LaptopMapper;
import com.example.ecommerce.laptop_ecommerce_platform.repository.AddressRepository;
import com.example.ecommerce.laptop_ecommerce_platform.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;



    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        Address address = AddressMapper.mapToAddress(addressDto);
        Address savedAddress = addressRepository.save(address);
        return AddressMapper.mapToAddressDto(savedAddress);
    }

    @Override
    public AddressDto getAddressById(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Address is not exists with given id: " + addressId));

        return AddressMapper.mapToAddressDto(address);
    }

    @Override
    public AddressDto getAddressByUserId(Long userId) {
        Address address = addressRepository.findByUserId(userId);

        return AddressMapper.mapToAddressDto(address);
    }

    @Override
    public AddressDto updateAddress(Long addressId, AddressDto updatedAddress) {

        Address address = addressRepository.findById(addressId).orElseThrow(
                () -> new ResourceNotFoundException("Address is not exists with given id" + addressId)
        );

        address.setUser(
                new User(
                        updatedAddress.getUser().getId(),
                        updatedAddress.getUser().getName(),
                        updatedAddress.getUser().getRole()
                )
        );
        address.setStreet(updatedAddress.getStreet());
        address.setCity(updatedAddress.getCity());
        address.setState(updatedAddress.getState());

        Address updatedAddressObj = addressRepository.save(address);

        return AddressMapper.mapToAddressDto(updatedAddressObj);
    }

    @Override
    public void deleteAddress(Long addressId) {
        Address address = addressRepository.findById(addressId).orElseThrow(
                () -> new ResourceNotFoundException("Address is not exists with given id" + addressId)
        );

        addressRepository.deleteById(addressId);
    }

}
