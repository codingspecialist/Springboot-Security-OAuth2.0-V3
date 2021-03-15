package com.cos.blog.config.oauth;


import java.util.Map;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.cos.blog.config.auth.PrincipalDetails;
import com.cos.blog.domain.user.RoleType;
import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OAuth2DetailsService extends DefaultOAuth2UserService{

	private final UserRepository userRepository;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println("OAuth 로그인 진행중................");
		System.out.println(userRequest.getAccessToken().getTokenValue());
		
		
		// 1. AccessToekn으로 회원정보를 받았다는 의미
		
		OAuth2User oauth2User = super.loadUser(userRequest);
		
		// 레트로핏 https://www.googleapis.com/drive/v2/files?access_token=userRequest.getAccessToken().getTokenValue()
		System.out.println("=========================================");
		System.out.println(oauth2User.getAttributes());
		System.out.println("=========================================");
		
		return processOAuth2User(userRequest, oauth2User);
	}
	
	// 구글 로그인 프로세스
	private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oauth2User) {
		// 1번 통합 클래스를 생성

		System.out.println("머로 로그인 됐지? "+userRequest.getClientRegistration().getClientName());
		OAuth2UserInfo oAuth2UserInfo = null;
		if(userRequest.getClientRegistration().getClientName().equals("Google")) {
			oAuth2UserInfo = new GoogleInfo(oauth2User.getAttributes());
		}else if(userRequest.getClientRegistration().getClientName().equals("Facebook")) {
			oAuth2UserInfo = new FacebookInfo(oauth2User.getAttributes());
		}else if(userRequest.getClientRegistration().getClientName().equals("Naver")) {
			oAuth2UserInfo = new NaverInfo((Map)(oauth2User.getAttributes().get("response")));
		}else if(userRequest.getClientRegistration().getClientName().equals("Kakao")) {
			oAuth2UserInfo = new KakaoInfo((Map)(oauth2User.getAttributes()));
		}
		
		// 2번 최초 : 회원가입 + 로그인 최초X : 로그인
		User userEntity = userRepository.findByUsername(oAuth2UserInfo.getUsername());
		
		UUID uuid = UUID.randomUUID();
		String encPassword = new BCryptPasswordEncoder().encode(uuid.toString());
		
		System.out.println("네이버 이메일 : "+oAuth2UserInfo.getEmail());
		if(userEntity == null) {
			System.out.println("최초 사용자입니다. 자동 회원가입을 진행 후 자동 로그인 합니다.");
			User user = User.builder()
					.username(oAuth2UserInfo.getUsername())
					.password(encPassword)
					.email(oAuth2UserInfo.getEmail())
					.role(RoleType.USER)
					.build();
			userEntity = userRepository.save(user);
			return new PrincipalDetails(userEntity, oauth2User.getAttributes());
		}else { // 이미 회원가입이 완료됐다는 뜻(원래는 구글 정보가 변경될 수 있기 때문에 update 해야되는데 지금은 안하겠음)
			System.out.println("회원정보가 있습니다. 바로 로그인 합니다.");
			return new PrincipalDetails(userEntity, oauth2User.getAttributes());
		}
		
		
	}

}
