package com.csm.csmusers.domain.ports;

import com.csm.csmusers.infrastructure.repository.User;
import com.csm.csmusers.infrastructure.web.UpdateUserRequest;

public interface UsersRepository {

    boolean existsByUserLogin(String userLogin);

    User findByUserId(String userId);

    User findByUserLogin(String login);

    void save(User newUser);

    void updateUser(String userLogin, UpdateUserRequest request);

    void deleteUser(String userLogin);
}
