package com.spring.jwt.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetails implements UserDetails {

	private String userId;
	private String username;
	private String password;
	private String token;
	private boolean accountLocked;
	private boolean enabled;
	private List<GrantedAuthority> roles;

	
	

	public JwtUserDetails(String userId, String username, String token, List<GrantedAuthority> roles) {
		super();
		this.userId = userId;
		this.username = username;
		this.token = token;
		this.roles = roles;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4278300443145080276L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return false;
	}

	@Override
	public boolean isAccountNonLocked() {

		return accountLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return false;
	}

	@Override
	public boolean isEnabled() {

		return enabled;
	}

	public boolean isAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JwtUserDetails [username=" + username + ", password=" + password + ", accountLocked=" + accountLocked
				+ ", enabled=" + enabled + "]";
	}

}
