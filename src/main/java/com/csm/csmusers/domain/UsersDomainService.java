package com.csm.csmusers.domain;

import com.csm.csmusers.domain.ports.UsersRepository;
import com.csm.csmusers.infrastructure.repository.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsersDomainService {

    private final UsersRepository usersRepository;


    public User findByUserId(String userId) {
        return usersRepository.findByUserId(userId);
    }

    public User findByUserLogin(String userLogin) {
        return usersRepository.findByUserLogin(userLogin);
    }
}
