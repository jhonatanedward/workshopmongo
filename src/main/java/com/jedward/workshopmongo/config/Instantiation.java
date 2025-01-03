package com.jedward.workshopmongo.config;

import com.jedward.workshopmongo.domain.Post;
import com.jedward.workshopmongo.domain.User;
import com.jedward.workshopmongo.repositories.PostRepository;
import com.jedward.workshopmongo.repositories.UserRepository;
import com.jedward.workshopmongo.resources.dto.AuthorDTO;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
@AllArgsConstructor
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;

    private final PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user = new User(null, "Jhonatan Edward", "jhonatan@gmail.com", new ArrayList<>());
        User user1 = new User(null, "Uncle Bob", "uncle@gmail.com", new ArrayList<>());

        userRepository.saveAll(Arrays.asList(user,user1));

        Post post = new Post(null, sdf.parse("03/01/2025"), "Feliz Ano Novo", "Muita saude e paz a todos.", new AuthorDTO(user));
        Post post1 = new Post(null, sdf.parse("03/01/2025"), "Libertadores do SPFC", "Esse ano o tricolor será campeão.", new AuthorDTO(user1));

        user.setPosts(Arrays.asList(post));
        user1.setPosts(Arrays.asList(post1));
        postRepository.saveAll(Arrays.asList(post, post1));
        userRepository.saveAll(Arrays.asList(user,user1));
    }
}
