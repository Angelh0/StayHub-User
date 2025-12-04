package com.angelh0.stayhub_user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "USER_TABLE")
public class UserEntity {

    @Id
    @GeneratedValue
    private UUID uuidUser;

    private String username;
    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)

    private Set<Role> roles;
    private String googleId;
    private boolean enabled;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    @PrePersist
    public void generatedUuid() {
        if (uuidUser == null) {
            uuidUser = UUID.randomUUID();
        }
    }
}