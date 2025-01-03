package com.jedward.workshopmongo.config;

import com.jedward.workshopmongo.domain.User;
import com.jedward.workshopmongo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@AllArgsConstructor
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User user = new User(null, "Jhonatan Edward", "jhonatan@gmail.com");
        User user1 = new User(null, "Uncle Bob", "uncle@gmail.com");
        userRepository.saveAll(Arrays.asList(user,user1));
    }
}
