package com.angelh0.stayhub_user.service.Impl;

import com.angelh0.stayhub_user.converter.OwnerConverter;
import com.angelh0.stayhub_user.dto.OwnerDTO;
import com.angelh0.stayhub_user.entity.OwnerEntity;
import com.angelh0.stayhub_user.entity.UserEntity;
import com.angelh0.stayhub_user.exception.error.NotFoundException;
import com.angelh0.stayhub_user.repository.OwnerRepository;
import com.angelh0.stayhub_user.repository.UserRepository;
import com.angelh0.stayhub_user.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
import java.util.UUID;


@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OwnerConverter ownerConverter;

    @Transactional
    @Override
    public OwnerDTO signUpOwner(OwnerDTO ownerDTO, UUID uuidUser) {
        Optional<UserEntity> userOpt = userRepository.findByUuidUserAndUuidUser(ownerDTO.getUuidUser(), uuidUser);
        if (userOpt.isEmpty()) {
            throw new NotFoundException("No se ha encontrado ningún usuario");
        }

        UserEntity userEntity = userOpt.get();

        Optional<OwnerEntity> ownerOpt = ownerRepository.findByUser(userEntity);
        if (ownerOpt.isPresent()) {
            OwnerEntity existingOwner = ownerOpt.get();

            OwnerDTO existingDTO = new OwnerDTO();
            existingDTO.setUuidUser(userEntity.getUuidUser());
            existingDTO.setRole(userEntity.getRole());
            existingDTO.setStatus(userEntity.getStatus());
            existingDTO.setCity(existingOwner.getCity());
            existingDTO.setPhoneNumber(existingOwner.getPhoneNumber());
            return existingDTO;
        }

        userEntity.setRole("OWNER");
        userEntity.setStatus("TRUE");
        userRepository.save(userEntity);

        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setUser(userEntity);
        userEntity.setOwnerUser(ownerEntity);
        ownerEntity.setCity(ownerDTO.getCity());
        ownerEntity.setPhoneNumber(ownerDTO.getPhoneNumber());
        ownerRepository.save(ownerEntity);

        OwnerDTO responseDTO = new OwnerDTO();
        responseDTO.setUuidUser(userEntity.getUuidUser());
        responseDTO.setRole(userEntity.getRole());
        responseDTO.setStatus(userEntity.getStatus());
        responseDTO.setCity(ownerEntity.getCity());
        responseDTO.setPhoneNumber(ownerEntity.getPhoneNumber());

        return responseDTO;
    }


    @Override
    public OwnerEntity getUser(OwnerDTO ownerDTO, UserEntity userEntity) {
        return ownerConverter.convertToEntity(ownerDTO);
    }

    @Override
    public boolean validateSingUp(OwnerDTO ownerDTO) {

        Optional<UserEntity> user = userRepository.findById(ownerDTO.getUuidUser());

        if (user.isEmpty()) {
            return false;
        }

        Optional<OwnerEntity> owner = ownerRepository.findByUser(user.get());
        if (owner.isEmpty() && !ownerDTO.getPhoneNumber().isEmpty() && !ownerDTO.getCity().isEmpty()) {
            return true;
        }
        return false;
    }
}