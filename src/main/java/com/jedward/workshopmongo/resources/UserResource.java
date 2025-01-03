package com.jedward.workshopmongo.resources;

import com.jedward.workshopmongo.domain.User;
import com.jedward.workshopmongo.resources.dto.UserDTO;
import com.jedward.workshopmongo.services.UserService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
        User user = userService.fromDTO(userDTO);
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
