package com.csm.csmusers.infrastructure.web;

import com.csm.csmusers.domain.UsersDomainService;
import com.csm.csmusers.infrastructure.repository.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class VerificationService {

    private final UsersDomainService usersDomainService;

    UserAuthenticationResponse verifyPassword(String userId, String userPassword) {

        User user = usersDomainService.findByUserId(userId);

        if (user != null && user.getUserPassword().equals(userPassword)) {
            return new UserAuthenticationResponse(userId, true);
        }

        return new UserAuthenticationResponse(userId, false);
    }

    public UserRegistrationResponse registerUser(String userLogin, String userPassword) {
        User user = usersDomainService.findByUserLogin(userLogin);

        return null;
    }

    public User getUser(String userId) {
        return usersDomainService.findByUserId(userId);
    }
}
