package com.csm.csmusers.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, Long> {

        boolean existsByUserLogin(String userLogin);

        User findByUserLogin(String login);

        User findByUserId(String userId);

        void deleteByUserLogin(String userLogin);
}
