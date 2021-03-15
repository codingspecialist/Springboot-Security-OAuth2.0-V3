package com.cos.blog.config.oauth;

import java.util.Map;

public class KakaoInfo extends OAuth2UserInfo{

	public KakaoInfo(Map<String, Object> attributes) {
		super(attributes);
	}

	@Override
	public String getId() {
		return attributes.get("id").toString();
	}

	@Override
	public String getName() {
		Map<String, Object> temp = (Map)attributes.get("properties");
		return (String)temp.get("nickname");
	}

	@Override
	public String getEmail() {
		Map<String, Object> temp = (Map)attributes.get("kakao_account");
		return (String)temp.get("email");
	}

	@Override
	public String getImageUrl() {
		Map<String, Object> temp = (Map)attributes.get("properties");
		
		return (String)temp.get("profile_image");
	}

	@Override
	public String getUsername() {
		return "Kakao_"+attributes.get("id").toString();
	}

}
