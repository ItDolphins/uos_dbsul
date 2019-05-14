package com.example.demo.config;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    private AuthProvider authenticationProvider;
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/img/**").permitAll()
                .antMatchers("/").hasRole("MAIN_ADMIN")
//                .antMatchers("/auth/admin/**").hasRole("ROLE_ADMIN")
//                .antMatchers("/auth/**").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
                .anyRequest().authenticated();
 
        http.formLogin()
	        .loginPage("/login") // default
	        .loginProcessingUrl("/authenticate")
	        .failureUrl("/login?error") // default
	        .defaultSuccessUrl("/home")
	        .usernameParameter("email")
	        .passwordParameter("password")
	        .permitAll();
 
        http.logout()
                .logoutUrl("/logout") // default
                .logoutSuccessUrl("/login")
                .permitAll();
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }
}*/