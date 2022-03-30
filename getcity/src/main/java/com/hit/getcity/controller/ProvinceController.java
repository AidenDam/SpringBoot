package com.hit.getcity.controller;

import com.hit.getcity.model.dto.ProvinceDTO;
import com.hit.getcity.service.ProvinceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @GetMapping
    public ResponseEntity<?> getAllProvince() {
        return ResponseEntity.ok(provinceService.getAllProvinces());
    }

    @PostMapping
    public ResponseEntity<?> createProvince(@RequestBody ProvinceDTO provinceDTO) {
        return ResponseEntity.ok(provinceService.creatProvince(provinceDTO));
    }
}
