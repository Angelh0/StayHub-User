package com.angelh0.stayhub_user.controller;

import com.angelh0.stayhub_user.dto.GuestDTO;
import com.angelh0.stayhub_user.security.jwt.JwtUtil;
import com.angelh0.stayhub_user.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GuestController {

    @Autowired
    private GuestService guestService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/guestAccess")
    public ResponseEntity<GuestDTO> guestAccess() {
        GuestDTO guestSave = guestService.guestAccess();

        String generatedToken = jwtUtil.generateGuestToken(
                guestSave.getUuidGuest().toString(),
                guestSave.getRole()
        );

        guestSave.setToken(generatedToken);

        return ResponseEntity.ok(guestSave);
    }
}
