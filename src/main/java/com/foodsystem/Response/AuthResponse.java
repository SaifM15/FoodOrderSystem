package com.foodsystem.Response;

import com.foodsystem.Model.USER_ROLE;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

	
	private String  jwt;
	
	private String message;
	
	private USER_ROLE role;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public USER_ROLE getRole() {
		return role;
	}

	public void setRole(USER_ROLE role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AuthResponse [jwt=" + jwt + ", message=" + message + ", role=" + role + "]";
	}

	public AuthResponse(String jwt, String message, USER_ROLE role) {
		super();
		this.jwt = jwt;
		this.message = message;
		this.role = role;
	}

	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
