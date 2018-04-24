package com.a2z.vo;

import com.a2z.model.CourierBoy;

public class CourierBoyDetailsVO {

	private CourierBoy courierBoy;
	private Long assigned;
	private Long delivered;
	private Long paid;

	public CourierBoy getCourierBoy() {
		return courierBoy;
	}

	public void setCourierBoy(CourierBoy courierBoy) {
		this.courierBoy = courierBoy;
	}

	public Long getAssigned() {
		return assigned;
	}

	public void setAssigned(Long assigned) {
		this.assigned = assigned;
	}

	public Long getDelivered() {
		return delivered;
	}

	public void setDelivered(Long delivered) {
		this.delivered = delivered;
	}

	public Long getPaid() {
		return paid;
	}

	public void setPaid(Long paid) {
		this.paid = paid;
	}

}
