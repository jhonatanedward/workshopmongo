package com.jedward.workshopmongo.resources.dto;

import com.jedward.workshopmongo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO{

    private String id;
    private String name;

    public AuthorDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
