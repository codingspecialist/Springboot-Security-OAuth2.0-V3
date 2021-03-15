package com.cos.blog.config.oauth;

import java.util.Map;

public class GoogleInfo extends OAuth2UserInfo{

	public GoogleInfo(Map<String, Object> attributes) {
		super(attributes);
	}

	@Override
	public String getId() {
		return (String)attributes.get("sub");
	}

	@Override
	public String getName() {
		return (String)attributes.get("name");
	}

	@Override
	public String getEmail() {
		return (String)attributes.get("email");
	}

	@Override
	public String getImageUrl() {
		return (String)attributes.get("picture");
	}

	@Override
	public String getUsername() {
		return "Google_"+(String)attributes.get("sub");
	}

}
