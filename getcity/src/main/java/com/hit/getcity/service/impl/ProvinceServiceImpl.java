package com.hit.getcity.service.impl;

import java.util.List;

import com.hit.getcity.entity.Province;
import com.hit.getcity.exception.DuplicateException;
import com.hit.getcity.model.dto.ProvinceDTO;
import com.hit.getcity.model.mapper.Mapper;
import com.hit.getcity.repository.ProvinceRepository;
import com.hit.getcity.service.ProvinceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private static ProvinceRepository provinceRepository;

    @Override
    public Province getByCode(Long code) {
        return provinceRepository.findByCode(code);
    }

    @Override
    public Province creatProvince(ProvinceDTO provinceDTO) {
        Province province = provinceRepository.findByCode(provinceDTO.getCode());
        if(province != null) {
            throw new DuplicateException("Provinces axist");
        }
        return provinceRepository.save(Mapper.toProvince(provinceDTO));
    }

    @Override
    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    
}
