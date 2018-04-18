package com.a2z.services;

import java.util.List;

import com.a2z.model.CourierBoyInvoices;
import com.a2z.services.exception.BusinessServiceException;

public interface CourierBoyInvoicesService {

	void doSave(CourierBoyInvoices courierBoyInvoices) throws BusinessServiceException;
	List<CourierBoyInvoices> doGetAll() throws BusinessServiceException;
	CourierBoyInvoices doGetById(Long id) throws BusinessServiceException;
	void doUpdateStatus(Long courierBoyInvoicesId,Character status) throws BusinessServiceException;
	void doMarkPaid(List<CourierBoyInvoices> courierBoyInvoicesList) throws BusinessServiceException;
	List<CourierBoyInvoices> doGetByCourierboyid(Long courierBoyId) throws BusinessServiceException;
	List<CourierBoyInvoices> doGetByCourierboyidStatus(Long courierBoyId, Character status) throws BusinessServiceException;
	List<CourierBoyInvoices> doGetByUseridStatus(Long userId, Character status) throws BusinessServiceException;

}
