package com.angelh0.stayhub_user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "GUEST_TABLE")
public class GuestEntity {

    @Id
    private UUID uuidGuest;

    private String role;
    private String status;

    @PrePersist
    public void generatedUuid() {
        if (uuidGuest == null) {
            uuidGuest = UUID.randomUUID();
        }
    }
}
