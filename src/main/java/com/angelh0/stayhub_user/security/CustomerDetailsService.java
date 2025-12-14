package com.angelh0.stayhub_user.security;

import com.angelh0.stayhub_user.entity.UserEntity;
import com.angelh0.stayhub_user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
@Slf4j
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private UserEntity userEntity;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Dentro de loadUserByUsername {}", username);
        userEntity = userRepository.findByEmail(username);

        if (!Objects.isNull(userEntity)) {
            return new User(userEntity.getEmail(), userEntity.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    public UserEntity getUserDetail() {
        return userEntity;
    }
}
