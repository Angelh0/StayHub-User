package com.angelh0.stayhub_user.dto;

import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class UserDTO {

    private UUID uuidUser;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles;
    private String googleId;
    private boolean enabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
