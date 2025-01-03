package com.jedward.workshopmongo.services;

import com.jedward.workshopmongo.domain.User;
import com.jedward.workshopmongo.repositories.UserRepository;
import com.jedward.workshopmongo.services.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserById(String id) {
        Optional<User> retorno = userRepository.findById(id);
        return retorno.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }
}
