package com.hit.demo.controllers;

import com.hit.demo.models.Store;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class UserController {
    @GetMapping("/users")
    @ResponseBody
    public ResponseEntity<?> getListUsers() {
        return ResponseEntity.ok(Store.users);
    }
}
