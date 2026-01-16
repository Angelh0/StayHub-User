package com.angelh0.stayhub_user.converter;

import com.angelh0.stayhub_user.dto.OwnerDTO;
import com.angelh0.stayhub_user.entity.OwnerEntity;
import com.angelh0.stayhub_user.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class OwnerConverter {

    public OwnerEntity convertToEntity(OwnerDTO ownerDTO) {
        OwnerEntity ownerEntity = new OwnerEntity();

        ownerEntity.setCity(ownerDTO.getCity());
        ownerEntity.setPhoneNumber(ownerDTO.getPhoneNumber());

        return ownerEntity;
    }

    public OwnerDTO convertToDTO(OwnerEntity ownerEntity) {
        OwnerDTO ownerDTO = new OwnerDTO();

        ownerDTO.getUuidUser();
        ownerDTO.setCity(ownerEntity.getCity());
        ownerDTO.setPhoneNumber(ownerEntity.getPhoneNumber());

        return ownerDTO;
    }
}
