package com.angelh0.stayhub_user.service.Impl;

import com.angelh0.stayhub_user.dto.GuestDTO;
import com.angelh0.stayhub_user.entity.GuestEntity;
import com.angelh0.stayhub_user.repository.GuestRepository;
import com.angelh0.stayhub_user.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public GuestDTO guestAccess() {

        GuestEntity newUser = new GuestEntity();
        newUser.setRole("GUEST");
        newUser.setStatus("TRUE");

        GuestEntity saveUser = guestRepository.save(newUser);

        GuestDTO guestDTO = new GuestDTO();
        guestDTO.setUuidGuest(saveUser.getUuidGuest());
        guestDTO.setRole(saveUser.getRole());
        guestDTO.setStatus(saveUser.getStatus());

        return guestDTO;
    }
}
