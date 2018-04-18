package com.a2z.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a2z.dao.CourierBoyDAO;
import com.a2z.dao.CourierBoyInvoicesDAO;
import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.CourierBoyInvoices;
import com.a2z.services.exception.BusinessServiceException;

@Service
public class CourierBoyInvoicesServiceImpl implements CourierBoyInvoicesService {

	@Autowired
	CourierBoyInvoicesDAO courierBoyInvoicesDAO;
	
	@Autowired
	CourierBoyDAO courierBoyDAO;

	@Override
	@Transactional
	public void doSave(CourierBoyInvoices courierBoyInvoices) throws BusinessServiceException {
		try {
			Long courierBoyId = courierBoyDAO.getCourierBoyIdByUserById(courierBoyInvoices.getCourierBoy().getUser().getId());
			courierBoyInvoices.getCourierBoy().setId(courierBoyId);
			courierBoyInvoices.getCourierBoy().setUser(null);
			courierBoyInvoices.setAssignedDate(new Date());
			courierBoyInvoices.setCourierStatus('A');
			courierBoyInvoicesDAO.save(courierBoyInvoices);

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		
	}

	@Override
	@Transactional
	public List<CourierBoyInvoices> doGetAll() throws BusinessServiceException {
		List<CourierBoyInvoices> courierBoyInvoicesList = null;
		try {
			courierBoyInvoicesList = courierBoyInvoicesDAO.getAll();
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return courierBoyInvoicesList;
	}

	@Override
	@Transactional
	public CourierBoyInvoices doGetById(Long id) throws BusinessServiceException {
		CourierBoyInvoices courierBoyInvoices = null;
		try {
			courierBoyInvoices = courierBoyInvoicesDAO.getById(id);
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return courierBoyInvoices;
	}

	@Override
	@Transactional
	public void doUpdateStatus(Long courierBoyInvoicesId,Character status) throws BusinessServiceException {
		try {
			CourierBoyInvoices courierBoyInvoicesFromDao = courierBoyInvoicesDAO.getById(courierBoyInvoicesId);
			courierBoyInvoicesFromDao.setCourierStatus(status);
			if(status=='D'){
				courierBoyInvoicesFromDao.setDeliveredDate(new Date());
			}
			if(status=='P'){
				courierBoyInvoicesFromDao.setPaymentDate(new Date());
				courierBoyInvoicesFromDao.setAmount(10L);
			}
			
			courierBoyInvoicesDAO.update(courierBoyInvoicesFromDao);
			
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		
		
	}

	@Override
	@Transactional
	public List<CourierBoyInvoices> doGetByCourierboyid(Long courierBoyId) throws BusinessServiceException {
		List<CourierBoyInvoices> courierBoyInvoicesList = null;
		try {
			courierBoyInvoicesList = courierBoyInvoicesDAO.getByCourierboyid(courierBoyId);
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return courierBoyInvoicesList;
	}

	@Override
	@Transactional
	public List<CourierBoyInvoices> doGetByCourierboyidStatus(Long courierBoyId, Character status)
			throws BusinessServiceException {
		List<CourierBoyInvoices> courierBoyInvoicesList = null;
		try {
			courierBoyInvoicesList = courierBoyInvoicesDAO.getByCourierboyidStatus(courierBoyId, status);
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return courierBoyInvoicesList;
	}
	
	@Override
	@Transactional
	public List<CourierBoyInvoices> doGetByUseridStatus(Long userId, Character status)
			throws BusinessServiceException {
		List<CourierBoyInvoices> courierBoyInvoicesList = null;
		try {
			courierBoyInvoicesList = courierBoyInvoicesDAO.getByUseridStatus(userId, status);
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return courierBoyInvoicesList;
	}

	@Override
	@Transactional
	public void doMarkPaid(List<CourierBoyInvoices> courierBoyInvoicesList) throws BusinessServiceException {
		try {
			for(CourierBoyInvoices courierBoyInvoices : courierBoyInvoicesList){
				 	CourierBoyInvoices courierBoyInvoicesFromDao = courierBoyInvoicesDAO.getById(courierBoyInvoices.getId());
				    courierBoyInvoicesFromDao.setCourierStatus('P');
					courierBoyInvoicesFromDao.setPaymentDate(new Date());
					courierBoyInvoicesFromDao.setAmount(10L);
					courierBoyInvoicesDAO.update(courierBoyInvoicesFromDao);
			}
			   
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		
	}

}




