package com.project.todo.authentication;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;	

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(passwordEncoder())
		.usersByUsernameQuery("select username, password, true from user where username=?")
		.authoritiesByUsernameQuery("select username, role from user where username=?");
		
		auth.eraseCredentials(false);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/*", "/signup", "/css/**", "/images/**").permitAll()
		.antMatchers("/todo/show").authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/todo/loginSuccess", true)
		.failureUrl("/login?error=true")
		.and()
		.logout()
		.permitAll()
		.and()
		.httpBasic()
		.and()
		.csrf()
		.disable();
		
	}
}
