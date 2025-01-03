package com.jedward.workshopmongo.services;

import com.jedward.workshopmongo.domain.User;
import com.jedward.workshopmongo.repositories.UserRepository;
import com.jedward.workshopmongo.resources.dto.UserDTO;
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

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }

    public void delete(String id) {
        findUserById(id);
        userRepository.deleteById(id);
    }

    public User update(User user) {
        User newObj = findUserById(user.getId());
        updateData(newObj, user);
        return userRepository.save(newObj);
    }

    public void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }
}
