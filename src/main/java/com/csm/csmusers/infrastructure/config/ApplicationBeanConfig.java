package com.csm.csmusers.infrastructure.config;

import com.csm.csmusers.domain.UsersDomainService;
import com.csm.csmusers.domain.ports.UsersRepository;
import com.csm.csmusers.infrastructure.adapters.UsersRepositoryImpl;
import com.csm.csmusers.infrastructure.repository.UserJPARepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ApplicationBeanConfig {

    @Bean
    public UsersRepositoryImpl usersRepositoryImpl(UserJPARepository userJPARepository) {
        return new UsersRepositoryImpl(userJPARepository);
    }
    @Bean
    public UsersRepository usersRepository(UserJPARepository userJPARepository) {
        return new UsersRepositoryImpl(userJPARepository);
    }

    @Bean
    public UsersDomainService usersDomainService(UsersRepository usersRepository) {
        return new UsersDomainService(usersRepository);
    }


}
