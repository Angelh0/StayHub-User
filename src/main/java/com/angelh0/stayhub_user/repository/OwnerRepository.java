package com.angelh0.stayhub_user.repository;

import com.angelh0.stayhub_user.entity.OwnerEntity;
import com.angelh0.stayhub_user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OwnerRepository extends JpaRepository<OwnerEntity, UUID> {

    Optional<OwnerEntity> findByUser(UserEntity user);

    Optional<OwnerEntity> findByUuidUserAndUuidUser(UUID user, UUID uuidUser);
}