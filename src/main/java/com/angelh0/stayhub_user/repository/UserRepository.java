package com.angelh0.stayhub_user.repository;

import com.angelh0.stayhub_user.dto.UserDTO;
import com.angelh0.stayhub_user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findByEmail(String email);
}
