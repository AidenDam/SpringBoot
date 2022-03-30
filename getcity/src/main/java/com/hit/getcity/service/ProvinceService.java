package com.hit.getcity.service;

import java.util.List;

import com.hit.getcity.entity.Province;
import com.hit.getcity.model.dto.ProvinceDTO;

import org.springframework.stereotype.Service;

@Service
public interface ProvinceService {
    List<Province> getAllProvinces();
    Province getByCode(Long code);
    Province creatProvince(ProvinceDTO provinceDTO);
}
