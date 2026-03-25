package com.angelh0.stayhub_user.controller;

import com.angelh0.stayhub_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp") // registro
    public ResponseEntity<String> signUser(@RequestBody Map<String, String> requestMap) {
        return userService.signUpUser(requestMap);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> requestMap) {
        return userService.login(requestMap);
    }
}
