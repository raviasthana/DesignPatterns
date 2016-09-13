package com.indefsystems.dp.observer.demo1;

public class LoginFormEvent {
	
	private String userName;
	private char[] userPassword;
	
	public LoginFormEvent(String userName, char[] userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public char[] getUserPassword() {
		return userPassword;
	}
}
