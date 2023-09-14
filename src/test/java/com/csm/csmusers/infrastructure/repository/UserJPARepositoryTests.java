package com.csm.csmusers.infrastructure.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ComponentScan(basePackages = "com.csm.csmusers.infrastructure.dbinit")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserJPARepositoryTests {

    @Autowired
    UserJPARepository userJPARepository;

    @Test
    @Order(1)
    @Commit
    void should_find_one_user_in_database_and_add_another() {
        // given
        long count = userJPARepository.count();

        // when
        userJPARepository.save(new User(UUID.randomUUID().toString(), "userX", "cvb"));

        // then
        long countAgain = userJPARepository.count();
        assertThat(count).isEqualTo(2);
        assertThat(countAgain).isEqualTo(3);
    }

    @Test
    @Order(2)
    void should_find_two_users_and_add_another() {
        // given
        long count = userJPARepository.count();

        // when
        userJPARepository.save(new User(UUID.randomUUID().toString(), "userY", "xyz"));

        // then
        long countAgain = userJPARepository.count();
        assertThat(count).isEqualTo(3);
        assertThat(countAgain).isEqualTo(4);
    }
}
