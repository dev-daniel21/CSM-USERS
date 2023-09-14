package com.csm.csmusers;

import com.csm.csmusers.infrastructure.repository.UserJPARepository;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CsmUsersApplicationTests {

	@Autowired
	UserJPARepository userJPARepository;

	@Test
	void contextLoads() {
	}

	@Test
	void should_find_two_users() {
		// given
		// when
	    long count = userJPARepository.count();

		// then
		assertThat(count).isEqualTo(2);
	}

}
