package com.angelh0.stayhub_user.repository;

import com.angelh0.stayhub_user.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GuestRepository extends JpaRepository<GuestEntity, UUID> {
}
