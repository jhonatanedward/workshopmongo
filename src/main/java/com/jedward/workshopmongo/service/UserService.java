package com.jedward.workshopmongo.service;

import com.jedward.workshopmongo.domain.User;
import com.jedward.workshopmongo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> buscaTodosUsuarios() {
        return userRepository.findAll();
    }
}
