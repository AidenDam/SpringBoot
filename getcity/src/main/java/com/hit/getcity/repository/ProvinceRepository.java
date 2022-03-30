package com.hit.getcity.repository;

import com.hit.getcity.entity.Province;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Province findByCode(Long code);
}
