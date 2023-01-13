package com.csm.csmusers.infrastructure.dbinit;


import com.csm.csmusers.infrastructure.repository.User;
import com.csm.csmusers.infrastructure.repository.UserJPARepository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseInitInserts implements CommandLineRunner {

    private final UserJPARepository userJPARepository;

    @Override
    public void run(String... args) {
        userJPARepository.deleteAll();

        userJPARepository.save(
                    new User("9ea220bd-54ac-4633-a271-89e59c36e161", "user1", "xyz"));

        User user = userJPARepository.findByUserLogin("user1");

        System.out.println("Application started");
        System.out.println("users in db: " + user.getUserLogin() + " " + user.getUserId());
    }
}
