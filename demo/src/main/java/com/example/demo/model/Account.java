package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.*;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class Account implements UserDetails {

	private String username;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private Collection<? extends GrantedAuthority> authorities;


    @Override
    public boolean isAccountNonExpired() {
         return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
         return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
         return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
         return isEnabled;
    }


    public void setEnabled(boolean isEnabled) {
         this.isEnabled = isEnabled;
    }

}
