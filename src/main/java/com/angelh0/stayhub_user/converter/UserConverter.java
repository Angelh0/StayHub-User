package com.angelh0.stayhub_user.converter;

import com.angelh0.stayhub_user.dto.UserDTO;
import com.angelh0.stayhub_user.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertToEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUuidUser(userDTO.getUuidUser());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());

        return userEntity;
    }

    public UserDTO convertToDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUuidUser(userEntity.getUuidUser());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setFirstName(userEntity.getFirstName());
        userDTO.setLastName(userEntity.getLastName());

        return userDTO;
    }
}
