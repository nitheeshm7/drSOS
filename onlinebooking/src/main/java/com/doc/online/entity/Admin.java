package com.doc.online.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.doc.online.utilties.MD5HashingService;

@Entity
public class Admin {

	@Transient
	MD5HashingService md5HashingService = new MD5HashingService();

	@Id
	@GenericGenerator(name = "seq_adminId", strategy = "com.doc.online.idgenerators.AdminIdGenerator")
	@GeneratedValue(generator = "seq_adminId")
	private String adminId;
	private String adminName;
	private String adminPassword;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}
