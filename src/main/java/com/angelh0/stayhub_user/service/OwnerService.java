package com.angelh0.stayhub_user.service;

import com.angelh0.stayhub_user.dto.OwnerDTO;
import com.angelh0.stayhub_user.entity.OwnerEntity;
import com.angelh0.stayhub_user.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface OwnerService {

    OwnerDTO signUpOwner(OwnerDTO ownerDTO);
    OwnerEntity getUser(OwnerDTO ownerDTO, UserEntity userEntity);
    boolean validateSingUp(OwnerDTO ownerDTO);
}
