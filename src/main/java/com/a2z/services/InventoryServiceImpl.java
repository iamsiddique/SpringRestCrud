package com.a2z.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a2z.dao.InventoryDAO;
import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.Inventory;
import com.a2z.services.exception.BusinessServiceException;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryDAO inventoryDAO;



	@Override
	@Transactional
	public List<Inventory> doGetInventoryByCourierCenter(Long courierCenterId) throws BusinessServiceException {
		List<Inventory> inventoryList = null;
		try {
			inventoryList = inventoryDAO.getInventoryByCouriercenterid(courierCenterId);
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return inventoryList;
	}

}




