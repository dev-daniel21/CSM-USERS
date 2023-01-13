package com.csm.csmusers.infrastructure.web;

import com.csm.csmusers.infrastructure.repository.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
class VerifyUsersEndpoint {

    private final VerificationService verificationService;

    VerifyUsersEndpoint(VerificationService verificationService) {
        this.verificationService = verificationService;
    }
//    "http://localhost:8310/verify?userId=%s&userPassword=%s", userId, password);

    @GetMapping("/verify")
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
    ResponseEntity<UserRegistrationResponse> registerNewUser(@RequestParam("userLogin") String userLogin,
                                                             @RequestParam("userPassword") String userPassword) {
        log.info("register user request received");
        return ResponseEntity.ok().body(verificationService.registerUser(userLogin, userPassword));
    }
}
