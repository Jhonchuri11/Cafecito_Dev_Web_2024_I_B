package com.cafecitoDev.cafecito.persitence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain tesSecurityFilte(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeRequests(ath->
                        ath.requestMatchers("/**").permitAll()
                )
                .csrf().disable().build();
    }
}
