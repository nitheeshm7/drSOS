package com.doc.online.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.doc.online.utilties.MD5HashingService;

@Entity
public class Doctors {
	@Transient
	MD5HashingService md5HashingService = new MD5HashingService();

	@Id
	private String regNo;
	private String docName;
	private String docEmail;
	private String docPassword;
	private String docMobileNo;
	private String docLandNo;
	private String docWebsite;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private boolean active;

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocEmail() {
		return docEmail;
	}

	public void setDocEmail(String docEmail) {
		this.docEmail = docEmail;
	}

	public String getDocPassword() {
		return docPassword;
	}

	public void setDocPassword(String docPassword) {
		this.docPassword = md5HashingService.encryptString(docPassword);
	}

	public String getDocMobileNo() {
		return docMobileNo;
	}

	public void setDocMobileNo(String docMobileNo) {
		this.docMobileNo = docMobileNo;
	}

	public String getDocLandNo() {
		return docLandNo;
	}

	public void setDocLandNo(String docLandNo) {
		this.docLandNo = docLandNo;
	}

	public String getDocWebsite() {
		return docWebsite;
	}

	public void setDocWebsite(String docWebsite) {
		this.docWebsite = docWebsite;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
