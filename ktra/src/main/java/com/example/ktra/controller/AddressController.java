package com.example.ktra.controller;

import com.example.ktra.entity.Address;
import com.example.ktra.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/addresses")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("/{darlingId}")
    public ResponseEntity<?> addAddress(@PathVariable("darlingId") Long id, @RequestBody Address address) {
        return ResponseEntity.ok(addressService.updateAddress(id, address));
    }

    @PatchMapping("/{darlingId}/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable("darlingId") Long idD, @PathVariable("id") Long id, @RequestBody Address address) {
        return ResponseEntity.ok(addressService.updateAddress(idD, id, address));
    }

    @DeleteMapping("/{darlingId}/{id}")
    public void deleteAddress(@PathVariable("darlingId") Long idD, @PathVariable("id") Long id) {
        addressService.deleteAddress(idD, id);
    }
}
