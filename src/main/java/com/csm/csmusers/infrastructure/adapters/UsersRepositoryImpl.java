package com.csm.csmusers.infrastructure.adapters;

import com.csm.csmusers.domain.ports.UsersRepository;
import com.csm.csmusers.infrastructure.repository.User;
import com.csm.csmusers.infrastructure.repository.UserJPARepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsersRepositoryImpl implements UsersRepository {

    private final UserJPARepository userJPARepository;

    @Override
    public User findByUserLogin(String login) {
        return userJPARepository.findByUserLogin(login);
    }

    @Override
    public User findByUserId(String userId) {
        return userJPARepository.findByUserId(userId);
    }
}
