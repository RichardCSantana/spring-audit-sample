package com.richardcsantana.config;

import com.richardcsantana.utils.PersonalDateProvider;
import com.richardcsantana.utils.SpringSecurityAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by richardsantana on 23/03/16.
 */
@Configuration
@EnableJpaAuditing(dateTimeProviderRef = "personalDateProvider")
public class AuditConfiguration {

    @Bean
    AuditorAware<String> auditorProvider(){
        return new SpringSecurityAuditorAware();
    }

    @Bean
    DateTimeProvider personalDateProvider(){
        return new PersonalDateProvider();
    }
}
