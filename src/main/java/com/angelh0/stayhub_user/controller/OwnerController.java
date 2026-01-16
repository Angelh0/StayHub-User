package com.angelh0.stayhub_user.controller;

import com.angelh0.stayhub_user.dto.OwnerDTO;
import com.angelh0.stayhub_user.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @PostMapping("/SignUpOwner")
    public ResponseEntity<OwnerDTO> signUpOwner(@RequestBody OwnerDTO ownerDTO) {
        return ResponseEntity.ok(ownerService.signUpOwner(ownerDTO));
    }
}
