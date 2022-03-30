package com.hit.getcity.repository;

import com.hit.getcity.entity.District;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District, Long> {
    
}
