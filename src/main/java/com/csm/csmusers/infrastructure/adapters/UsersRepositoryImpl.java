package com.csm.csmusers.infrastructure.adapters;

import com.csm.csmusers.domain.ports.UsersRepository;
import com.csm.csmusers.infrastructure.repository.User;
import com.csm.csmusers.infrastructure.repository.UserJPARepository;
import com.csm.csmusers.infrastructure.web.UpdateUserRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsersRepositoryImpl implements UsersRepository {

    private final UserJPARepository userJPARepository;

    public boolean existsByUserLogin(String userLogin) {
        return userJPARepository.existsByUserLogin(userLogin);
    }

    @Override
    public User findByUserId(String userId) {
        return userJPARepository.findByUserId(userId);
    }

    @Override
    public User findByUserLogin(String login) {
        return userJPARepository.findByUserLogin(login);
    }

    @Override
    public void save(User newUser) {
        userJPARepository.save(newUser);
    }

    @Override
    public void updateUser(String userLogin, UpdateUserRequest request) {
        User user = userJPARepository.findByUserLogin(userLogin);
        user.setUserLogin(request.newLogin());
        user.setUserPassword(request.userPassword());
        userJPARepository.save(user);
    }

    @Override
    public void deleteUser(String userLogin) {
        userJPARepository.deleteByUserLogin(userLogin);
    }
}
