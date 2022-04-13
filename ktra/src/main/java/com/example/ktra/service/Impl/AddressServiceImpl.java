package com.example.ktra.service.Impl;

import com.example.ktra.entity.Address;
import com.example.ktra.entity.Darling;
import com.example.ktra.exception.DuplicateException;
import com.example.ktra.repository.AddressRepository;
import com.example.ktra.repository.DarlingRepository;
import com.example.ktra.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    DarlingRepository darlingRepository;

    @Override
    public Address updateAddress(Long idD, Address address) {
        Darling darling = darlingRepository.getById(idD);
        if(darling == null) {
            throw new DuplicateException("Id darling not axist");
        }
        address.setDarling(darling);
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long idD, Long id, Address address) {
        Address address2 = addressRepository.getById(id);
        if(address2 == null) {
            throw new DuplicateException("Id address not axist");
        }
        Darling darling = darlingRepository.getById(idD);
        if(darling == null) {
            throw new DuplicateException("Id darling not axist");
        }
        address2.setId(id);
        return addressRepository.save(address2);
    }

    @Override
    public void deleteAddress(Long idD, Long id) {
        Address address = addressRepository.getById(id);
        if(address == null) {
            throw new DuplicateException("Id address not axist");
        }
        Darling darling = darlingRepository.getById(idD);
        if(darling == null) {
            throw new DuplicateException("Id darling not axist");
        }

        addressRepository.deleteById(id);
    }
    
}
