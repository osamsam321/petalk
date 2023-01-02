package com.ozi.petalk.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig  {



	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		.cors().and().csrf().disable()
		.httpBasic().disable()
		.authorizeRequests().anyRequest().permitAll();
		System.out.println("Inside of the security filter chain");
		return http.build();
	}

}