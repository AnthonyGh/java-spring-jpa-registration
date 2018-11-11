package fr.registration.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import fr.registration.model.User;
import fr.registration.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
