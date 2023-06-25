package com.example.java.metrics.infrastructure.security.config;

import com.example.java.metrics.infrastructure.security.filter.JwtAuthenticationFilter;
import com.example.java.metrics.infrastructure.security.repository.UserDetailsRepository;
import com.example.java.metrics.infrastructure.security.service.CustomUserDetailsService;
import com.example.java.metrics.infrastructure.security.service.JwtAccessTokenService;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.security.Key;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@Profile("!local")
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChainConfig(
            final HttpSecurity http,
            final JwtAccessTokenService jwtTokenService,
            final UserDetailsRepository userDetailsRepository
    ) throws Exception {
        return http.authorizeHttpRequests((requests) -> {
            try {
                requests.requestMatchers(POST, "/login", "/user/create").permitAll()
                        .requestMatchers(GET, "/course", "/actuator", "/actuator/**").permitAll()
                        .anyRequest().authenticated()
                        .and().csrf().disable()
                        .sessionManagement().sessionCreationPolicy(STATELESS)
                        .and().addFilterBefore(
                                new JwtAuthenticationFilter(jwtTokenService, userDetailsRepository),
                                UsernamePasswordAuthenticationFilter.class
                        );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).build();
    }

    @Bean
    public AuthenticationManager authenticationManagerConfig(
            final HttpSecurity http,
            final PasswordEncoder passwordEncoder,
            final CustomUserDetailsService userDetailsService
    ) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoderConfig() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Key keyConfig() {
        return Keys.secretKeyFor(HS256);
    }

}
