package com.example.demo.config;

import java.util.*;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.provisioning.*;
import org.springframework.security.web.*;

@Configuration
public class MyConfig2 {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.formLogin()
		.loginPage("/sub33/mylogin")
//		.usernameParameter("id")
//		.passwordParameter("pw")
		.defaultSuccessUrl("/sub32/link3", true);
		
		http.csrf().disable();
		
		http.authorizeHttpRequests().requestMatchers("/abc").authenticated();
		http.authorizeHttpRequests().anyRequest().permitAll();
		
		return http.build();
	}
	@Bean
	public UserDetailsService detailsService() {
		
		UserDetails user1 = User.builder()
				.username("user1")
				.password(passwordEncoder().encode("pw1"))
				.authorities(List.of())
				.build();
		UserDetails user2 = User.builder()
				.username("user2")
				.password(passwordEncoder().encode("pw2"))
				.authorities(List.of())
				.build();
		return new InMemoryUserDetailsManager(user1, user2);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
