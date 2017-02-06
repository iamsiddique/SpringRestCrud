package com.a2z.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the courier_boys database table.
 * 
 */
@Entity
@Table(name="courier_boys")

public class CourierBoy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private Long id;

	@Column(name="alternate_number")
	private String alternateNumber;

	@Column(name="batch_number")
	private String batchNumber;

	@Column(name="current_address")
	private String currentAddress;

	@Column(name="dl_number")
	private String dlNumber;

	@Column(name="dl_unique_file_name")
	private String dlUniqueFileName;
	
	@Column(name="dl_file_name")
	private String dlFileName;

	@Column(name="first_name")
	private String firstName;

	@Column(name="insurance_unique_file_name")
	private String insuranceUniqueFileName;

	@Column(name="insurance_file_name")
	private String insuranceFileName;

	
	@Column(name="last_name")
	private String lastName;

	@Column(name="mobile_number")
	private String mobileNumber;

	@Column(name="permanent_address")
	private String permanentAddress;

	@Column(name="photo_unique_file_name")
	private String photoUniqueFileName;

	@Column(name="rc_unique_file_name")
	private String rcUniqueFileName;

	@Column(name="roadtax_unique_file_name")
	private String roadtaxUniqueFileName;

	@Column(name="photo_file_name")
	private String photoFileName;

	@Column(name="rc_file_name")
	private String rcFileName;

	@Column(name="roadtax_file_name")
	private String roadtaxFileName;

	
	
	@Column(name="vehicle_name")
	private String vehicleName;

	@Column(name="vehicle_type")
	private String vehicleType;

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

	public CourierBoy() {
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

	public String getBatchNumber() {
		return this.batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getCurrentAddress() {
		return this.currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getDlNumber() {
		return this.dlNumber;
	}

	public void setDlNumber(String dlNumber) {
		this.dlNumber = dlNumber;
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

	public String getInsuranceUniqueFileName() {
		return this.insuranceUniqueFileName;
	}

	public void setInsuranceUniqueFileName(String insuranceUniqueFileName) {
		this.insuranceUniqueFileName = insuranceUniqueFileName;
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

	public String getRcUniqueFileName() {
		return this.rcUniqueFileName;
	}

	public void setRcUniqueFileName(String rcUniqueFileName) {
		this.rcUniqueFileName = rcUniqueFileName;
	}

	public String getRoadtaxUniqueFileName() {
		return this.roadtaxUniqueFileName;
	}

	public void setRoadtaxUniqueFileName(String roadtaxUniqueFileName) {
		this.roadtaxUniqueFileName = roadtaxUniqueFileName;
	}



	public String getVehicleName() {
		return this.vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
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

	public String getInsuranceFileName() {
		return insuranceFileName;
	}

	public void setInsuranceFileName(String insuranceFileName) {
		this.insuranceFileName = insuranceFileName;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getRcFileName() {
		return rcFileName;
	}

	public void setRcFileName(String rcFileName) {
		this.rcFileName = rcFileName;
	}

	public String getRoadtaxFileName() {
		return roadtaxFileName;
	}

	public void setRoadtaxFileName(String roadtaxFileName) {
		this.roadtaxFileName = roadtaxFileName;
	} 

	
	

}