package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthProvider implements AuthenticationProvider {

	@Autowired
	AccountService accountService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println(authentication.getName());
		System.out.println(authentication.getCredentials());
	
		String id = authentication.getName();
		String pw = (String) authentication.getCredentials();
		
		String pw_answer = accountService.getPw(id);
		System.out.println(pw_answer);
		if(pw_answer.equals(pw)) {
			List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
			result.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

			return new UsernamePasswordAuthenticationToken(new Account(), authentication.getCredentials(), result);
		} else {
			throw new BadCredentialsException("비밀번호 안맞음");
		}
		
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
//		System.out.println(authentication);
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
