package com.a2z.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private Long id;

	@Column(name="name")
	private String name;
	
	@Column(name="code")
	private String code;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="updated_on")
	private Date updatedOn;

	@Column(name="photo_file_name")
	private String photoFileName;

	@Column(name="photo_unique_file_name")
	private String photoUniqueFileName;
	
	@Column(name="cost")
	private Long cost;
	
	@Column(name="sgst")
	private Integer sgst;
	
	@Column(name="cgst")
	private Integer cgst;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoUniqueFileName() {
		return photoUniqueFileName;
	}

	public void setPhotoUniqueFileName(String photoUniqueFileName) {
		this.photoUniqueFileName = photoUniqueFileName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public Integer getSgst() {
		return sgst;
	}

	public void setSgst(Integer sgst) {
		this.sgst = sgst;
	}

	public Integer getCgst() {
		return cgst;
	}

	public void setCgst(Integer cgst) {
		this.cgst = cgst;
	}

}
