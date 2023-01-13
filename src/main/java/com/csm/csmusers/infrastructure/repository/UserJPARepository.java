package com.csm.csmusers.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, Long> {

        User findByUserLogin(String login);


        User findByUserId(String userId);
}
