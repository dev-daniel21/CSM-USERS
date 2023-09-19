package com.csm.csmusers.domain;

import com.csm.csmusers.domain.ports.UsersRepository;
import com.csm.csmusers.infrastructure.repository.User;
import com.csm.csmusers.infrastructure.web.UpdateUserRequest;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class UsersDomainService {

    private final UsersRepository usersRepository;

    public boolean existsByUserLogin(String userLogin) {
        return usersRepository.existsByUserLogin(userLogin);
    }

    public User findByUserId(String userId) {
        return usersRepository.findByUserId(userId);
    }

    public User findByUserLogin(String userLogin) {
        return usersRepository.findByUserLogin(userLogin);
    }

    public void save(User newUser) {
        usersRepository.save(newUser);
    }

    public void updateUser(String userLogin, UpdateUserRequest request) {
        usersRepository.updateUser(userLogin, request);
    }

    @Transactional
    public void deleteUser(String userLogin) {
        usersRepository.deleteUser(userLogin);
    }
}
