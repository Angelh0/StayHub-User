package com.angelh0.stayhub_user.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDTO {

    private UUID uuidUser;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private String status;
}
