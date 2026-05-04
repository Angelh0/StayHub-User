package com.angelh0.stayhub_user.controller;

import com.angelh0.stayhub_user.dto.OwnerDTO;
import com.angelh0.stayhub_user.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @PostMapping("/signUpOwner")
    public ResponseEntity<OwnerDTO> signUpOwner(@RequestBody OwnerDTO ownerDTO, Authentication authentication) {
        UUID uuidUser = UUID.fromString(authentication.getPrincipal().toString());
        return ResponseEntity.ok(ownerService.signUpOwner(ownerDTO, uuidUser));
    }
}
