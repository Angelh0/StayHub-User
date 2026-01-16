package com.angelh0.stayhub_user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OwnerDTO {

    private UUID uuidUser;
    private String city;
    private String phoneNumber;
    private String role;
    private String email;
    private String status;
}
