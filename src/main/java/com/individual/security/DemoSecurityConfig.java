package com.individual.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
    // add support for JDBC ... no more hardcoded users:-)
    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource){
        //Next code is for my own tables for users and roles
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id,pw,active from members where user_id=?"
        );
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );
        //define query to retrieve the authorities / roles by username

        return jdbcUserDetailsManager;
    }

//
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception
    {
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/individuals").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/individuals/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/individuals").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/individuals").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/individuals/**").hasRole("ADMIN")
                );
        //USE basic security authentication
        http.httpBasic(Customizer.withDefaults());

        //disable Cross site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE, and /or PATCH
        http.csrf(csrf->csrf.disable());
        return http.build();

    }
    //
    //    @Bean
    //    public UserDetailsManager userDetailsManager (DataSource dataSource){
    //        //Spring boot know in your data base existing a table name call "users" and "authorities"
    //        return new JdbcUserDetailsManager(dataSource);
    //    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails hugo= User.builder()
//                .username("hugo")
//                .password("{noop}12345")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails mary= User.builder()
//                .username("mary")
//                .password("{noop}12345")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//
//        UserDetails veronica= User.builder()
//                .username("veronica")
//                .password("{noop}12345")
//                .roles("EMPLOYEE","MANAGER","ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(hugo,mary,veronica);
//
//    }
}
