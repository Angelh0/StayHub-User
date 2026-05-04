package com.angelh0.stayhub_user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@NamedQuery(name = "UserEntity.findByEmail", query = "select u from UserEntity u where u.email = :email")

@Getter
@Setter
@Entity
@Table(name = "USER_TABLE")
public class UserEntity {

    @Id
    private UUID uuidUser;

    @Column(name = "name")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private String status;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private OwnerEntity ownerUser;

    @PrePersist
    public void generatedUuid() {
        if (uuidUser == null) {
            uuidUser = UUID.randomUUID();
        }
    }
}