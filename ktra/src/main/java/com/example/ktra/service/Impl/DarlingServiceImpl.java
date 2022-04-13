package com.example.ktra.service.Impl;

import java.util.List;

import com.example.ktra.entity.Darling;
import com.example.ktra.exception.NotFoundException;
import com.example.ktra.repository.DarlingRepository;
import com.example.ktra.service.DarlingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DarlingServiceImpl implements DarlingService {
    @Autowired
    DarlingRepository darlingRepository;

    @Override
    public List<Darling> getAll() {
        return darlingRepository.findAll();
    }

    @Override
    public List<Darling> getCurrent() {
        return darlingRepository.findCurrent();
    }

    @Override
    public List<Darling> getByStatus(short status) {
        return darlingRepository.findAllByStatus(status);
    }

    @Override
    public Darling getById(long id) {
        return darlingRepository.getById(id);
    }

    @Override
    public Darling saveDarling(Darling darling) {
        return darlingRepository.save(darling);
    }

    @Override
    public Darling updateDarling(long id, Darling darling) {
        if(darlingRepository.findById(id) == null) {
            throw new NotFoundException("don't axits");
        }
        return darlingRepository.save(darling);
    }

    @Override
    public void deleteById(long id) {
        darlingRepository.deleteById(id);
    }

	@Override
	public List<Darling> getAddress(long id) {
		return darlingRepository.getAddressById(id);
	}

    @Override
    public List<Darling> getAddress(long id, String q) {
        return darlingRepository.getAddress(id, q);
    }

}
