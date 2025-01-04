package com.jedward.workshopmongo.domain;

import com.jedward.workshopmongo.resources.dto.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;
}
