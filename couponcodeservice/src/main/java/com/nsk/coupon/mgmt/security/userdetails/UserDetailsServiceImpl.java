package com.nsk.coupon.mgmt.security.userdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nsk.coupon.mgmt.security.pojo.User;
import com.nsk.coupon.mgmt.security.repos.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);

		if (user != null) {

			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
					user.getRoles());
		} else {
			throw new UsernameNotFoundException("Please enter Valid Username and Password");
		}
	}

}
