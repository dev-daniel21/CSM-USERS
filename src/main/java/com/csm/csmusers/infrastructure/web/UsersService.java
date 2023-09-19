package com.csm.csmusers.infrastructure.web;

import com.csm.csmusers.domain.UsersDomainService;
import com.csm.csmusers.infrastructure.repository.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersService {

    private final UsersDomainService usersDomainService;

    UserAuthenticationResponse verifyPassword(String userId, String userPassword) {

        User user = usersDomainService.findByUserId(userId);

        if (user != null && user.getUserPassword().equals(userPassword)) {
            return new UserAuthenticationResponse(userId, true);
        }

        return new UserAuthenticationResponse(userId, false);
    }

    public User getUser(String userId) {
        return usersDomainService.findByUserId(userId);
    }

    public ResponseEntity<String> registerUser(String userLogin, String userPassword) {

        if (!usersDomainService.existsByUserLogin(userLogin)) {
            User newUser = new User(UUID.randomUUID().toString(), userLogin, userPassword);
            usersDomainService.save(newUser);
            var resp = new UserResponse(newUser.getUserId());
            return ResponseEntity.ok().body(resp.getResponse());
        }
        return ResponseEntity.badRequest().body("User already registered");
    }

    public UserResponse updateUser(String userLogin, UpdateUserRequest request) {
        if (Objects.nonNull(usersDomainService.findByUserLogin(userLogin))) {
            usersDomainService.updateUser(userLogin, request);
            return new UserResponse("User's data updated");
        } else {
            return new UserResponse("User not found");
        }
    }

    public void deleteUser(String userLogin) {
        usersDomainService.deleteUser(userLogin);
    }
}
