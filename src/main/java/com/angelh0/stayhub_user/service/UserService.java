package com.angelh0.stayhub_user.service;

import com.angelh0.stayhub_user.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    ResponseEntity<String> signUpUser(Map<String, String> requestMap);
    UserEntity getUser(Map<String, String> requestMap);
    boolean validateSingUp(Map<String, String> requestMap);
    String login(Map<String, String> requestMap);
}
