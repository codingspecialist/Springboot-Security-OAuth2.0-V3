package com.cos.blog.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService{

	private final UserRepository UserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("/login 이 호출 되면 자동 실행되어 username이 DB에 있는지 확인한다.");
		User principal = UserRepository.findByUsername(username);
		
		if(principal == null) {
			return null;
		}else {
			//session.setAttribute("principal", principal);
			return new PrincipalDetails(principal);
		}
		
	}

}
