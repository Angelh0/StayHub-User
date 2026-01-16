package com.angelh0.stayhub_user.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "OWNER_TABLE")
public class OwnerEntity {

    @Id
    private UUID uuidUser;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_uuid")
    private UserEntity user;

    @Column(name = "city")
    private String city;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @PrePersist
    public void generatedUuid() {
        if (uuidUser == null) {
            uuidUser = UUID.randomUUID();
        }
    }
}
