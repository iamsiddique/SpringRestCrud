package com.a2z.dao;

import java.util.List;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.Inventory;

public interface InventoryDAO {
	void saveInventory(Inventory inventory) throws DataServiceException;
	List<Inventory> getAllInventories() throws DataServiceException;
	Inventory getInventoryById(Long id) throws DataServiceException;
	void updateInventory(Inventory inventory) throws DataServiceException;
}
