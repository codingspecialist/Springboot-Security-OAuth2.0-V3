package com.cos.blog.web.user.dto;

import lombok.Data;

@Data
public class UserUpdateReqDto {
	private String username;
	private String password;
	private String email;
	
	// toEntity 안만드는 이유는 더티체킹 할것이기 때문!!
}
