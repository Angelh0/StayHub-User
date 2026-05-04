package com.angelh0.stayhub_user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class GuestDTO {

    private UUID uuidGuest;
    private String role;
    private String status;
    private String token;
}
