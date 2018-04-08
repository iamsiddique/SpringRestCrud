package com.a2z.services;

import java.util.List;

import com.a2z.model.Inventory;
import com.a2z.services.exception.BusinessServiceException;

public interface InventoryService {

	List<Inventory> doGetInventoryByCourierCenter(Long courierCenterId) throws BusinessServiceException;

}
