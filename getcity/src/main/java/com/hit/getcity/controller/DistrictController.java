package com.hit.getcity.controller;

import com.hit.getcity.model.dto.DistrictDTO;
import com.hit.getcity.service.DistrictService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/districts")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @GetMapping
    public ResponseEntity<?> getAllDistricts() {
        return ResponseEntity.ok(districtService.getAllDistricts());
    }

    @PostMapping
    public ResponseEntity<?> createDistricts(@RequestBody DistrictDTO districtDTO) {
        return ResponseEntity.ok(districtService.createDistrict(districtDTO));
    }

    
}
