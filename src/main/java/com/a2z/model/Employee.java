package com.a2z.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="employees")

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private Long id;

	@Column(name="alternate_number")
	private String alternateNumber;

	@Column(name="current_address")
	private String currentAddress;


	@Column(name="dl_unique_file_name")
	private String dlUniqueFileName;
	
	@Column(name="dl_file_name")
	private String dlFileName;

	@Column(name="first_name")
	private String firstName;

	
	@Column(name="last_name")
	private String lastName;

	@Column(name="mobile_number")
	private String mobileNumber;

	@Column(name="permanent_address")
	private String permanentAddress;

	@Column(name="photo_unique_file_name")
	private String photoUniqueFileName;

	@Column(name="photo_file_name")
	private String photoFileName;

	@Column(name="pan_unique_file_name")
	private String panUniqueFileName;

	@Column(name="pan_file_name")
	private String panFileName;

	
	@Column(name="bank_account_holder_name")
	private String bankAccountHolderName;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="bank_account_number")
	private String bankAccountNumber;
	
	@Column(name="bank_ifsc_code")
	private String bankIfscCode;
	
	private Integer enable;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Employee() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlternateNumber() {
		return this.alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	public String getCurrentAddress() {
		return this.currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getDlUniqueFileName() {
		return this.dlUniqueFileName;
	}

	public void setDlUniqueFileName(String dlUniqueFileName) {
		this.dlUniqueFileName = dlUniqueFileName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPermanentAddress() {
		return this.permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPhotoUniqueFileName() {
		return this.photoUniqueFileName;
	}

	public void setPhotoUniqueFileName(String photoUniqueFileName) {
		this.photoUniqueFileName = photoUniqueFileName;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBankAccountHolderName() {
		return bankAccountHolderName;
	}

	public void setBankAccountHolderName(String bankAccountHolderName) {
		this.bankAccountHolderName = bankAccountHolderName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankIfscCode() {
		return bankIfscCode;
	}

	public void setBankIfscCode(String bankIfscCode) {
		this.bankIfscCode = bankIfscCode;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getDlFileName() {
		return dlFileName;
	}

	public void setDlFileName(String dlFileName) {
		this.dlFileName = dlFileName;
	}


	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPanUniqueFileName() {
		return panUniqueFileName;
	}

	public void setPanUniqueFileName(String panUniqueFileName) {
		this.panUniqueFileName = panUniqueFileName;
	}

	public String getPanFileName() {
		return panFileName;
	}

	public void setPanFileName(String panFileName) {
		this.panFileName = panFileName;
	}

}