package com.a2z.dao;

import java.util.List;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.CourierBoyInvoices;

public interface CourierBoyInvoicesDAO {
	void save(CourierBoyInvoices courierBoyInvoices) throws DataServiceException;
	List<CourierBoyInvoices> getAll() throws DataServiceException;
	CourierBoyInvoices getById(Long id) throws DataServiceException;
	void update(CourierBoyInvoices courierBoyInvoices) throws DataServiceException;
	List<CourierBoyInvoices> getByCourierboyid(Long courierBoyId) throws DataServiceException;
	List<CourierBoyInvoices> getByCourierboyidStatus(Long courierBoyId,Character status) throws DataServiceException;
	List<CourierBoyInvoices> getByUseridStatus(Long userId, Character status) throws DataServiceException;
}
