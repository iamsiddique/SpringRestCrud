package com.a2z.services;

import java.util.List;

import com.a2z.model.StockEntry;
import com.a2z.services.exception.BusinessServiceException;

public interface StockEntryService {
	void doSaveStockEntry(StockEntry stockEntry) throws Exception;
	List<StockEntry> doGetAllStockEntries() throws BusinessServiceException;
	List<StockEntry> doGetStockEntriesByCourierCenter(Long courierCenterId) throws BusinessServiceException;
	StockEntry doGetStockEntryById(Long id) throws BusinessServiceException;
	void doUpdateStockEntry(StockEntry stockEntry) throws BusinessServiceException;
}
