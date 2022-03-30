package com.hit.getcity.service;

import java.util.List;

import com.hit.getcity.entity.District;
import com.hit.getcity.model.dto.DistrictDTO;

import org.springframework.stereotype.Service;

@Service
public interface DistrictService {
    List<District> getAllDistricts();
    District createDistrict(DistrictDTO districtDTO);
}
