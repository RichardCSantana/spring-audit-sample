package com.richardcsantana.config;

import com.richardcsantana.utils.PersonalDateProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by richardsantana on 23/03/16.
 */
@Configuration
@EnableJpaAuditing(dateTimeProviderRef = "personalDateProvider")
public class AuditConfiguration {

    @Bean
    DateTimeProvider personalDateProvider(){
        return new PersonalDateProvider();
    }
}
