package com.nsk.coupon.mgmt.security.websecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nsk.coupon.mgmt.security.userdetails.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "coupon-api/coupons/**").hasAnyRole("USER", "ADMIN")
				.mvcMatchers(HttpMethod.POST, "coupon-api/coupons").hasRole("ADMIN").and().csrf().disable();

	}

	@Bean
	public PasswordEncoder bcryptyPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
