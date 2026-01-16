package com.angelh0.stayhub_user.service.Impl;

import com.angelh0.stayhub_user.entity.UserEntity;
import com.angelh0.stayhub_user.exception.error.InvalidValues;
import com.angelh0.stayhub_user.repository.UserRepository;
import com.angelh0.stayhub_user.security.CustomerDetailsService;
import com.angelh0.stayhub_user.security.jwt.JwtUtil;
import com.angelh0.stayhub_user.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerDetailsService customerDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private JwtUtil jwtUtil;

    @Override  // registrar usuario
    public ResponseEntity<String> signUpUser(Map<String, String> requestMap) {

        try {
            if (validateSingUp(requestMap)) {
                UserEntity userEntity = userRepository.findByEmail(requestMap.get("email"));

                if (Objects.isNull(userEntity)) {
                    UserEntity user = getUser(requestMap);
                    user.setRole("USER");
                    user.setStatus("true");
                    userRepository.save(getUser(requestMap));
                    return new ResponseEntity<>("Usuario registrado con éxito", HttpStatus.CREATED);
                }
                else {
                    return new ResponseEntity<>("El usuario con ese email ya existe", HttpStatus.BAD_REQUEST);
                }
            } else {
                throw new InvalidValues("Datos introducidos invalidos");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error interno en el registro", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override  //obtener usuarios
    public UserEntity getUser(Map<String, String> requestMap) {
        UserEntity user = new UserEntity();
        user.setFirstName(requestMap.get("firstName"));
        user.setLastName(requestMap.get("lastName"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(passwordEncoder.encode(requestMap.get("password")));
        user.setRole("user");
        user.setStatus("true");

        return user;
    }

    @Override // validar registros de usuarios
    public boolean validateSingUp(Map<String, String> requestMap) {

        if (requestMap.containsKey("firstName") && requestMap.containsKey("lastName") &&
                requestMap.containsKey("email") && requestMap.containsKey("password")) {
            return true;
        }

        return false;
    }

    @Override
    public String login(Map<String, String> requestMap) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            requestMap.get("email"),
                            requestMap.get("password")
                    )
            );

            if (authentication.isAuthenticated()) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                UserEntity userEntity = userRepository.findByEmail(userDetails.getUsername());

                if (!userEntity.getStatus().equalsIgnoreCase("true")) {
                    return "{\"mensaje\": \"Usuario no activado\"}";
                }

                String token = jwtUtil.generateToken(
                        userEntity.getEmail(),
                        userEntity.getRole(),
                        userEntity.getUuidUser(),
                        String.valueOf(userEntity.getUuidUser())
                );

                return "{\"token\": \"" + token + "\"}";
            }

        } catch (Exception e) {
            log.error("Error en login: {}", e.getMessage());
        }

        return "{\"mensaje\": \"Credenciales incorrectas\"}";
    }

}
