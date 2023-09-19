package com.csm.csmusers.infrastructure.web;

import com.csm.csmusers.infrastructure.repository.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@Slf4j
class UsersEndpoint {

    private final UsersService verificationService;

    UsersEndpoint(UsersService verificationService) {
        this.verificationService = verificationService;
    }

    @GetMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<UserAuthenticationResponse> verifyUsersPassword(@RequestParam("userId") String userId,
                                                @RequestParam("userPassword") String userPassword) {
        log.info("verify user request received");
        return ResponseEntity.ok().body(verificationService.verifyPassword(userId, userPassword));
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<User> getUser(@PathVariable("userId") String userId) {
        log.info("get user request received");
        User user = verificationService.getUser(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/registerUser")
    ResponseEntity<String> registerNewUser(@RequestParam("userLogin") String userLogin,
                                                 @RequestParam("userPassword") String userPassword) {
        log.info("register user request received");

        return verificationService.registerUser(userLogin, userPassword);
    }

    @PutMapping("/updateUser")
    void updateUser(@RequestParam("userLogin") String userLogin, @RequestBody UpdateUserRequest request) {
        log.info("update user request received");
        verificationService.updateUser(userLogin, request);
    }

    @DeleteMapping("/deleteUser")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@RequestParam("userLogin") String userLogin) {
        log.info("delete user request received");
        verificationService.deleteUser(userLogin);
    }
}
