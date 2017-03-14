package com.a2z.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="stock_dispatch")
public class StockDispatch implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private Long id;
	
	@Column(name="to_addr")
	private String toAddress;
	
	@Column(name="invoice_date")
	private Date invoiceDate;

	@ManyToOne
	@JoinColumn(name="courier_center_id")
	private CourierCenter courierCenter;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CourierCenter getCourierCenter() {
		return courierCenter;
	}

	public void setCourierCenter(CourierCenter courierCenter) {
		this.courierCenter = courierCenter;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}


		

}
