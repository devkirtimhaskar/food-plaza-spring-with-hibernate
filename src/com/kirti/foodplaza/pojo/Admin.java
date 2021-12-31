package com.kirti.foodplaza.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_22063")
public class Admin {

	@Id
	@Column
	private String adminEmailId;
	@Column
	private String adminPassword;
	
	public String getAdminEmailId() {
		return adminEmailId;
	}
	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "Admin [adminEmailId=" + adminEmailId + ", adminPassword=" + adminPassword + "]";
	}
	
	
}
