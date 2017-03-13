package com.a2z.vo;

import java.util.List;

import com.a2z.model.StockDispatch;
import com.a2z.model.StockDispatchProduct;

public class StockDispatchVO {

	private StockDispatch invoiceDetails;
	private List<StockDispatchProduct> products;
	
	public List<StockDispatchProduct> getProducts() {
		return products;
	}
	public void setProducts(List<StockDispatchProduct> products) {
		this.products = products;
	}
	public StockDispatch getInvoiceDetails() {
		return invoiceDetails;
	}
	public void setInvoiceDetails(StockDispatch invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}
	
	
	
}
