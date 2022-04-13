package com.example.ktra.service;

import java.util.List;

import com.example.ktra.entity.Darling;

import org.springframework.stereotype.Service;

@Service
public interface DarlingService {
    List<Darling> getAll();
    List<Darling> getCurrent();
    List<Darling> getByStatus(short status);
    Darling getById(long id);
    Darling saveDarling(Darling darling);
    Darling updateDarling(long id, Darling darling);
    void deleteById(long id);
    List<Darling> getAddress(long id);
    List<Darling> getAddress(long id, String q);
}
