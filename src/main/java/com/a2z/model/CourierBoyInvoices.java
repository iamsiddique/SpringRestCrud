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
@Table(name="courier_boy_invoices")
public class CourierBoyInvoices implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private Long id;
	
	@Column(name="assigned_date")
	private Date assignedDate;
	
	@Column(name="returned_date")
	private Date returnedDate;
	
	@Column(name="courier_status")
	private Character courierStatus;
	
	@ManyToOne
	@JoinColumn(name="courier_boy_id")
	private CourierBoy courierBoy;
	
	@ManyToOne
	@JoinColumn(name="stock_dispatch_id")
	private StockDispatch stockDispatch;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	public CourierBoy getCourierBoy() {
		return courierBoy;
	}

	public void setCourierBoy(CourierBoy courierBoy) {
		this.courierBoy = courierBoy;
	}


	public Character getCourierStatus() {
		return courierStatus;
	}

	public void setCourierStatus(Character courierStatus) {
		this.courierStatus = courierStatus;
	}

	public StockDispatch getStockDispatch() {
		return stockDispatch;
	}

	public void setStockDispatch(StockDispatch stockDispatch) {
		this.stockDispatch = stockDispatch;
	}
	
	
	
	

	
		

}
