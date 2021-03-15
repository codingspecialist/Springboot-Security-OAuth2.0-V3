package com.cos.blog.web.auth.dto;

import com.cos.blog.domain.user.User;

import lombok.Data;

// Valid 나중에 처리하자.

@Data
public class AuthJoinReqDto {
	private String username;
	private String password;
	private String email;
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.build();
	}
}
