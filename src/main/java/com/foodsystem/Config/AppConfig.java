package com.foodsystem.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(Authorize -> Authorize
					.requestMatchers("/api/admin/**").hasAnyRole("RESTAURANT_OWNER","ADMIN")
					.requestMatchers("/api/**").authenticated()
					.anyRequest().permitAll()
					
					) 
		
		return null;
		
	}

}
