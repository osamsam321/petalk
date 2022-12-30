package com.ozi.petalk.security;
import org.hibernate.internal.log.SubSystemLogging;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RestController;

@EnableWebSecurity
@Configuration
public class SecurityConfig  {



	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		
		.httpBasic().disable()
		.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
		System.out.println("Inside of the security filter chain");
		return http.build();
	}

}