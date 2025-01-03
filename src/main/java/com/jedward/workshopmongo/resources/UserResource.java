package com.jedward.workshopmongo.resources;

import com.jedward.workshopmongo.domain.User;
import com.jedward.workshopmongo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> buscaTodos() {
        var listaDeUsuarios = userService.findAll();
        return ResponseEntity.ok().body(listaDeUsuarios);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> buscaPorId(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.findUserById(id));
    }

}
