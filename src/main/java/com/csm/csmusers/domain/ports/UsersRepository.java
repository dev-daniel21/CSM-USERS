package com.csm.csmusers.domain.ports;

import com.csm.csmusers.infrastructure.repository.User;

public interface UsersRepository {
    User findByUserId(String userId);

    User findByUserLogin(String login);

}
