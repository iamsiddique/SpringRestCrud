package com.a2z.vo;

public class ChangePasswordVO {

	private String userName;
	private String existingPassword;
	private String newPassword;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getExistingPassword() {
		return existingPassword;
	}
	public void setExistingPassword(String existingPassword) {
		this.existingPassword = existingPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
	
}
