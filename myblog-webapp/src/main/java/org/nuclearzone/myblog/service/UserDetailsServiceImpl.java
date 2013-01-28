package org.nuclearzone.myblog.service;

import java.util.Collection;
import java.util.Collections;

import org.nuclearzone.myblog.domain.BlogUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private BlogUserService userService; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BlogUser myblogUser = userService.findByUsername(username);
		User user = new org.springframework.security.core.userdetails.User(myblogUser.getUsername(), myblogUser.getPassword(), getAuthorities(myblogUser));
		return user;
	}

	private Collection<SimpleGrantedAuthority> getAuthorities(BlogUser user) {	
		return Collections.singleton(user.isAdmin() ? new SimpleGrantedAuthority("ROLE_ADMIN") : new SimpleGrantedAuthority("ROLE_USER"));
	}
}
