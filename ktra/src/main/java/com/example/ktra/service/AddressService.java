package com.example.ktra.service;

import com.example.ktra.entity.Address;

import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    public Address updateAddress(Long idD, Address address);
    public Address updateAddress(Long idD, Long id, Address address);
    public void deleteAddress(Long idD, Long id);
}
