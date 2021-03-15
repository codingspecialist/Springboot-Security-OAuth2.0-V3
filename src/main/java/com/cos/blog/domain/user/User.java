package com.cos.blog.domain.user;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // 시퀀스, auto_increment
	 
	@Column(nullable = false, length = 100, unique = true) 
	private String username;
	
	@Column(nullable = true, length = 100) // 123456 => 해쉬 (비밀번호 암호화)
	private String password;
	
	@Column(nullable = false, length = 50) 
	private String email;
	
	@Enumerated(EnumType.STRING)
	private RoleType role; // ADMIN, USER
	
	@CreationTimestamp
	private Timestamp createDate;

}
