package com.angelh0.stayhub_user.repository;

import com.angelh0.stayhub_user.entity.UserEntity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
