package com.example.demo.config;

/*import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.example.demo.model.Account;

@Component
public class AuthProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println(authentication.getName());
		System.out.println(authentication.getCredentials());
		
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
		result.add(new SimpleGrantedAuthority("ROLE_MAIN_ADMIN"));
		return new UsernamePasswordAuthenticationToken(new Account(), authentication.getCredentials(), result);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}*/
