package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    private AuthProvider authenticationProvider;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable().headers().disable();
        http.authorizeRequests()
                .antMatchers("/resources/css/**", "/resources/js/**", "/resources/img/**").permitAll()
                .antMatchers("/").hasAnyRole("ADMIN","USER")
//                .antMatchers("/auth/admin/**").hasRole("ROLE_ADMIN")
//                .antMatchers("/auth/**").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
                .anyRequest().authenticated();
 
        http.formLogin()
	        .loginPage("/login") // default
	        .loginProcessingUrl("/authenticate")
	        .failureUrl("/login?error") // default
	        .defaultSuccessUrl("/home")
	        .usernameParameter("id")
	        .passwordParameter("pw")
	        .permitAll();
 
        http.logout()
                .logoutUrl("/logout") // default
                .logoutSuccessUrl("/login")
                .permitAll();
        
        http.authenticationProvider(authenticationProvider);
    }
    
    
 
}