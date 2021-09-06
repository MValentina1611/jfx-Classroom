package model;

import javafx.scene.image.Image;

public class UserAccount {
	
	private String username;
	private String password;
	private String gender;
	private String career;
	private String birthday; 
	private String browser;
	private Image urlProfilePhoto;
	
	public UserAccount(String username, String password, String gender, String career, String birthday, String browser,
			Image urlProfilePhoto) {
		
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.career = career;
		this.birthday = birthday;
		this.browser = browser;
		this.urlProfilePhoto = urlProfilePhoto;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getGender() {
		return gender;
	}
	public String getCareer() {
		return career;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getBrowser() {
		return browser;
	}
	
	
	
	public Image getUrlProfilePhoto() {
		return urlProfilePhoto;
	}

	public void setUrlProfilePhoto(Image urlProfilePhoto) {
		this.urlProfilePhoto = urlProfilePhoto;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
	

}
