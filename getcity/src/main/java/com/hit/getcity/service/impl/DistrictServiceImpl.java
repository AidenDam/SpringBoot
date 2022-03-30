package com.hit.getcity.service.impl;

import java.util.List;

import com.hit.getcity.entity.District;
import com.hit.getcity.entity.Province;
import com.hit.getcity.exception.NotFoundException;
import com.hit.getcity.model.dto.DistrictDTO;
import com.hit.getcity.model.mapper.Mapper;
import com.hit.getcity.repository.DistrictRepository;
import com.hit.getcity.service.DistrictService;
import com.hit.getcity.service.ProvinceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private static DistrictRepository districtRepository;
    
    private static ProvinceService provinceService;

    @Override
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }

    @Override
    public District createDistrict(DistrictDTO districtDTO) {
        Province province = provinceService.getByCode(districtDTO.getParent_code());
        if (province == null) {
            throw new NotFoundException("Provinces's parent code not axist");
        }
        return districtRepository.save(Mapper.toDistrict(districtDTO, province));
    }
}
