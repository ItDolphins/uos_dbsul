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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.demo.model.Account;
import com.example.demo.service.account.AccountService;

@Component
public class AuthProvider implements AuthenticationProvider {

	@Autowired
	AccountService accountService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//System.out.println(authentication.getName());
		//System.out.println(authentication.getCredentials());
		//System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		String id = authentication.getName();
		String pw = (String) authentication.getCredentials();

		Account account = accountService.getAccount(id);
		System.out.println(account.getPassword());
		if(account.getPassword().equals(pw)) {
			//Authentication request = new UsernamePasswordAuthenticationToken(id,pw);
			List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
			result.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			Authentication result2 =  new UsernamePasswordAuthenticationToken(account, authentication.getCredentials(), result);
			SecurityContextHolder.getContext().setAuthentication(result2);
			return result2;
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
