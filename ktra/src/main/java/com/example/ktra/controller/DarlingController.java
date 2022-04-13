package com.example.ktra.controller;

import com.example.ktra.entity.Darling;
import com.example.ktra.service.DarlingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/darlings")
public class DarlingController {
    @Autowired
    DarlingService darlingService;

    @GetMapping("/current")
    public ResponseEntity<?> getCurrent() {
        return ResponseEntity.ok(darlingService.getCurrent());
    }

    @GetMapping
    public ResponseEntity<?> getByStatus(@RequestParam(name = "status") Short status) {
        if(status == null) {
            return ResponseEntity.ok(darlingService.getAll());
        }
        return ResponseEntity.ok(darlingService.getByStatus(status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id) {
        return ResponseEntity.ok(darlingService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> createDarling(@RequestBody Darling darling) {
        return ResponseEntity.ok(darlingService.saveDarling(darling));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateDarling(@PathVariable("id") long id, @RequestBody Darling darling) {
        return ResponseEntity.ok(darlingService.updateDarling(id, darling));
    }

    @DeleteMapping
    public void deleteById(@RequestParam long id) {
        darlingService.deleteById(id);
    }

    @GetMapping("/{id}/add/resses")
    public ResponseEntity<?> getAddress(@PathVariable("id") Long id, @RequestParam("q") String q) {
        if(q == null) {
            return ResponseEntity.ok(darlingService.getAddress(id));
        }
        return ResponseEntity.ok(darlingService.getAddress(id));
    }
}
