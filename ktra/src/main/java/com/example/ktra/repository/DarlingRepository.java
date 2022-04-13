package com.example.ktra.repository;

import java.util.List;

import com.example.ktra.entity.Darling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DarlingRepository extends JpaRepository<Darling, Long> {
    @Query(value = "select * from Darling where status!=3", nativeQuery = true)
    List<Darling> findCurrent();
    @Query(value = "select * from Darling where status!=?1", nativeQuery = true)
    List<Darling> findAllByStatus(Short status);
    @Query(value = "select * from Address where darling_id=?1", nativeQuery = true)
    List<Darling> getAddressById(Long id);
    @Query(value = "select * from Address where darling_id=?1 and name=?2", nativeQuery = true)
    List<Darling> getAddress(Long id, String q);
}
